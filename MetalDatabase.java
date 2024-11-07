package harder1;

import java.util.Scanner;

public class MetalDatabase {
    static Scanner userinput = new Scanner(System.in);
    
    static double convertToCelcius(String from, double temp) {
        double answer = temp;
        if (from.charAt(0) == 'f') {
            answer = (5.0 / 9) * (answer - 32);
        }
        if (from.charAt(0) == 'r') {
            answer = (5.0 / 9) * (answer - 492);
        }
        if (from.charAt(0) == 'k') {
            answer = answer - 273;
        }
        return answer;
    }

    static double convertFromCelcius(String to, double temp) {
        double answer = temp;
        if (to.charAt(0) == 'f') {
            answer = (9.0 / 5) * answer + 32;
        }
        if (to.charAt(0) == 'r') {
            answer = (9.0 / 5) * answer + 492;
        }
        if (to.charAt(0) == 'k') {
            answer = answer + 273;
        }
        return answer;
    }

    public static void main(String[] args) {
        // Simple arrays to store 5 metals
        String[] names = new String[5];
        double[] densities = new double[5];
        double[] meltPoints = new double[5];
        double[] boilPoints = new double[5];
        int[] hardness = new int[5];
        int count = 0;
        
        // Input metals
        do {
            System.out.print("Enter metal name (or 'quit' to finish): ");
            names[count] = userinput.nextLine();
            
            if (names[count].equals("quit")) break;
            
            System.out.print("Density (g/cm³): ");
            densities[count] = userinput.nextDouble();
            System.out.print("Melting point (°C): ");
            meltPoints[count] = userinput.nextDouble();
            System.out.print("Boiling point (°C): ");
            boilPoints[count] = userinput.nextDouble();
            System.out.print("Hardness (0-10): ");
            hardness[count] = userinput.nextInt();
            userinput.nextLine();
            
            count++;
        } while (count < 5);
        
        // Display table
        System.out.println("\nName\t\tDensity\t\tMelt(°F)\tBoil(°F)\tHardness");
        for (int i = 0; i < count; i++) {
            System.out.printf("%s\t\t%.2f\t\t%.1f\t%.1f\t%d%n",
                names[i],
                densities[i],
                convertFromCelcius("f", meltPoints[i]),
                convertFromCelcius("f", boilPoints[i]),
                hardness[i]);
        }
    }
}