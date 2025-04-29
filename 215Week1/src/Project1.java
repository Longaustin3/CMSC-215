// This Project is for the CMSC 215 week 1 discussion
// 03/16/2025

public class Project1 {

	public static void main(String[] args) {
		Time time1 = new Time();
		Time time2 = new Time(555550000);
		Time time3 = new Time(5, 23, 55);

		System.out.println("Time 1: " + time1.getHour() + ":" + time1.getMinute() + ":" + time1.getSecond());
	    System.out.println("Time 2: " + time2.getHour() + ":" + time2.getMinute() + ":" + time2.getSecond());
	    System.out.println("Time 3: " + time3.getHour() + ":" + time3.getMinute() + ":" + time3.getSecond());
	}

}

class Time {
	private int hour;
	private int minute;
	private int second;
	
	// No-arg constructor
	public Time() {
		// Create date object for current time
		long elapsedTime = System.currentTimeMillis();
		setTime(elapsedTime);
	}
	
	// Constructor that creates a Time object with specified elapsed time in milliseconds
	public Time(long elapsedTime) {
		setTime(elapsedTime);
	}
	
	// Constructor to create Time object with specified hour, minute, second
	public Time(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	// Get methods for hour, minute, second
	public int getHour() {
		return hour;
	}
	
	public int getMinute() {
		return minute;
	}
	
	public int getSecond() {
		return second;
	}
	
	// Method to set time using elapsed time
	public void setTime(long elapsedTime) {
		// Calculate total number of seconds since midnight, January 1, 1970
		long totalSeconds = elapsedTime / 1000;
		
		// Calculate total number of minutes
		long totalMinutes = totalSeconds / 60;
		
		// Calculate total number of hours
		long totalHours = totalMinutes / 60;
		
		// Set hour, minute and second
		this.hour = (int) (totalHours % 24); // convert the total hours to within a 24 hour day
		this.minute = (int) (totalMinutes % 60); // only calculate the minute within the hour
		this.second = (int) (totalSeconds % 60); // only calculate the seconds within the minute
	}
}
