// Austin Long
// 03/22/2025
// Project 1
// This is for the height class which creates a height object consisting of feet and inches to be assigned to a player

public class Height {
	// create the feet and inches variables for the height object
	private final int feet;
	private final int inches;
	
	//constructor
	public Height(int feet, int inches) {
		// if inches >= 12, convert to feet
		this.feet = feet + inches / 12;
		this.inches = inches % 12; 
	}
	
	// Method for converting height to total inches
	public int toInches() {
		return feet * 12 + inches;
	}
	
	// Method to return a string of the height
	@Override
	public String toString() {
		return feet + "'" + inches + "\"";
	}
}
