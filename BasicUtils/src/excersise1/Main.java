//Alejandro Castro Arévalo
package excersise1;

import java.util.Scanner;

public class Main {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		do {
			System.out.println("Please choose an option: \n1.- Basic Calculator.\n2.- Encoder\n"
					+ "3.- Student Average Calculator.\n4.- Exit.");
			
			System.out.print("Option: ");
			int option = scanner.nextInt();
			scanner.nextLine(); //Blank input so scanner consumes newline
			
			if (option == 1) {
				System.out.println("Calculator");
				BasicCalculator basicCalculator = new BasicCalculator();
				basicCalculator.menu(scanner);
			} else if (option == 2) {
				System.out.println("Encoder");
				Encoder encoder = new Encoder();
				encoder.menu(scanner);
			} else if (option == 3) {
				System.out.println("Student Average Calculator");
				StudentAvgCalculator studentCalculator = new StudentAvgCalculator();
				studentCalculator.calcAvg(scanner);
			} else if (option == 4) {
				System.out.println("Shutting Down...");
				break;
			} else {
				System.out.println("----------------------------\nINVALID OPTION\n----------------------------");
			}
		} while (true);
		
	}
}
