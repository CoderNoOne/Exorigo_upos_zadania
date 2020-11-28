public class Zad4 {

    /*funkcja do napisania*/
    public static String getCode(String code, int number) {

        int lengthForEan8 = 8;
        int lengthForEan13 = 13;

        if (number != 1 && number != 2) {
            throw new IllegalArgumentException("Not valid number: Possible values are: 1,2");
        }

        if (code == null) {
            throw new IllegalArgumentException("Code should be set");
        }
        return getCodeGeneric(code, number == 1 ? lengthForEan8 : lengthForEan13);

    }
    private static String getCodeGeneric(String code, int length) {
        if (code.charAt(0) == '0' && code.length() == length - 1) {
            code = "0" + code;
        }

        String regex = String.format("\\d{%d,}", length);

        if (!code.matches(regex)) {
            throw new IllegalArgumentException(String.format("Not valid code for EAN%d", length));
        }

        if (code.length() == length) {
            return code;
        }

        return code.substring(0, length);
    }

}
