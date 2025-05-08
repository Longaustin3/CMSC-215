// Austin Long
// 05/5/2025
// Project 4
// This is the class for the Time object which extends Comparable, includes all constructors and methods to create and compare time objects. 

package application;

public class Time implements Comparable<Time> { // Time implements Comparable so that it can used in Interval
	// Private attributes for hour, minute, meridian
	private final int hour;
	private final int minute;
	private final String meridian;
	
	// Constructor that creates a time object out of hour, minute, and meridian
	public Time(int hour, int minute, String meridian) throws InvalidTime {
		validateTime(hour, minute, meridian); // validate the time to ensure it meets the requirements before proceeding
		this.hour = hour;
		this.minute = minute;
		this.meridian = meridian.toUpperCase(); // set the meridian to UpperCase for uniformity
	}
	
	// Overloaded constructor that accepts a string
	public Time(String timeString) throws InvalidTime {
		try {
			String[] parts = timeString.trim().split(" "); // Create and array out of the different elements of the string, HH:MM and AM/PM
			if (parts.length != 2) throw new InvalidTime("Time format must be HH:MM AM/PM");
			
			// Create another array out of the two elements of the time HH:MM
			String[] timeParts = parts[0].split(":");
			// Set hour to the index 0 and minute to index 1
			int hour = Integer.parseInt(timeParts[0]);
			int minute = Integer.parseInt(timeParts[1]);
			// Set meridian to index 1 of parts array
			String meridian = parts[1];
			// Use the hour, minute, meridian to run validate
			validateTime(hour, minute, meridian);
			
			this.hour = hour;
			this.minute = minute;
			this.meridian = meridian.toUpperCase();
			
		} catch (Exception e) { // Catch and InvalidTime exceptions
			throw new InvalidTime("Invalid time format: " + e.getMessage()); // flexible error message for which issue is triggered
		}
	}
	
	// Method to ensure that time is a valid format, run in each constructor
	private void validateTime(int hour, int minute, String meridian) throws InvalidTime {
		if (hour < 1 || hour > 12) throw new InvalidTime("Hour must be between 1 and 12.");
		if (minute < 0 || minute > 59) throw new InvalidTime("Minute must be between 0 and 59.");
		if (!meridian.equalsIgnoreCase("AM") && !meridian.equalsIgnoreCase("PM")) {
			throw new InvalidTime("Meridian must be AM or PM.");
		}
	}
	
	@Override
	public int compareTo(Time other) {
		int thisTotal = this.totalMinutes();
		int otherTotal = other.totalMinutes();
		return Integer.compare(thisTotal,  otherTotal);
	}
	
	// Helper method to calculate the total amount of minutes in the time for comparison
	private int totalMinutes() {
		int h = this.hour % 12;
		if (this.meridian.equals("PM")) h += 12;
		return h * 60 + this.minute;
	}
	
	@Override
	public String toString() {
		return String.format("%02d:%02d %s", hour, minute, meridian); // Formatted Time string
	}
}
