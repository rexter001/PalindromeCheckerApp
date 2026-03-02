/**
 * ============================================================
 * MAIN CLASS - UseCase12PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 12: Strategy Pattern for Palindrome Algorithms
 *
 * Description:
 * This class demonstrates how different palindrome
 * validation algorithms can be selected dynamically
 * at runtime using the Strategy Design Pattern.
 *
 * At this stage, the application:
 *  - Defines a common PalindromeStrategy interface
 *  - Implements StackStrategy
 *  - Implements DequeStrategy
 *  - Injects the strategy at runtime
 *  - Executes the selected algorithm
 *
 * The focus is on algorithm interchangeability.
 *
 * Key Concepts Used:
 *  - Interface
 *  - Polymorphism
 *  - Strategy Pattern
 *  - Data Structures (Stack / Deque)
 *
 * Author: KM
 * Version: 12.0
 * ============================================================
 */

import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("   Strategy Pattern Palindrome   ");
        System.out.println("=================================");

        System.out.print("Enter input: ");
        String input = scanner.nextLine();

        System.out.println("\nChoose Strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();

        PalindromeStrategy strategy;

        // Inject strategy at runtime
        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        boolean result = strategy.check(input);

        System.out.println("\nIs Palindrome? : " + result);

        scanner.close();
    }
}

/**
 * ============================================================
 * INTERFACE - PalindromeStrategy
 * ============================================================
 *
 * This interface defines a contract for all
 * palindrome checking algorithms.
 *
 * Any new algorithm must implement this interface.
 * ============================================================
 */
interface PalindromeStrategy {
    boolean check(String input);
}

/**
 * ============================================================
 * CLASS - StackStrategy
 * ============================================================
 *
 * Stack-based palindrome implementation.
 * Uses LIFO behavior to reverse characters.
 * ============================================================
 */
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        java.util.Stack<Character> stack = new java.util.Stack<>();

        // Push characters onto stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Compare with popped characters
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

/**
 * ============================================================
 * CLASS - DequeStrategy
 * ============================================================
 *
 * Deque-based palindrome implementation.
 * Uses front and rear comparison.
 * ============================================================
 */
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        java.util.Deque<Character> deque = new java.util.ArrayDeque<>();

        // Add characters to deque
        for (char c : input.toCharArray()) {
            deque.add(c);
        }

        // Compare front and rear
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}