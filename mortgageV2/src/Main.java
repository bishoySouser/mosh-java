import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);
        int principle = 0;
        float monthlyInterest = 0;
        int numberOfPayments = 0;

        while (true){
            System.out.print("Principle (1k:1m):");
            principle = scanner.nextInt();
            if(principle >= 1000 && principle <= 1_000_000)
                break;
            System.out.println("Enter a number between 1k and 1m");
        }

        while (true){
            System.out.print("Annual interest Rate:");
            float annualInterest = scanner.nextFloat();
            monthlyInterest = (annualInterest / PERCENT) / MONTHS_IN_YEAR ;
            if (annualInterest > 0 && annualInterest <= 30)
                break;
            System.out.println("Enter a value between 1 and 30");
        }

        while (true) {
            System.out.print("Period:");
            int period = scanner.nextInt();
            numberOfPayments = period * MONTHS_IN_YEAR;
            if (period >= 1 && period <= 30)
                break;
            System.out.println("Enter a value between and 30");
        }


        double mortgage = principle * ( (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments) )  / (Math.pow(1+ monthlyInterest, numberOfPayments) -1) );
        String formatMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("mortgage = " + formatMortgage);
    }
}