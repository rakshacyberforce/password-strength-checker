import java.util.Scanner;

public class PasswordStrengthCLI {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        int score = 0;

        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasLower = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[@#$%^&+=!].*");
        boolean hasLength = password.length() >= 8;

        if (hasLength) score++;
        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSpecial) score++;

        System.out.println("\n--- Password Analysis ---");

        if (!hasLength)
            System.out.println("Minimum 8 characters required");

        if (!hasUpper)
            System.out.println("Add at least one uppercase letter");

        if (!hasLower)
            System.out.println("Add at least one lowercase letter");

        if (!hasDigit)
            System.out.println("Add at least one number");

        if (!hasSpecial)
            System.out.println("Add at least one special character");

        if (score <= 2)
            System.out.println("Password Strength: WEAK");
        else if (score <= 4)
            System.out.println("Password Strength: MEDIUM");
        else
            System.out.println("Password Strength: STRONG");

        sc.close();
    }
}