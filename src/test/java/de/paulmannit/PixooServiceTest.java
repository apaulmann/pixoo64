package de.paulmannit;

import de.paulmannit.service.PixooService;
import de.paulmannit.service.fonts.Color;
import de.paulmannit.service.fonts.FontVari8;
import de.paulmannit.service.fonts.Position;
import de.paulmannit.service.fonts.TextItem;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@QuarkusTest
class PixooServiceTest {

    @Inject
    PixooService pixooService;

    @Test
    void testInitialize() {
        pixooService.initialize();
        pixooService.setBrightness(80);

        /// Date
        LocalDateTime now = LocalDateTime.now();
        String[] DAYS = {
                "So.", "Mo.", "Di.", "Mi.", "Do.", "Fr.", "Sa."
        };
        DayOfWeek day = now.getDayOfWeek();
        String tag = DAYS[day.getValue() % 7];

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.", Locale.GERMAN);
        pixooService.drawTextLeft(tag + " " + now.format(formatter), 1, Color.Red, 1, new FontVari8());

        pixooService.drawRect(new Position(0, 6), new Position(64, 64), Color.Black, true);
        pixooService.drawLine(new Position(0, 7), new Position(64, 7), Color.White);
        pixooService.push();
        // Time
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

        // Text1
        TextItem item = new TextItem();
        item.setTextId(2);
        item.setX(1);
        item.setY(10);
        item.setDir(0);
        item.setFont(1);
        item.setTextWidth(64);
        item.setSpeed(10);
        item.setTextString("Hello Pixoo");
        item.setColor("#FF0000");
        item.setAlign(1);

        pixooService.sendHttpText(item);

        // Text2
        TextItem item2 = new TextItem();
        item2.setTextId(3);
        item2.setX(1);
        item2.setY(25);
        item2.setDir(0);
        item2.setFont(1);
        item2.setTextWidth(64);
        item2.setSpeed(8);
        item2.setTextString("Pixoo Rocks");
        item2.setColor("#00FF00");
        item2.setAlign(1);

        pixooService.sendHttpText(item2);

        pixooService.playBuzzer(500, 500, 1000);
    }
}