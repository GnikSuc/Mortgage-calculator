
import java.text.NumberFormat;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to mortgage calculator!");
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);
        String errorMessage;

        int principal;
        errorMessage = "Enter a number between 1K and 1M (included).";
        while (true) {
            System.out.print("Principal (1K-1M): ");
            try {
                principal = Integer.parseInt(scanner.nextLine());
                if (principal >= 1_000 && principal <= 1_000_000)
                    break;
                throw new IllegalArgumentException(errorMessage);
            } catch (Exception e) {
                System.out.println(errorMessage);
            }
        }
        
        float annualInterest;
        errorMessage = "Enter a number greater than 0 and less than or equal to 30 (f.e. 3,99).";
        while (true) { 
            System.out.print("Annual Interest Rate: ");
            try {
                annualInterest = Float.parseFloat(scanner.nextLine().replace(",", "."));
                if (annualInterest > 0 && annualInterest <= 30)
                    break;
                throw new IllegalArgumentException(errorMessage);
            } catch (Exception e) {
                System.out.println(errorMessage);
            }
        }
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        
        byte years;
        errorMessage = "Enter a value between 1 and 30 (included).";
        while (true) { 
            System.out.print("Period (Years): ");
            try {
                years = Byte.parseByte(scanner.nextLine());
                if (years > 1 && years <= 30)
                    break;
                throw new IllegalArgumentException(errorMessage);
            } catch (Exception e) {
                System.out.println(errorMessage);
            }
        }
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal * ((monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))/(Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
        
        String mortgageFormated = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("\nMorgage: " + mortgageFormated);
        String totalPayment = NumberFormat.getCurrencyInstance().format(mortgage * numberOfPayments);
        System.out.println("TOTAL: " + totalPayment);
    }
}
