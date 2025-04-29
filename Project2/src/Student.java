// Austin Long
// 04/08/2025
// Project 2
// This is for the student class which creates a student object and calculates GPA and check Honor Society eligibility

public class Student {
	private String name;
	private int creditHours;
	private int qualityPoints;
	private static double gpaThreshold;
	
	// Constructor
	public Student(String name, int creditHours, int qualityPoints) {
		this.name = name;
		this.creditHours = creditHours;
		this.qualityPoints = qualityPoints;
	}
	
	// GPA method
	public double gpa() {
		return (double) qualityPoints / creditHours;
	}
	
	// Method that checks if student is eligible for honor society
	public boolean eligibleForHonorSociety() {
		return gpa() >= gpaThreshold;
	}
	
	// toString method
	public String toString() {
		return "Name: " + name + " GPA: " + String.format("%.2f", gpa());
	}
	
	// Static method to set the GPA threshold
	public static void setGpaThreshold(double threshold) {
		gpaThreshold = threshold;
	}
	
//	public static double getGpaThreshold() {
//		return gpaThreshold;
//	}
}
