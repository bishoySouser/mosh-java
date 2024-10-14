import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Principle:");
        int principle = scanner.nextInt();
        System.out.print("Annual interest Rate:");
        double r = scanner.nextDouble();
        double rate = (r / 100) / 12 ;

        System.out.print("Period:");
        int period = scanner.nextInt();
        int n = period * 12;

        double mortgage = principle * ( (rate * Math.pow(1 + rate, n) )  / (Math.pow(1+rate,n) -1) );
        String formatMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("mortgage = " + formatMortgage);

    }
}
