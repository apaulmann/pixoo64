package de.paulmannit.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.paulmannit.PixooJsonUtil;
import de.paulmannit.client.PixooClient;
import de.paulmannit.service.fonts.Color;
import de.paulmannit.service.fonts.Font;
import de.paulmannit.service.fonts.Position;
import de.paulmannit.service.fonts.TextItem;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Base64;
import java.util.List;

@ApplicationScoped
public class PixooService {
    @Inject
    @RestClient
    PixooClient pixoo;

    private final int size;
    private byte[] buffer;
    private int counter = 0;
    private long pushCount = 0, pushAvgElapsed = 0;

    public PixooService(@ConfigProperty(name="pixoo.size") int size) {
        this.size = size;
        this.buffer = new byte[size * size * 3];
    }

    public void clear() {
        fill(Color.Black);
    }

    public void fill(Color color) {
        for (int i = 0; i < size * size; i++) {
            int idx = i * 3;
            buffer[idx] = (byte) color.r;
            buffer[idx+1] = (byte) color.g;
            buffer[idx+2] = (byte) color.b;
        }
    }

    public void drawPixel(int x, int y, Color color) {
        if (x<0||y<0||x>=size||y>=size) return;
        int idx = (y*size + x)*3;
        buffer[idx] = (byte) color.r;
        buffer[idx+1] = (byte) color.g;
        buffer[idx+2] = (byte) color.b;
    }

    public String toBase64() {
        return Base64.getEncoder().encodeToString(buffer);
    }

    public String sendHttpGif(int picNum, int picWidth, int picOffset, int picSpeed) {
        JsonObject body = Json.createObjectBuilder()
                .add("Command", "Draw/SendHttpGif")
                .add("PicNum", picNum)
                .add("PicWidth", picWidth)
                .add("PicOffset", picOffset)
                .add("PicID", counter++)
                .add("PicSpeed", picSpeed)
                .add("PicData", toBase64())
                .build();
        return send(body.toString());
    }

    public String sendHttpText(int textId, Position pos, int direction, int font, int width, int speed, String text, String color, int align) {
        JsonObject body = Json.createObjectBuilder()
                .add("Command", "Draw/SendHttpText")
                .add("TextId", textId)
                .add("x", pos.getX())
                .add("y", pos.getY())
                .add("dir", direction)
                .add("font", font)
                .add("TextWidth", width)
                .add("speed", speed)
                .add("TextString", text)
                .add("color", color)
                .add("align", align)
                .build();
        return send(body.toString());
    }

    public String sendHttpText(TextItem textItem) {
        JsonObject body = Json.createObjectBuilder()
                .add("Command", "Draw/SendHttpText")
                .add("TextId", textItem.getTextId())
                .add("x", textItem.getX())
                .add("y", textItem.getY())
                .add("dir", textItem.getDir())
                .add("font", textItem.getFont())
                .add("TextWidth", textItem.getTextWidth())
                .add("speed", textItem.getSpeed())
                .add("TextString", textItem.getTextString())
                .add("color", textItem.getColor())
                .add("align", textItem.getAlign())
                .build();
        return send(body.toString());
    }

    public void sendItemList(List<TextItem> items) {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (TextItem item : items) {
            arrayBuilder.add(PixooJsonUtil.toJson(item));
        }

        JsonObject body = Json.createObjectBuilder()
                .add("Command", "Draw/SendHttpItemList")
                .add("ItemList", arrayBuilder)
                .build();
        send(body.toString());
    }

    public void resetPicNum() {
        JsonObject body = Json.createObjectBuilder()
                .add("Command", "Draw/ResetHttpGifId")
                .build();
        send(body.toString());
    }

    public void setHourMode() {
        JsonObject body = Json.createObjectBuilder()
                .add("Command", "Device/SetTime24Flag")
                .add("Mode", 1)
                .build();
        send(body.toString());
    }


    public void setTimeInUTC() {
        ZoneId berlinZone = ZoneId.of("Europe/Berlin");
        ZonedDateTime nowInBerlin = ZonedDateTime.now(berlinZone);
        Instant utcInstant = nowInBerlin.toInstant();

        JsonObject body = Json.createObjectBuilder()
                .add("Command", "Device/SetUTC")
                .add("Utc", utcInstant.getEpochSecond())
                .build();
        send(body.toString());
    }

