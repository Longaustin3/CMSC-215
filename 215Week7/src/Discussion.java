import java.util.Scanner;

public class Discussion {
	
	public static String dec2Bin(int value) {
		// Base cases of 0 or 1
		if (value == 0) {
			return "0";
		} else if ( value ==1) {
			return "1";
		}
		// Recursively build the binary number
		return dec2Bin(value / 2) + (value % 2); // continuously dividing the number by 2 and adding the remainder builds the binary string
	}
	
	public static void main(String[] args) {
		// Create a scanner object
		Scanner scanner = new Scanner(System.in);
		// Get the decimal integer from the user
		System.out.print("Enter a decimal integer: ");
		int decimal = scanner.nextInt();
		// Output the binary number
		System.out.println(decimal + " decimal is binary " + dec2Bin(decimal));
	}
}
