// Austin Long
// 05/5/2025
// Project 4
// This is class to create an InvalidTime Exception. Includes a constructor and get method

package application;

public class InvalidTime extends Exception {
	// Private message attribute
	private final String message;
	
	// Constructor that accepts the message 
	public InvalidTime(String message) {
		super(message); // Call the constructor of the parent class Exception
		this.message = message; // Store the message
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
