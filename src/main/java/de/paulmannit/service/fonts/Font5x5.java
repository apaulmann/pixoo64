package de.paulmannit.service.fonts;

/**
 * Enthält eine einfache 5x5-Schriftart für Zeichen.
 * Jedes Zeichen ist eine flache 1D-Matrix mit 25 Einträgen (5x5),
 * zeilenweise gespeichert: [row0..., row1..., row2..., row3..., row4...]
 */
public class Font5x5 extends Font {
    @Override
    protected void loadFont() {
        // Einfaches Beispiel für die Buchstaben A, B und ?
        fontMap.put('A', new int[]{
                0, 1, 1, 1, 0,
                1, 0, 0, 0, 1,
                1, 1, 1, 1, 1,
                1, 0, 0, 0, 1,
                1, 0, 0, 0, 1
        });

        fontMap.put('B', new int[]{
                1, 1, 1, 1, 0,
                1, 0, 0, 0, 1,
                1, 1, 1, 1, 0,
                1, 0, 0, 0, 1,
                1, 1, 1, 1, 0
        });

        fontMap.put('?', new int[]{
                1, 1, 1, 1, 0,
                0, 0, 0, 0, 1,
                0, 0, 1, 1, 0,
                0, 0, 0, 0, 0,
                0, 0, 1, 0, 0
        });

        // Du kannst hier natürlich das komplette Alphabet + Ziffern + Sonderzeichen hinzufügen.
    }
}
