import java.util.Scanner;

public class PasswordStrengthCLI {

    // Green color for hacker theme
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Hacker Banner
        System.out.println(GREEN);
        System.out.println("==============================================");
        System.out.println("     ██████╗  █████╗ ███████╗███████╗");
        System.out.println("     ██╔══██╗██╔══██╗██╔════╝██╔════╝");
        System.out.println("     ██████╔╝███████║███████╗█████╗  ");
        System.out.println("     ██╔═══╝ ██╔══██║╚════██║██╔══╝  ");
        System.out.println("     ██║     ██║  ██║███████║███████╗");
        System.out.println("==============================================");
        System.out.println("        PASSWORD STRENGTH ANALYZER");
        System.out.println("==============================================");
        System.out.print(RESET);

        System.out.print(GREEN + "\nEnter your password: " + RESET);
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

        System.out.println(GREEN + "\n[ PASSWORD ANALYSIS ]");
        System.out.println("----------------------------------------------");

        System.out.println((hasLength ? "[✓]" : "[✗]") + " Minimum 8 characters");
        System.out.println((hasUpper ? "[✓]" : "[✗]") + " Uppercase letter");
        System.out.println((hasLower ? "[✓]" : "[✗]") + " Lowercase letter");
        System.out.println((hasDigit ? "[✓]" : "[✗]") + " Number");
        System.out.println((hasSpecial ? "[✓]" : "[✗]") + " Special character");

        System.out.println("----------------------------------------------");

        if (score <= 2) {
            System.out.println(RED + ">> PASSWORD STRENGTH: WEAK" + RESET);
        } 
        else if (score <= 4) {
            System.out.println(GREEN + ">> PASSWORD STRENGTH: MEDIUM" + RESET);
        } 
        else {
            System.out.println(GREEN + ">> PASSWORD STRENGTH: STRONG" + RESET);
        }

        System.out.println(GREEN + "==============================================" + RESET);

        sc.close();
    }
}
