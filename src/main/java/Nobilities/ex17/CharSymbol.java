package Nobilities.ex17;

class CharSymbol extends Symbol {
    private final char c;

    public CharSymbol(char c) {
        this.c = c;
    }

    @Override
    public boolean compare(Symbol symbol) {
        if (symbol instanceof CharSymbol) {
            CharSymbol charSymbol = (CharSymbol)symbol;
            return this.c == charSymbol.c;
        }
        return false;
    }

    public static CharSymbol[] toSymbols(String s) {
        CharSymbol[] symbols = new CharSymbol[s.length()];

        for (int i = 0; i < s.length(); ++i) {
            symbols[i] = new CharSymbol(s.charAt(i));
        }

        return symbols;
    }
}
