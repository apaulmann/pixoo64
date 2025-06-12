package de.paulmannit;

import de.paulmannit.service.fonts.TextItem;
import jakarta.json.Json;
import jakarta.json.JsonObject;

public class PixooJsonUtil {
    public static JsonObject toJson(TextItem dto) {
        return Json.createObjectBuilder()
                .add("TextId", dto.getTextId())
                .add("type", dto.getType())
                .add("x", dto.getX())
                .add("y", dto.getY())
                .add("dir", dto.getDir())
                .add("font", dto.getFont())
                .add("TextWidth", dto.getTextWidth())
                .add("TextString", dto.getTextString()==null?"":dto.getTextString())
                .add("Textheight", dto.getTextHeight())
                .add("speed", dto.getSpeed())
                .add("align", dto.getColor())
                .add("color", dto.getColor())
                .build();
    }
}
