import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int principle = 0;
        float monthlyInterest = 0;
        byte years = 0;
        float annualInterest = 0;

        principle = (int)readNumber("Principle: ", 1000, 1_000_000);

        annualInterest = (float) readNumber("Annual interest: ", 1, 30);

        years = (byte) readNumber("Period (Years): ", 1, 30);

        double mortgage = calculateMortgage(principle, annualInterest, years);
        String formatMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("mortgage = " + formatMortgage);
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
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterest = (annualInterest / PERCENT) / MONTHS_IN_YEAR;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);


        double mortgage = principle * ( (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments) )
                / (Math.pow(1+ monthlyInterest, numberOfPayments) -1) );
        return mortgage;
    }
}