import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // User input
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // Normalize string
        // remove spaces and convert to lowercase
        String normalized = str.replaceAll("\\s+", "").toLowerCase();

        // Palindrome check
        int start = 0;
        int end = normalized.length() - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Print result
        if (isPalindrome) {
            System.out.println("\"" + str + "\" is a Palindrome");
        } else {
            System.out.println("\"" + str + "\" is NOT a Palindrome");
        }

        sc.close();
    }
}