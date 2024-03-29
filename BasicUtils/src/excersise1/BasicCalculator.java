//Alejandro Castro Arévalo
package excersise1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BasicCalculator  {
	
	public BasicCalculator() {
	}
	
	public void menu(Scanner scanner) {
		
		int option = 0;
		float[] values = new float[2];
		
		do {
			System.out.println("Please choose an option: \n1.- Sum (a + b)\n2.- Substract (a - b)\n"
					+ "3.- Multiply (a x b)\n4.- Divide (a / b)\n5.- Exit.");
			
			System.out.print("Option: ");
			
			while (true) {
				try {
					option = scanner.nextInt();
					scanner.nextLine(); 
					break;
				} catch (InputMismatchException e) {
					System.out.println("Invalid Input, enter an integer: ");
					scanner.nextLine();
				}
			}
			
			if (option == 1) {
				System.out.println("Sum");
				values = getInput(scanner, option);
				
				Operation sum = v -> System.out.printf("Result: %.2f \n", (v[0] + v[1]));
				sum.calculate(values);
				
			} else if (option == 2) {
				System.out.println("Substraction");
				values = getInput(scanner, option);
				
				Operation sub = v -> System.out.printf("Result: %.2f \n", (v[0] - v[1]));
				sub.calculate(values);

			} else if (option == 3) {
				System.out.println("Multiply");
				values = getInput(scanner, option);
				
				Operation mult = v -> System.out.printf("Result: %.2f \n", (v[0] * v[1]));
				mult.calculate(values);
				
			} else if (option == 4) {
				System.out.println("Division");
				values = getInput(scanner, option);
				
				Operation div = v -> System.out.printf("Result: %.2f \n", (v[0] / v[1]));
				div.calculate(values);
				
			} else if (option == 5) {
				System.out.println("Exiting Calculator...");
				break;
			} else {
				System.out.println("----------------------------\nINVALID OPTION\n----------------------------");
			}
		} while (true);
		
	}
	
	public float[] getInput(Scanner scanner, int option) {
		float[] inputs = {0,0};
		
		System.out.println("Insert value a:");
		
		while (true) {
			try {
				inputs[0] = scanner.nextFloat();
				scanner.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input, enter an number: ");
				scanner.nextLine();
			}
		}
		
		if (option == 4) {
			do {
				
				System.out.println("Insert value b:");
				
				while (true) {
					try {
						inputs[1] = scanner.nextFloat();
						scanner.nextLine();
						break;
					} catch (InputMismatchException e) {
						System.out.println("Invalid Input, enter an number: ");
						scanner.nextLine();
					}
				}
				
			} while (inputs[1] == 0);
		} else {
			System.out.println("Insert value b:");
			
			while (true) {
				try {
					inputs[1] = scanner.nextFloat();
					scanner.nextLine();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Invalid Input, enter an number: ");
					scanner.nextLine();
				}
			}
		}
		
		return inputs;
	}

}
