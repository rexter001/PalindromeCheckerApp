import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // Scanner for user input
        Scanner sc = new Scanner(System.in);

        // Get input from user
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // Convert string to char array
        char[] arr = str.toCharArray();

        // Two-pointer approach
        int start = 0;
        int end = arr.length - 1;
        boolean isPalindrome = true;

        // Compare characters
        while (start < end) {
            if (arr[start] != arr[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Display result
        if (isPalindrome) {
            System.out.println(str + " is a Palindrome");
        } else {
            System.out.println(str + " is NOT a Palindrome");
        }

        sc.close();
    }
}