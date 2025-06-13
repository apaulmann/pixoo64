package de.paulmannit.resources;

import de.paulmannit.service.PixooService;
import de.paulmannit.service.fonts.*;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Path("/api/aux")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuxResource {
    @Inject
    PixooService pixooService;

    @POST
    @Path("sendTemplate")
    public Response sendTemplate() {
        try {
            Log.info("sendTemplate");
            LocalDateTime now = LocalDateTime.now();
            String[] WOCHENTAGE = {
                    "So.", "Mo.", "Di.", "Mi.", "Do.", "Fr.", "Sa."
            };
            DayOfWeek day = now.getDayOfWeek();
            String tag = WOCHENTAGE[day.getValue() % 7];

            pixooService.clear();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.", Locale.GERMAN);
            pixooService.drawTextLeft(tag + " " +now.format(formatter), 1, Color.Red, 1, new FontVari8());
            pixooService.drawLine(new Position(0, 7), new Position(64, 7), Color.White);
            pixooService.drawLine(new Position(0, 21), new Position(64, 21), Color.White);

            pixooService.drawTextLeft("XAU", 9, Color.AliceBlue, 1, new FontVari8());
            pixooService.drawTextLeft("USD", 15, Color.AliceBlue, 1, new FontVari8());
            pixooService.push();

            // Imageliste
            // Zeit
            List<TextItem> lst = new ArrayList<>();
            TextItem itemDatum = new TextItem();
            itemDatum.setTextId(1);
            itemDatum.setType(6);
            itemDatum.setX(37);
            itemDatum.setY(1);
            itemDatum.setDir(0);
            itemDatum.setFont(18);
            itemDatum.setTextWidth(32);
            itemDatum.setTextHeight(16);
            itemDatum.setSpeed(100);
            itemDatum.setAlign(1);
            itemDatum.setColor(Color.Red.toHex());
            lst.add(itemDatum);

            pixooService.sendItemList(lst);

            return Response.ok().build();
        } catch (Exception e) {
            Log.error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Map.of("error", e.getMessage())).build();
        }
    }

    @POST
    @Path("sendValue")
    public Response sendValue(AuxDto dto) {
        try {
            Log.info("sendValue");
            TextItem itemGold = new TextItem();
            itemGold.setTextId(2);
            itemGold.setType(0);
            itemGold.setX(17);
            itemGold.setY(6);
            itemGold.setDir(0);
            itemGold.setFont(4);
            itemGold.setTextWidth(64);
            itemGold.setTextHeight(16);
            itemGold.setSpeed(10);
            itemGold.setAlign(1);
            itemGold.setTextString(String.format("%.2f", dto.getValue()).replace(",", "."));
            if (dto.getIsClosed()) {
                itemGold.setColor(Color.Gray.toHex());
            }
            else {
                itemGold.setColor(Color.Yellow.toHex());
            }

            pixooService.sendHttpText(itemGold);

            return Response.ok().build();
        } catch (Exception e) {
            Log.error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Map.of("error", e.getMessage())).build();
        }
    }

    @POST
    @Path("sendAuxPositions")
    public Response sendValue(AuxPositionDto dto) {
        try {
            Log.info("sendAuxPositions");
            pixooService.drawRect(new Position(0, 23), new Position(64,34), Color.Black, true);
            pixooService.drawTextLeft("Heute", 23, Color.White, 1, new FontVari8());
            pixooService.drawTextRight(String.format("%.2f", dto.getProfitToday()).replace(",", "."),
                     23, (dto.getProfitToday()>=0?Color.Green: Color.Red), 2,new FontVari8());

            pixooService.drawTextLeft(dto.getMonth(), 29, Color.White, 1, new FontVari8());
            pixooService.drawTextRight(String.format("%.2f", dto.getProfitMonth()).replace(",", "."),
                    29, (dto.getProfitMonth()>=0?Color.Green: Color.Red), 2, new FontVari8());
            pixooService.push();

            return Response.ok().build();
        } catch (Exception e) {
            Log.error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Map.of("error", e.getMessage())).build();
        }
    }
}