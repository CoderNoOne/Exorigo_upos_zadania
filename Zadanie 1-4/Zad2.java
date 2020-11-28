public class Zad2 {
    public static boolean validateDate(int day, int month, int year) {

        var maxValidYear = 2099;
        var minValidYear = 2001;

        if (year > maxValidYear || year < minValidYear) {
            return false;
        }

        int maxDayInMonth = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 2 -> (year % 4 == 0) ? 28 : 29;
            case 4, 6, 9, 11 -> 30;
            default -> -1;
        };

        return maxDayInMonth != -1 && day <= maxDayInMonth;

    }
}
