import java.util.*;

public class PasswordStrengthCLI {

    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RESET = "\u001B[0m";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        while (true) {

            showBanner();

            System.out.println("1. Analyze Password");
            System.out.println("2. Generate Strong Password");
            System.out.println("3. Exit");
            System.out.print("\nChoose Option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    analyzePassword();
                    break;
                case 2:
                    generatePassword();
                    break;
                case 3:
                    System.out.println(GREEN + "\nExiting Tool... Stay Secure 💀" + RESET);
                    return;
                default:
                    System.out.println(RED + "Invalid Option!\n" + RESET);
            }
        }
    }

    static void showBanner() {
        System.out.println(GREEN + "====================================================" + RESET);
        System.out.println(GREEN + "   PPPP    AAAAA   SSSSS  EEEEE  " + RESET);
        System.out.println(GREEN + "   P   P   A   A   S      E      " + RESET);
        System.out.println(GREEN + "   PPPP    AAAAA   SSSSS  EEEE   " + RESET);
        System.out.println(GREEN + "   P       A   A       S  E      " + RESET);
        System.out.println(GREEN + "   P       A   A   SSSSS  EEEEE  " + RESET);
        System.out.println(GREEN + "====================================================" + RESET);
        System.out.println(GREEN + " PASSWORD STRENGTH ANALYZER TOOL MADE BY KUNJ PATEL" + RESET);
        System.out.println(GREEN + "====================================================\n" + RESET);
    }

    static void analyzePassword() throws InterruptedException {

        System.out.print(GREEN + "Enter your password: " + RESET);
        String password = sc.nextLine();

        // Fake scanning animation
        System.out.print(YELLOW + "\nAnalyzing password");
        for (int i = 0; i < 3; i++) {
            Thread.sleep(500);
            System.out.print(".");
        }
        System.out.println("\n" + RESET);

        int score = 0;

        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasLower = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[!@#$%^&*].*");
        boolean hasLength = password.length() >= 8;

        if (hasLength) score++;
        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSpecial) score++;

        int percentage = (score * 100) / 5;

        System.out.println(GREEN + "[ PASSWORD ANALYSIS ]" + RESET);
        System.out.println("--------------------------------------------");

        System.out.println((hasLength ? "[✓]" : "[✗]") + " Minimum 8 characters");
        System.out.println((hasUpper ? "[✓]" : "[✗]") + " Uppercase letter");
        System.out.println((hasLower ? "[✓]" : "[✗]") + " Lowercase letter");
        System.out.println((hasDigit ? "[✓]" : "[✗]") + " Number");
        System.out.println((hasSpecial ? "[✓]" : "[✗]") + " Special character");

        System.out.println("\nStrength Score: " + score + "/5");
        System.out.println("Security Level: " + percentage + "%");

        showProgressBar(percentage);

        if (percentage < 40) {
            System.out.println(RED + "\n>> PASSWORD STRENGTH: WEAK" + RESET);
            suggestPassword();
        } else if (percentage < 80) {
            System.out.println(YELLOW + "\n>> PASSWORD STRENGTH: MEDIUM" + RESET);
        } else {
            System.out.println(GREEN + "\n>> PASSWORD STRENGTH: STRONG" + RESET);
        }

        System.out.println("--------------------------------------------\n");
    }

    static void showProgressBar(int percentage) {
        int bars = percentage / 5;
        System.out.print("Strength Meter: [");
        for (int i = 0; i < 20; i++) {
            if (i < bars) System.out.print("#");
            else System.out.print("-");
        }
        System.out.println("] " + percentage + "%");
    }

    static void generatePassword() {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String special = "@#$%&!";
        String all = upper + lower + digits + special;

        Random rand = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            password.append(all.charAt(rand.nextInt(all.length())));
        }

        System.out.println(GREEN + "\nGenerated Strong Password: " + password + RESET + "\n");
    }

    static void suggestPassword() {
        System.out.println(YELLOW + "\nSuggested Strong Password: " + generateSuggestion() + RESET);
    }

    static String generateSuggestion() {
        return "Kunj@" + (1000 + new Random().nextInt(9000)) + "Secure!";
    }
}
