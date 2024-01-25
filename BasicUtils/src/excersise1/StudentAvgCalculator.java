package excersise1;

import java.util.HashMap;
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
			courses = scanner.nextInt();
			scanner.nextLine();
		} while (courses == 0);
		
		Map<String, Double> courseSheet = new HashMap<String, Double>();
		
		for(int i=0; i<courses; i++) {
			System.out.printf("Enter name of course %d \n", (i+1));
			String courseName = scanner.nextLine();
			System.out.println("Enter grade of " + courseName);
			Double courseGrade = scanner.nextDouble();
			scanner.nextLine();
			
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
			System.out.printf("Course: %s \t Score: %.1f \n", e.getKey(), e.getValue());
		}
		System.out.printf("------------------------------------------\nFinal Average: %.2f\tStatus: %s\n"
				+ "------------------------------------------\n",
				gradesAvg, status);
		
		/*
		double[] grades = new double[courses];
		String[] courseNames = new String[courses];
		for(int i=0; i<courses; i++) {
			System.out.printf("Enter name of course %d \n", (i+1));
			courseNames[i] = scanner.nextLine();
			System.out.println("Enter grade of " + courseNames[i]);
			grades[i] = scanner.nextFloat();
			scanner.nextLine();
		}
		
		double gradesAvg = Arrays.stream(grades).average().getAsDouble();
		
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
		for(int i=0; i<courses; i++) {
			System.out.printf("Course: %s \t Score: %.1f \n", courseNames[i], grades[i]);
		}
		System.out.printf("------------------------------------------\nFinal Average: %.2f\tStatus: %s\n",
				gradesAvg, status);*/
	}

}
