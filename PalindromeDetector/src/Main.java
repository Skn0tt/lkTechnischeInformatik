import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class Main {

    private static Scanner s = new Scanner(System.in);

    public static void main(String... args) {
        System.out.println("Please type your desired input:");
        Scanner s = new Scanner(System.in);

        Pattern allowedPattern = Pattern.compile("(a|b|0)*");
        String inputString = s.next(allowedPattern);

        PalindromeDetector d = new PalindromeDetector();

        Stack<Sigma> inputStack = toInputStack(inputString);
        boolean isValid = d.validate(inputStack);

        System.out.print(
          isValid
            ? "This is a valid even palindrome."
            : "This is not valid even palindrome."
        );
    }

    private static Stack<Sigma> toInputStack(String inputString) {
        Stack<Sigma> result = new Stack<>();
        for (char c : inputString.toCharArray()) {
            switch (c) {
                case '0':
                    result.push(Sigma.ZERO);
                    break;
                default:
                    result.push(Sigma.valueOf("" + c));
                    break;
            }

        }
        return result;
    }
}
