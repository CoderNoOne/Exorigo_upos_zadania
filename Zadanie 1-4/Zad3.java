import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Zad3 {

    private static final int initialPoints = 0;
    private static final int rounds = 5;
    private static final int maxTossNumberPerRound = 10;
    private static final int maxPointsPerRound = 10 + (maxTossNumberPerRound - 1) * 12;
    private static final Random random = new Random();

    public static void main(String[] args) {

        BigDecimal pointsForPlayer1 = new BigDecimal(initialPoints);
        BigDecimal pointsForPlayer2 = new BigDecimal(initialPoints);

        for (int i = 1; i <= rounds * 2; i++) {
            if (i % 2 != 0) {
                pointsForPlayer1 = simulateRound(pointsForPlayer2);
            } else {
                pointsForPlayer2 = simulateRound(pointsForPlayer2);
            }
        }

        printResults(pointsForPlayer1, pointsForPlayer2);
    }

    private static void printResults(final BigDecimal pointsForPlayer1, final BigDecimal pointsForPlayer2) {
        System.out.printf("Suma punktów dla gracza 1: %s%n", pointsForPlayer1);
        System.out.printf("Suma punktów dla gracza 2: %s%n", pointsForPlayer2);

        if (pointsForPlayer1.compareTo(pointsForPlayer2) == 0) {
            System.out.println("REMIS");
        } else if (pointsForPlayer1.compareTo(pointsForPlayer2) > 0) {
            System.out.println("Wygrał gracz 2");
        } else {
            System.out.println("Wygrał gracz 1");
        }
    }

    private static BigDecimal simulateRound(final BigDecimal sumBeforeRound) {

        BigDecimal sumAfterRound = sumBeforeRound;

        for (int j = 1; j <= maxTossNumberPerRound; j++) {
            int sum = random.nextInt(6) + 1 + random.nextInt(6) + 1;
            if ((j == 1 && sum == 7 || sum == 11) || sum == 5) {
                break;
            } else if (j == 1 && sum == 2 || sum == 12) {
                sumAfterRound = sumAfterRound.add(new BigDecimal(maxPointsPerRound));
                break;
            } else {
                sumAfterRound = sumAfterRound.add(new BigDecimal(sum).divide(new BigDecimal(j), 2, RoundingMode.HALF_UP));
            }
        }

        return sumAfterRound;

    }
}
