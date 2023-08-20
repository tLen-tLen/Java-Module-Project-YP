public class RusCurrencyHelper {
    public String getCurrencyString(double count) {
        int rubles =((int)count) % 10;

        String result = switch (rubles) {
            case 1 -> "рубль";
            case 2, 3, 4 -> "рубля";
            default -> "рублей";
        };

        return " " + result;
    }
}
