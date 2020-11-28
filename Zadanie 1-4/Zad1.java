import java.util.stream.IntStream;

public class Zad1 {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100)
                .boxed()
                .map(x -> switch (x % 15) {
                    case 0 -> "FizzBuzz";
                    case 3, 6, 9, 12 -> "Fizz";
                    case 5, 10 -> "Buzz";
                    default -> x;
                })
                .forEach(System.out::println);
    }
}
