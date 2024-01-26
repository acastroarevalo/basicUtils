//Alejandro Castro Arévalo
package excersise1;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class StudentAvgCalculator {
	
	public StudentAvgCalculator() {
	}
	
	public void calcAvg(Scanner scanner) {
		
		String name, grade;
		int courses = 0;
		
		System.out.println("Enter your name:");
		name = scanner.nextLine();
		System.out.println("Enter your grade:");
		grade = scanner.nextLine();
		
		do {
			System.out.println("Enter number of courses:");
			
			while (true) {
				try {
					courses = scanner.nextInt();
					scanner.nextLine(); //Blank input so scanner consumes newline
					break;
				} catch (InputMismatchException e) {
					System.out.println("Invalid Input, enter an integer: ");
					scanner.nextLine();
				}
			}
			
		} while (courses == 0);
		
		Map<String, Double> courseSheet = new HashMap<String, Double>();
		
		for(int i=0; i<courses; i++) {
			System.out.printf("Enter name of course %d \n", (i+1));
			String courseName = scanner.nextLine();
			
			System.out.println("Enter grade of " + courseName);
			Double courseGrade = 0.00; //Validate
			
			while (true) {
				try {
					courseGrade = scanner.nextDouble();
					scanner.nextLine(); //Blank input so scanner consumes newline
					break;
				} catch (InputMismatchException e) {
					System.out.println("Invalid Input, enter a number: ");
					scanner.nextLine();
				}
			}
			
			courseSheet.put(courseName, courseGrade);
		}
		
		double gradesAvg = courseSheet.entrySet()
				.stream()
				.mapToDouble(s -> s.getValue())
				.average()
				.getAsDouble();
		
		String status;
		if(gradesAvg < 70.00) {
			status = "Failed";
		}else if (70.00 <= gradesAvg && gradesAvg < 90.00) {
			status = "Passed";
		}else {
			status = "Passed with Excellency";
		}
		
		System.out.printf("------------------------------------------\nStudent Name: %s \t Grade: %s\n"
				+ "------------------------------------------\n", name, grade);
		for(Map.Entry<String, Double> e : courseSheet.entrySet()) {
			System.out.printf("Course: %s \t Score: %.2f \n", e.getKey(), e.getValue());
		}
		System.out.printf("------------------------------------------\nFinal Average: %.2f\tStatus: %s\n"
				+ "------------------------------------------\n",
				gradesAvg, status);
	}

}
