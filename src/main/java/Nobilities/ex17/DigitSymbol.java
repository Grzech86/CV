package Nobilities.ex17;

class DigitSymbol extends Symbol {

    private final int digit;

    public DigitSymbol(int digit) {
        this.digit = digit;
    }

    @Override
    public boolean compare(Symbol symbol) {
        if (symbol instanceof DigitSymbol) {
            DigitSymbol charSymbol = (DigitSymbol)symbol;
            return this.digit == charSymbol.digit;
        }
        return false;
    }

    public static DigitSymbol[] toSymbols(int number) {
        String s = String.valueOf(number);

        DigitSymbol[] symbols = new DigitSymbol[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            symbols[i] = new DigitSymbol(Integer.valueOf(s.charAt(i)));
        }

        return symbols;
    }
}