    public void setTimeZone() {
        ZoneId zoneId = ZoneId.of("Europe/Berlin");
        ZonedDateTime now = ZonedDateTime.now(zoneId);
        ZoneOffset offset = now.getOffset();
        int totalSeconds = offset.getTotalSeconds();
        int hours = totalSeconds / 3600;
        hours = hours*-1;

        JsonObject body = Json.createObjectBuilder()
                .add("Command", "Sys/TimeZone")
                .add("TimeZoneValue", String.format("GMT%+d", hours))
                .build();

        send(body.toString());
    }

    public void push() {
        long start = System.currentTimeMillis();
        var resp = sendHttpGif(1, size, 0, 1000);
        var elapsed = System.currentTimeMillis() - start;
        pushAvgElapsed = (pushAvgElapsed * pushCount + elapsed) / (++pushCount);
    }

    public void initialize() {
        counter = 0;
        resetPicNum();
        setTimeZone();
        setHourMode();
        setTimeInUTC();
        clear();
        push();
    }

    public void setBrightness(int brightness) {
        JsonObject body = Json.createObjectBuilder()
                .add("Command","Channel/SetBrightness")
                .add("Brightness", brightness)
                .build();
        send(body.toString());
    }

    public void reboot() {
        JsonObject body = Json.createObjectBuilder()
                .add("Command","Channel/SetBrightness")
                .add("Brightness", 100)
                .build();
        String response = pixoo.reboot(body);
    }

    public void drawImage(Path path, int posX, int posY, int w, int h) throws IOException {
        BufferedImage img = ImageIO.read(path.toFile());
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g = bi.createGraphics();
        g.drawImage(img, 0,0,w,h,null);
        g.dispose();
        byte[] pixels = ((DataBufferByte)bi.getRaster().getDataBuffer()).getData();
        for (int y=0; y<h; y++) {
            for (int x=0; x<w; x++) {
                int idx = (y*w + x)*3;
                drawPixel(posX + x, posY + y, new de.paulmannit.service.fonts.Color(
                        Byte.toUnsignedInt(pixels[idx+2]), // RGB reverse
                        Byte.toUnsignedInt(pixels[idx+1]),
                        Byte.toUnsignedInt(pixels[idx])));
            }
        }
    }

    public int getTextWidth(String text, Font font) {
        int width = 0;
        for (char c : text.toCharArray()) {
            int[] matrix = font.getCharMatrix(c);
            int charWidth = matrix.length / 5;
            width += charWidth + 1;
        }
        return width;
    }

    public void drawTextCenter(String text, int y, Color color, Font font) {
        int x = (size - getTextWidth(text, font)) / 2;
        drawText(text, new Position(x,y), color, font);
    }

    public void drawTextRight(String text, int y, Color color, int padding, Font font) {
        int x = size - getTextWidth(text, font) - padding;
        drawText(text, new Position(x, y), color, font);
    }

    public void drawTextLeft(String text, int y, Color color, int padding, Font font) {
        drawText(text, new Position(padding, y), color, font);
    }

    public void drawText(String text, Position pos, Color color, Font font) {
        int pixelSoFar = 0;
        for (char c : text.toCharArray()) {
            if (!font.containsChar(c)) c = '?';
            int[] charMatrix = font.getCharMatrix(c);
            int width = charMatrix.length / 5;
            drawChar(c, new Position(pos.getX() + pixelSoFar, pos.getY()), color, font);
            pixelSoFar += width + 1;
        }
    }

    public void drawChar(char c, Position pos, Color color, Font font) {
        int[] matrix = font.getCharMatrix(c);
        int width = matrix.length / 5;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == 1) {
                int x = i % width;
                int y = i / width;
                drawPixel(pos.getX() + x, pos.getY() + y, color);
            }
        }
    }

    public void drawRect(Position start, Position end, Color color, boolean fill) {
        for (int x = start.getX(); x < end.getX(); x++) {
            for (int y = start.getY(); y < end.getY(); y++) {
                if (fill || x == start.getX() || y == start.getY() || x == end.getX() - 1 || y == end.getY() - 1) {
                    drawPixel(x, y, color);
                }
            }
        }
    }

    public void drawLine(Position start, Position end, Color color) {
        int x0 = start.getX(), y0 = start.getY();
        int x1 = end.getX(), y1 = end.getY();
        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);
        int sx = x0 < x1 ? 1 : -1;
        int sy = y0 < y1 ? 1 : -1;
        int err = dx - dy;

        while (true) {
            drawPixel(x0, y0, color);
            if (x0 == x1 && y0 == y1) break;
            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x0 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y0 += sy;
            }
        }
    }

    public String send(String json) {
        Log.info("Sending to Pixoo: " + json);
        String response = pixoo.post(json);
        Log.info("Pixoo response: " + response);
        return response;
    }
}
