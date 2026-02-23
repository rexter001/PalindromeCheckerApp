// UseCase3PalindromeCheckerApp.java
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // Original string
        String original = "madam";

        // Reverse string using loop
        String reversed = "";

        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }

        // Compare original and reversed
        if (original.equals(reversed)) {
            System.out.println(original + " is a Palindrome");
        } else {
            System.out.println(original + " is NOT a Palindrome");
        }
    }
}