// Austin Long
// 04/08/2025
// Project 2
// This is for the Undergraduate class which extends student and adds year to its constructor, also overrides student methods

public class Undergraduate extends Student {
	private String year;
	
	// Constructor
	public Undergraduate(String name, int creditHours, int qualityPoints, String year) {
		super(name, creditHours, qualityPoints);
		this.year = year;
	}
	
	// Override eligibleForHonorSociety method from Student class
	@Override
	public boolean eligibleForHonorSociety() {
		if (year.equals("Junior") || year.equals("Senior")) {
			return super.eligibleForHonorSociety();
		}
		return false;
	}
	
	// Override toString
	@Override
	public String toString() {
		return super.toString() + " Year: " + year;
	}
}
