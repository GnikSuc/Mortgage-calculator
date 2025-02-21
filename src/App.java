
import java.text.NumberFormat;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to mortgage calculator!");
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        String input = scanner.next();
        input = input.replace(",", ".");
        float annualInterest = Float.parseFloat(input);
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        
        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal * ((monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))/(Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
        
        String mortgageFormated = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("\nMorgage: " + mortgageFormated);
        String totalPayment = NumberFormat.getCurrencyInstance().format(mortgage * numberOfPayments);
        System.out.println("TOTAL: " + totalPayment);
    }
}
