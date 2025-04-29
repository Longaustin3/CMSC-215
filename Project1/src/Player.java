// Austin Long
// 03/22/2025
// Project 1
// This is for the player class which creates a player object consisting of name, height, and age

public class Player {
	// create the name and age variable along with the height object for each player
	private final String name;
	private final Height height;
	private final int age;
		
	// Constructor
	public Player(String name, Height height, int age) {
		//assign the player the arguments from the constructor
		this.name = name;
		this.height = height;
		this.age = age;
	}
	
	// Getter methods for name, height, and age
	public String getName() {
		return name;
	}
	
	public Height getHeight() {
		return height;
	}
	
	public int getAge() {
		return age;
	}
		
	// Override toString method to return a string of the player
	@Override
	public String toString() {
		return "Player Name: " + name + ", Age: " + age + ", Height: " + height.toString();
	}
}
