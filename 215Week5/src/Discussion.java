import java.util.Scanner;

public class Discussion {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String decimal = "";
		
		while (true) {
			System.out.print("Enter a decimal: ");
			decimal = input.nextLine().trim();
			
			try {
				Double.parseDouble(decimal);
				break;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid decimal number");
			}
		}
		
		// if the input starts with a decimal rather than a number, add a zero the beginning
		if (decimal.startsWith(".")) {
			decimal = "0" + decimal;
		}
		
		String[] pieces = decimal.split("\\.");
		long wholeNumber = Long.parseLong(pieces[0]); // Convert to long to match the parameters of the rational constructor
		long fraction = Long.parseLong(pieces[1]); // Convert to long to match the parameters of the rational constructor
		int fractionalLength = pieces[1].length(); // obtain the length of the fractional portion to turn it into a denominator
		
		Rational r1 = new Rational(wholeNumber, 1); // make a rational number out of the whole number portion is there is one
		
		// make a rational number out of the fraction by making the denominator 10 to the power of the fractions length (.25 = 25/100)
		Rational r2 = new Rational(fraction, (long) Math.pow(10, fractionalLength)); 
		
		// the result is obtained by adding the first rational number to the second using the rational add method
		Rational result = r1.add(r2);
		
		// output the result to the screen
		System.out.println("The fraction number is " + result);
    }
}

// Copy from the book
class Rational extends Number implements Comparable<Rational> {
	// Data fields for numerator and denominator
	private long numerator = 0;
	private long denominator = 1;

	/** Construct a rational with default properties */
	public Rational() {
		this(0, 1);
	}

	/** Construct a rational with specified numerator and denominator */
	public Rational(long numerator, long denominator) {
		long gcd = gcd(numerator, denominator);
		this.numerator = (denominator > 0 ? 1 : -1) * numerator / gcd;
		this.denominator = Math.abs(denominator) / gcd;
	}

	/** Find GCD of two numbers */
	private static long gcd(long n, long d) {
		long n1 = Math.abs(n);
		long n2 = Math.abs(d);
		int gcd = 1;
    
		for (int k = 1; k <= n1 && k <= n2; k++) {
			if (n1 % k == 0 && n2 % k == 0) 
			  gcd = k;
		}

		return gcd;
	}

	/** Return numerator */
	public long getNumerator() {
		return numerator;
	}

	/** Return denominator */
	public long getDenominator() {
		return denominator;
	}

	/** Add a rational number to this rational */
	public Rational add(Rational secondRational) {
		long n = numerator * secondRational.getDenominator() +
				denominator * secondRational.getNumerator();
		long d = denominator * secondRational.getDenominator();
				return new Rational(n, d);
	}

	/** Subtract a rational number from this rational */
	public Rational subtract(Rational secondRational) {
		long n = numerator * secondRational.getDenominator()
				- denominator * secondRational.getNumerator();
		long d = denominator * secondRational.getDenominator();
				return new Rational(n, d);
	}

	/** Multiply a rational number to this rational */
	public Rational multiply(Rational secondRational) {
		long n = numerator * secondRational.getNumerator();
		long d = denominator * secondRational.getDenominator();
		return new Rational(n, d);
	}

	/** Divide a rational number from this rational */
	public Rational divide(Rational secondRational) {
		long n = numerator * secondRational.getDenominator();
		long d = denominator * secondRational.numerator;
		return new Rational(n, d);
	}

	@Override  
	public String toString() {
		if (denominator == 1)
			return numerator + "";
		else
			return numerator + "/" + denominator;
	}

	@Override // Override the equals method in the Object class 
	public boolean equals(Object other) {
		if ((this.subtract((Rational)(other))).getNumerator() == 0)
			return true;
		else
			return false;
	}

	@Override // Implement the abstract intValue method in Number 
	public int intValue() {
		return (int)doubleValue();
	}

	@Override // Implement the abstract floatValue method in Number 
	public float floatValue() {
		return (float)doubleValue();
	}

	@Override // Implement the doubleValue method in Number 
	public double doubleValue() {
		return numerator * 1.0 / denominator;
	}

	@Override // Implement the abstract longValue method in Number
	public long longValue() {
		return (long)doubleValue();
	}

	@Override // Implement the compareTo method in Comparable
	public int compareTo(Rational o) {
		if (this.subtract(o).getNumerator() > 0)
			return 1;
		else if (this.subtract(o).getNumerator() < 0)
			return -1;
		else
			return 0;
	}
}