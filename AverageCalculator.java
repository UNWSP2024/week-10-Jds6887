package harder1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageCalculator {

  
    public static double calculateAverage(List numbers) {
        if (numbers.isEmpty()) {
            return 0; 
        }
        int sum = 0;
        for (int num : numbers) {
            sum += num; 
        }
        return (double) sum / numbers.size(); 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List numbers = new ArrayList<>();

        System.out.println("Enter up to 30 integers (type 'done' when finished):");
        
        while (numbers.size() < 30) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break; 
            }
            try {
                int number = Integer.parseInt(input); 
                numbers.add(number); 
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer or type 'done' to finish.");
            }
        }

        double average = calculateAverage(numbers); 
        System.out.printf("The average value is: %.2f%n", average); 

        scanner.close(); 
    }
}