import java.util.Scanner;

public class PalindromeCheckerApp {

    // Recursive method
    public static boolean isPalindrome(String str, int start, int end) {

        // Base condition
        if (start >= end) {
            return true;
        }

        // Compare start and end characters
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // User input
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // Check palindrome using recursion
        boolean result = isPalindrome(str, 0, str.length() - 1);

        // Print result
        if (result) {
            System.out.println(str + " is a Palindrome");
        } else {
            System.out.println(str + " is NOT a Palindrome");
        }

        sc.close();
    }
}