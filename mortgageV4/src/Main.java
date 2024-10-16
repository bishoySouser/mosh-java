import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int principle = 0;
        float monthlyInterest = 0;
        byte years = 0;
        float annualInterest = 0;

        principle = (int)readNumber("Principle: ", 1000, 1_000_000);

        annualInterest = (float) readNumber("Annual interest: ", 1, 30);

        years = (byte) readNumber("Period (Years): ", 1, 30);

        printMortgage(principle, annualInterest, years);
        printBalance(principle, annualInterest, years);

    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true){
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("Enter a value between "+ min + " and " + max);
        }
        return value;
    }

    public static double calculateMortgage(
            float principle,
            float annualInterest,
            byte years
    ) {
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);

        double mortgage = principle * ( (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments) )
                / (Math.pow(1+ monthlyInterest, numberOfPayments) -1) );
        return mortgage;
    }

    public static void printMortgage(
            float principle,
            float annualInterest,
            byte years
    ) {
        double mortgage = calculateMortgage(principle, annualInterest, years);
        System.out.println("\nMORTGAGE \n------------");
        System.out.println("Monthly Payments: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }

    public static double calculateBalance(
            int principle,
            float annualInterest,
            byte years,
            double numberOfPaymentsMade
    ) {
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        double totalNumberOfPayments = years * MONTHS_IN_YEAR;

        double balance = principle
                * ( Math.pow( 1+ monthlyInterest, totalNumberOfPayments)
                - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1+ monthlyInterest, totalNumberOfPayments) - 1);
        return balance;
    }

    public static void printBalance(
            int principle,
            float annualInterest,
            byte years
    ) {
        System.out.println("\nPAYMENT SCHEDULE \n------------");
        for (short month = 1; month < years * MONTHS_IN_YEAR; month++) {
            double remainingBalance = calculateBalance(principle, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(remainingBalance));
        }
    }
}