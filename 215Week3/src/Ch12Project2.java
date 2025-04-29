import java.util.Scanner;

public class Ch12Project2 {
	// method to convert binary string to decimal format
    public static int bin2Dec(String binaryString) throws NumberFormatException {
    	// if the binary string does not contain only 1 and 0 matching the format, throw exception
        if (!binaryString.matches("[01]+")) {
            throw new NumberFormatException("Not a binary number");
        }
        // return the value of the binary string
        return Integer.parseInt(binaryString, 2);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // prompt the use to enter a binary number
        System.out.print("Enter a binary number: ");
        // store in a binaryString variable
        String binaryString = input.nextLine();
        // exception handling to call the bin2Dec method and store the value in the decimal method or catch exception
        try {
            int decimal = bin2Dec(binaryString);
            System.out.println("Decimal equivalent: " + decimal);
        } catch (NumberFormatException ex) {
            System.out.println("Not a binary number");
        }
    }

}
