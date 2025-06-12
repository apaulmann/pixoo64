package de.paulmannit.service.fonts;

import java.util.HashMap;
import java.util.Map;

public abstract class Font {
    protected final Map<Character, int[]> fontMap = new HashMap<>();

    public Font() {
        loadFont();
    }

    public int[] getCharMatrix(char c) {
        return fontMap.getOrDefault(c, fontMap.get('?'));
    }

    public boolean containsChar(char c) {
        return fontMap.containsKey(c);
    }

    public Map<Character, int[]> getFontMap() {
        return fontMap;
    }

    protected abstract void loadFont();

}
