// Austin Long
// 03/22/2025
// The purpose of this program is to identify the tallest basketball player whose age is less than or equal to the average
// of all players.

import java.util.Scanner;
import java.util.ArrayList;

public class Project1 {

	public static void main(String[] args) {
		// Create the scanner object
		Scanner scanner = new Scanner(System.in);
		
		// Create the ArrayList players to store each of the created players
		ArrayList<Player> players = new ArrayList<>();
		
		// initialized the totalAge and numPlayers to 0
		int totalAge = 0;
		int numPlayers = 0;
		
		// continue to prompt for additional players until an empty string is entered and the loop is broken
		while (true) {
			System.out.print("Enter player's name, age, and height in feet and inches: ");
			
			// Store name
			String input = scanner.nextLine().trim();
			
			// if there is no name, break out of the collecting loop
			if (input.isEmpty()) {
				break;
			}
			
			// Split the input between spaces and store in an array
			String[] inputParts = input.split(" ");
			
			//store name, age, and height
			String name = inputParts[0];
			int age = Integer.parseInt(inputParts[1]);
			int feet = Integer.parseInt(inputParts[2]);
			int inches = Integer.parseInt(inputParts[3]);
			
			// Create a Height object from feet and inches
			Height height = new Height(feet, inches);
			// Create a Player object with name, age, and the newly created height
			Player player = new Player(name, height, age);
			// Add the player to the players ArrayList
			players.add(player);
			
			// increase the total age and number of player
			totalAge += age;
			numPlayers++;
		}
		
		// If no players were entered, display that
		if (numPlayers == 0) {
			System.out.println("No player data entered.");
			return;
		}
		
		// Calculate the average age
		double averageAge = (double) totalAge / numPlayers;
		System.out.println("The average age of all players is: " + averageAge);
		
		// Find the tallest player whose age is <= the average age
		Player tallestPlayer = null;
		// For each player in players, check if the players age is less than the average, if it is, check if they are taller than the current tallest player. 
		for (Player player : players) {
			if (player.getAge() <= averageAge) {
				if (tallestPlayer == null || player.getHeight().toInches() > tallestPlayer.getHeight().toInches()) {
					tallestPlayer = player;
				}
			}
		}
		
		// print the result
		System.out.println("Tallest player whose age is less than the average is:");
		System.out.println("\t" + tallestPlayer);

	}

}
