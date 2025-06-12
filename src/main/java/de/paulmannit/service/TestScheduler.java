package de.paulmannit.service;

import de.paulmannit.service.fonts.Color;
import de.paulmannit.service.fonts.FontVari8;
import de.paulmannit.service.fonts.Position;
import de.paulmannit.service.fonts.TextItem;
import io.quarkus.logging.Log;
import io.quarkus.runtime.Startup;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@ApplicationScoped
public class TestScheduler {

    @Inject
    PixooService pixooService;

    @Startup
    public void startup() {
        Log.info("TestScheduler started");
        pixooService.initialize();
//        pixooService.reboot();
//        pixooService.setBrightness(50);
        sendTemplate();
    }

    @Scheduled(cron = "0 1 0 * * ?")
    public void sendTemplate() {
        Log.info("sendTemplate");
        pixooService.clear();
        LocalDateTime now = LocalDateTime .now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE dd.MM.", Locale.GERMAN);
        pixooService.drawTextLeft(now.format(formatter), 1, Color.Red, 1, new FontVari8());
        pixooService.drawLine(new Position(0, 7), new Position(64, 7), Color.WhiteSmoke);

        pixooService.drawTextCenter("XAU-USD", 9, Color.AliceBlue, new FontVari8());
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
    }

    @Scheduled(every = "1s")
    public void push() {
        double kurs = 3332.1;
        double delta = ThreadLocalRandom.current().nextDouble(-20.0, 20.0);
        kurs += delta;

        // Gold Kurs
        TextItem itemGold = new TextItem();
        itemGold.setTextId(2);
        itemGold.setType(0);
        itemGold.setX(5);
        itemGold.setY(17);
        itemGold.setDir(0);
        itemGold.setFont(4);
        itemGold.setTextWidth(64);
        itemGold.setTextHeight(16);
        itemGold.setSpeed(10);
        itemGold.setAlign(1);
        itemGold.setTextString(String.format("%.2f%n", kurs));
        itemGold.setColor(Color.Yellow.toHex());

        pixooService.sendHttpText(itemGold);
    }
}
