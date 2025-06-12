package de.paulmannit.service.fonts;

/**
 * Enthält eine einfache 4x4-Schriftart für Zeichen.
 */
public class Font4x4 extends Font {
    @Override
    protected void loadFont() {
        fontMap.put('0', new int[] {1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1});
        fontMap.put('1', new int[] {1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1});
        fontMap.put('2', new int[] {1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1});
        fontMap.put('3', new int[] {1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1});
        fontMap.put('4', new int[] {1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1});
        fontMap.put('5', new int[] {1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1});
        fontMap.put('6', new int[] {1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1});
        fontMap.put('7', new int[] {1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1});
        fontMap.put('8', new int[] {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1});
        fontMap.put('9', new int[] {1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1});
        fontMap.put('a', new int[] {0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1});
        fontMap.put('b', new int[] {0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1});
        fontMap.put('c', new int[] {0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1});
        fontMap.put('d', new int[] {0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0});
        fontMap.put('e', new int[] {0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1});
        fontMap.put('f', new int[] {0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0});
        fontMap.put('g', new int[] {0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1});
        fontMap.put('h', new int[] {0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1});
        fontMap.put('i', new int[] {0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1});
        fontMap.put('j', new int[] {0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0});
        fontMap.put('k', new int[] {0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1});
        fontMap.put('l', new int[] {0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1});
        fontMap.put('m', new int[] {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1});
        fontMap.put('n', new int[] {0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1});
        fontMap.put('o', new int[] {0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0});
        fontMap.put('p', new int[] {0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0});
        fontMap.put('q', new int[] {0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1});
        fontMap.put('r', new int[] {0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1});
        fontMap.put('s', new int[] {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0});
        fontMap.put('t', new int[] {0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0});
        fontMap.put('u', new int[] {0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1});
        fontMap.put('v', new int[] {0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0});
        fontMap.put('w', new int[] {0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1});
        fontMap.put('x', new int[] {0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1});
        fontMap.put('y', new int[] {0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0});
        fontMap.put('z', new int[] {0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1});
        fontMap.put('A', new int[] {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1});
        fontMap.put('B', new int[] {1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1});
        fontMap.put('C', new int[] {0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1});
        fontMap.put('D', new int[] {1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1});
        fontMap.put('E', new int[] {1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1});
        fontMap.put('F', new int[] {1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0});
        fontMap.put('G', new int[] {0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1});
        fontMap.put('H', new int[] {1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1});
        fontMap.put('I', new int[] {1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1});
        fontMap.put('J', new int[] {1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0});
        fontMap.put('K', new int[] {1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1});
        fontMap.put('L', new int[] {1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1});
        fontMap.put('M', new int[] {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1});
        fontMap.put('N', new int[] {1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1});
        fontMap.put('O', new int[] {0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0});
        fontMap.put('P', new int[] {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0});
        fontMap.put('Q', new int[] {0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1});
        fontMap.put('R', new int[] {1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1});
        fontMap.put('S', new int[] {0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0});
        fontMap.put('T', new int[] {1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0});
        fontMap.put('U', new int[] {1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1});
        fontMap.put('V', new int[] {1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0});
        fontMap.put('W', new int[] {1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1});
        fontMap.put('X', new int[] {1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1});
        fontMap.put('Y', new int[] {1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1});
        fontMap.put('Z', new int[] {1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1});
        fontMap.put(' ', new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        fontMap.put('!', new int[] {0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0});
        fontMap.put('\'', new int[] {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        fontMap.put('(', new int[] {0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0});
        fontMap.put(')', new int[] {0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0});
        fontMap.put('+', new int[] {0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0});
        fontMap.put(',', new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0});
        fontMap.put('-', new int[] {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0});
        fontMap.put('<', new int[] {0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1});
        fontMap.put('=', new int[] {0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0});
        fontMap.put('>', new int[] {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0});
        fontMap.put('?', new int[] {1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0});
        fontMap.put('[', new int[] {1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0});
        fontMap.put(']', new int[] {0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1});
        fontMap.put('^', new int[] {0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        fontMap.put('_', new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1});
        fontMap.put(':', new int[] {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0});
        fontMap.put('.', new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0});
        fontMap.put('/', new int[] {0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0});
        fontMap.put('{', new int[] {0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1});
        fontMap.put('|', new int[] {0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0});
        fontMap.put('}', new int[] {1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0});
        fontMap.put('~', new int[] {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0});
        fontMap.put('$', new int[] {1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0});
        fontMap.put('@', new int[] {0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1});
        fontMap.put('%', new int[] {1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1});
        fontMap.put('°', new int[] {0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0});
        fontMap.put('*', new int[] {0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0});    }
}
