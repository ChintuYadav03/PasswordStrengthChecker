package Password_Strength_Checker;

import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter your password (type 'quit' to exit): ");
            String password = scanner.nextLine();

            if (password.equalsIgnoreCase("quit")) {
                System.out.println("Exiting the password checker. Goodbye!");
                break;
            }

            int length = password.length();
            boolean hasUppercase = !password.equals(password.toLowerCase());
            boolean hasLowercase = !password.equals(password.toUpperCase());
            boolean hasDigit = password.matches(".*\\d.*");
            boolean hasSpecialChar = !password.matches("[A-Za-z0-9]*");

            int strength = calculateStrength(length, hasUppercase, hasLowercase, hasDigit, hasSpecialChar);

            System.out.println("Password Strength: " + getStrengthLabel(strength));
            if (strength <= 2) {
                System.out.println("Suggestions for improvement:");
                if (length < 8) {
                    System.out.println("- Password should be at least 8 characters long.");
                }
                if (!hasUppercase) {
                    System.out.println("- Password should contain at least one uppercase letter.");
                }
                if (!hasLowercase) {
                    System.out.println("- Password should contain at least one lowercase letter.");
                }
                if (!hasDigit) {
                    System.out.println("- Password should contain at least one digit.");
                }
                if (!hasSpecialChar) {
                    System.out.println("- Password should contain at least one special character.");
                }
            }
        }

        scanner.close();
    }

    private static int calculateStrength(int length, boolean hasUppercase, boolean hasLowercase,
                                         boolean hasDigit, boolean hasSpecialChar) {
        int strength = 0;

        // Check length
        if (length >= 8) {
            strength++;
        }

        // Check for uppercase letters
        if (hasUppercase) {
            strength++;
        }

        // Check for lowercase letters
        if (hasLowercase) {
            strength++;
        }

        // Check for numbers
        if (hasDigit) {
            strength++;
        }

        // Check for special characters
        if (hasSpecialChar) {
            strength++;
        }

        return strength;
    }

    private static String getStrengthLabel(int strength) {
        switch (strength) {
            case 0:
            case 1:
                return "Very Weak";
            case 2:
                return "Weak";
            case 3:
                return "Moderate";
            case 4:
                return "Strong";
            case 5:
                return "Very Strong";
            default:
                return "Unknown";
        }
    }
}
