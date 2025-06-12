package de.paulmannit.resources;

import de.paulmannit.service.PixooService;
import de.paulmannit.service.fonts.Color;
import de.paulmannit.service.fonts.FontVari8;
import de.paulmannit.service.fonts.Position;
import de.paulmannit.service.fonts.TextItem;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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
            pixooService.clear();
            LocalDateTime now = LocalDateTime.now();
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
            Log.info("sendTemplate");
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
            itemGold.setTextString(String.format("%.2f%n", dto.getValue()));
            itemGold.setColor(Color.Yellow.toHex());

            pixooService.sendHttpText(itemGold);

            return Response.ok().build();
        } catch (Exception e) {
            Log.error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Map.of("error", e.getMessage())).build();
        }
    }
}