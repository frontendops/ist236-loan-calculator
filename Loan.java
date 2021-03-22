/**
 * Author: Alejandro Sierra
 * Date: 2/22/2021
 * Description: This app will prompt user for loan information and output the payments that will be made
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class Loan {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        // declare user input variables
        double amount;
        double APR;
        double years;

        System.out.print("What is the amount of the loan? ");
        amount = console.nextDouble();

        System.out.print("How many years? ");
        years = console.nextDouble();

        System.out.print("What is the APR? ");
        APR = console.nextDouble();

        // declare variables used in table
        double monthlyInterest;
        double monthlyPayment;
        double totalMonths;
        double totalAmount;

        totalMonths = years * 12;
        monthlyInterest = APR / 1200;
        
        monthlyPayment = (amount * monthlyInterest) / (1 - (1/( Math.pow((1 + monthlyInterest), (years * 12)) )));
        totalAmount = monthlyPayment * totalMonths;

        System.out.println("Your monthly payment is " + df.format(monthlyPayment) + " for a total payment of " + df.format(totalAmount));
        
        System.out.println("Payment \t Interest \t Principle \t Balance");
        for (int i = 1; i < totalMonths + 1; i++) {
            // variables for the values in the string
            double interestPaid = (monthlyInterest * totalAmount);
            double principlePaid = (monthlyPayment - interestPaid);
            totalAmount = (totalAmount - principlePaid);
            System.out.println(i + " \t\t " + df.format(interestPaid) + " \t" + df.format(principlePaid) + " \t" + df.format(totalAmount));
        }
         // move after values above are calculated

    }
}