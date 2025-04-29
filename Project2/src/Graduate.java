// Austin Long
// 04/08/2025
// Project 2
// This is for the Graduate class which extends student and adds degree to its constructor, also overrides student methods

public class Graduate extends Student{
	private String degree;
	
	//Constructor
	public Graduate (String name, int creditHours, int QualityPoints, String degree ) {
		super(name, creditHours, QualityPoints);
		this.degree = degree;
	}
	
	// Override eligibleForHonorSociety method from student
	@Override
	public boolean eligibleForHonorSociety() {
		if (degree.equals("Masters")) {
			return super.eligibleForHonorSociety();
		}
		return false;
	}
	
	// Override toString method
    @Override
    public String toString() {
        return super.toString() + " Degree: " + degree;
    }
}
