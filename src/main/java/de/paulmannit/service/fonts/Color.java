package de.paulmannit.service.fonts;

public class Color {
    public final int r;
    public final int g;
    public final int b;

    public static final Color Black = new Color(0, 0, 0);
    public static final Color White = new Color(255, 255, 255);
    public static final Color Red = new Color(255, 0, 0);
    public static final Color Green = new Color(0, 255, 0);
    public static final Color Blue = new Color(0, 0, 255);
    public static final Color Yellow = new Color(255, 255, 0);
    public static final Color Cyan = new Color(0, 255, 255);
    public static final Color Magenta = new Color(255, 0, 255);
    public static final Color Orange = new Color(255, 165, 0);
    public static final Color Purple = new Color(128, 0, 128);
    public static final Color Lime = new Color(0, 255, 0);
    public static final Color Maroon = new Color(128, 0, 0);
    public static final Color Navy = new Color(0, 0, 128);
    public static final Color Teal = new Color(0, 128, 128);
    public static final Color Olive = new Color(128, 128, 0);
    public static final Color Gray = new Color(128, 128, 128);
    public static final Color Silver = new Color(192, 192, 192);
    public static final Color Pink = new Color(255, 192, 203);
    public static final Color Brown = new Color(165, 42, 42);
    public static final Color Beige = new Color(245, 245, 220);
    public static final Color Mint = new Color(189, 252, 201);
    public static final Color Lavender = new Color(230, 230, 250);
    public static final Color Coral = new Color(255, 127, 80);
    public static final Color Turquoise = new Color(64, 224, 208);
    public static final Color Violet = new Color(238, 130, 238);
    public static final Color Peach = new Color(255, 218, 185);
    public static final Color Apricot = new Color(251, 206, 177);
    public static final Color Salmon = new Color(250, 128, 114);
    public static final Color Gold = new Color(255, 215, 0);
    public static final Color Khaki = new Color(240, 230, 140);
    public static final Color Crimson = new Color(220, 20, 60);
    public static final Color Azure = new Color(240, 255, 255);
    public static final Color MintCream = new Color(245, 255, 250);
    public static final Color AliceBlue = new Color(240, 248, 255);
    public static final Color LavenderBlush = new Color(255, 240, 245);
    public static final Color Seashell = new Color(255, 245, 238);
    public static final Color Honeydew = new Color(240, 255, 240);
    public static final Color GhostWhite = new Color(248, 248, 255);
    public static final Color WhiteSmoke = new Color(245, 245, 245);
    public static final Color FloralWhite = new Color(255, 250, 240);
    public static final Color AntiqueWhite = new Color(250, 235, 215);
    public static final Color Linen = new Color(250, 240, 230);
    public static final Color OldLace = new Color(253, 245, 230);
    public static final Color Ivory = new Color(255, 255, 240);
    public static final Color Cornsilk = new Color(255, 248, 220);
    public static final Color LemonChiffon = new Color(255, 250, 205);
    public static final Color LightYellow = new Color(255, 255, 224);
    public static final Color LightGoldenrodYellow = new Color(250, 250, 210);
    public static final Color PapayaWhip = new Color(255, 239, 213);

    public Color(int r, int g, int b) {
        this.r = clamp(r);
        this.g = clamp(g);
        this.b = clamp(b);
    }

    public String toHex() {
        return String.format("#%02X%02X%02X", r, g, b);
    }

    private int clamp(int value) {
        return Math.max(0, Math.min(255, value));
    }

    public int[] toArray() {
        return new int[]{r, g, b};
    }
}
