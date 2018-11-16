import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    private static Scanner s = new Scanner(System.in);

    public static void main(String... args) {
        System.out.println("Please choose your algorithm method:");
        System.out.println("1. Finite State Machine");
        System.out.println("2. Procedural");
        System.out.println("3. RegExp");

        int algo = s.nextInt();
        ContainsInfoAboutJamesBondParser p = getParser(algo);

        System.out.println("Enter your input:");
        String input = s.next(Pattern.compile("\\d+"));

        boolean result = p.containsInfo(input);
        System.out.println(
                result
                ? "Your input contains information about James Bond."
                : "Your input does not contain information about James Bond."
        );
    }

    private static ContainsInfoAboutJamesBondParser getParser(int i) {
        switch (i) {
            case 1:
                return new FSMImpl();
            case 2:
                return new ProceduralImpl();
            case 3:
                return new RegexImpl();
            default:
                throw new IllegalArgumentException("Algo not available.");
        }
    }
}
