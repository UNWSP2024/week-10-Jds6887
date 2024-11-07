package harder1;


import java.util.Scanner;

class MyClass {
    static Scanner userinput = new Scanner(System.in);
    
    static double computePayment(
            double principal,
            double annualRate,
            int years) {
        
        // Convert annual rate to monthly decimal rate
        double monthlyRate = (annualRate / 100.0) / 12.0;
        
        // Convert years to number of monthly payments
        int numPayments = years * 12;
        
        // Calculate monthly payment using the formula
        double numerator = monthlyRate * Math.pow(1 + monthlyRate, numPayments);
        double denominator = Math.pow(1 + monthlyRate, numPayments) - 1;
        
        return principal * (numerator / denominator);
    }
    
    public static void main(String[] args) {
        System.out.println("Welcome to Monthly Mortgage Calculator");
        
        System.out.print("\nEnter principal amount: ");
        double principal = userinput.nextDouble();
        
        System.out.print("Enter yearly interest rate (without percent): ");
        double rate = userinput.nextDouble();
        
        System.out.print("Enter number of years: ");
        int years = userinput.nextInt();
        
        double monthlyPayment = computePayment(principal, rate, years);
        
        System.out.printf("\nThe monthly payment is $%.2f%n", monthlyPayment);
    }
}