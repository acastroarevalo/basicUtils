//Alejandro Castro Arévalo
package excersise1;

import java.util.Base64;
import java.util.Scanner;

public class Encoder {
	
	public Encoder() {
	}
	
	public void menu(Scanner scanner) {
		do {
			System.out.println("Please choose an option: \n1.- Encode a String to Base64.\n"
					+ "2.- Decode a String to Base64.\n"
					+ "3.- Exit.");
			
			System.out.print("Option: ");
			int option = scanner.nextInt();
			scanner.nextLine(); //Blank input so scanner consumes newline
			
			if (option == 1) {
				System.out.println("Encode");
				encode64(scanner);
			} else if (option == 2) {
				System.out.println("Decode");
				decode64(scanner);
			} else if (option == 3) {
				System.out.println("Exiting Encoder...");
				break;
			} else {
				System.out.println("----------------------------\nINVALID OPTION\n----------------------------");
			}
		} while (true);
	}
	
	public void encode64(Scanner scanner) {
		System.out.println("Enter string to encode:");
		String input = scanner.nextLine();
		
		String encodedInput = Base64.getEncoder().encodeToString(input.getBytes());
		System.out.println("Encoded string is: " + encodedInput);
	}
	
	public void decode64(Scanner scanner) {
		System.out.println("Enter string to decode:");
		String input = scanner.nextLine();
		
		byte[] decodedBytes = Base64.getDecoder().decode(input);
		String result = new String(decodedBytes);
		System.out.println("Decoded string is: " + result);
	}
}
