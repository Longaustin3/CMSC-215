// Austin Long
// 04/08/2025
// Project 2
// This is class that houses the main method for Project 2 and handles all input, calculation, and output

import java.io.*;
import java.util.*;

public class Project2 {

	public static void main(String[] args) {
		// Create ArrayList to store students
		List<Student> students = new ArrayList<>();
		double totalGpa = 0;
		int count = 0;
		
		// Read the students from the students.txt file using Scanner 
		try (Scanner scanner = new Scanner(new File("students.txt"))) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] info = line.split(" ");
				
				// Store each element of the students info to variables
				String name = info[0];
				int creditHours = Integer.parseInt(info[1]);
				int qualityPoints = Integer.parseInt(info[2]);
				String yearOrDegree = info[3];
				
				// Create a student object that will be set in the following block
				Student student;
				
				// Create either a graduate or undergraduate student depending on the last field
				if (yearOrDegree.equals("Masters") || yearOrDegree.equals("Doctorate")) {
                    student = new Graduate(name, creditHours, qualityPoints, yearOrDegree);
                } else {
                    student = new Undergraduate(name, creditHours, qualityPoints, yearOrDegree);
                }
				
				// add the student to the array and increase the count and total GPA
				students.add(student);
                totalGpa += student.gpa();
                count++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error reading the file. Make sure 'students.txt' exists.");
			return;
		}
		
		// if there are no students entered
		if (count == 0) {
            System.out.println("No student data to process.");
            return;
        }
		
		// Calculate average GPA
		double averageGpa = totalGpa / count;
		
		// Set the GPA threshold
		double gpaThreshold = (averageGpa + 4.0) / 2;
		Student.setGpaThreshold(gpaThreshold);
		
		// Output the GPA threshold
		System.out.println("GPA Threshold for membership is " + String.format("%.2f", gpaThreshold));
		
		// Boolean value to track if eligible students are found
		boolean elegibleFound = false;
		
		// Output students eligible for Honor Society
		System.out.println("\nStudents eligible for Honor Society:");
		for (Student student : students) {
			if (student.eligibleForHonorSociety()) {
				System.out.println(student);
				elegibleFound = true; // update the boolean if eligible students are found
			}
		}
		
		// If no students are eligible for the Honor Society
		if (!elegibleFound) {
			System.out.println("No students are elegible for the Honor Society.");
		}
	}
}
