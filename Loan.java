/**
 * Author: Alejandro Sierra
 * Date: 2/22/2021
 * Description: This app will prompt user for loan information and output the payments that will be made
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class Loan {
    public static Scanner console = new Scanner(System.in);
    public static DecimalFormat df = new DecimalFormat("$#,##0.00");

    public static void main(String[] args) {
        // Declare user input variables
        double amount;
        double APR;
        double years;
        // Prompt user for info
        System.out.print("What is the amount of the loan? ");
        amount = console.nextDouble();

        System.out.print("How many years? ");
        years = console.nextDouble();

        System.out.print("What is the APR? ");
        APR = console.nextDouble();

        // Declare variables used in table
        double monthlyInterest;
        double monthlyPayment;
        double totalMonths;
        double totalAmount;

        totalMonths = years * 12;
        monthlyInterest = APR / 1200;
        
        monthlyPayment = (amount * monthlyInterest) / (1 - (1/( Math.pow((1 + monthlyInterest), (years * 12)) )));
        totalAmount = monthlyPayment * totalMonths;

        System.out.println("Your monthly payment is " + df.format(monthlyPayment) + " for a total payment of " + df.format(totalAmount));
        // Print and format the table header
        System.out.println("Payment \t Interest \tPrinciple \tBalance");
        System.out.println("======= \t ======== \t========= \t=======");

        // Loop through months and print rows
        for (int i = 1; i < totalMonths + 1; i++) {
            // variables for the values in the string
            double interestPaid = (monthlyInterest * amount);
            double principlePaid = (monthlyPayment - interestPaid);
            // upating the global amount variable
            amount = (amount - principlePaid);
            formattedRow(i, interestPaid, principlePaid, amount);
        }
    }
    public static void formattedRow(int i, double interestPaid, double principlePaid, double amount) {
        System.out.println(i + " \t\t " + df.format(interestPaid) + "    \t" + df.format(principlePaid) + " \t" + df.format(amount));
    }
}