import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostRepeatedDigitEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input two numbers
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        // Find the most repeated digit in each number
        int mostRepeatedDigit1 = findMostRepeatedDigit(num1);
        int mostRepeatedDigit2 = findMostRepeatedDigit(num2);

        // Check if the most repeated digits in both numbers are equal
        boolean areEqual = mostRepeatedDigit1 == mostRepeatedDigit2;

        // Display the result
        if (areEqual) {
            System.out.println("The most repeated digit in both numbers is equal: " + mostRepeatedDigit1);
        } else {
            System.out.println("The most repeated digit in the two numbers is not equal.");
        }

        scanner.close();
    }

    // Function to find the most repeated digit in a number
    public static int findMostRepeatedDigit(int number) {
        Map<Integer, Integer> digitFrequency = new HashMap<>();

        while (number != 0) {
            int digit = number % 10;
            digitFrequency.put(digit, digitFrequency.getOrDefault(digit, 0) + 1);
            number /= 10;
        }

        int mostRepeatedDigit = -1;
        int maxFrequency = 0;

        for (Map.Entry<Integer, Integer> entry : digitFrequency.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostRepeatedDigit = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }

        return mostRepeatedDigit;
    }
}
