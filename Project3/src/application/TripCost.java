// Austin Long
// 04/21/2025
// Project 3
// This is for the TripCost class which performs conversion between measurements and calculates the total cost of the trip
package application;

public class TripCost {
	
	// Constants
	private static final double KILOMETERS_PER_MILE = 1.609347;
	private static final double LITERS_PER_GALLON = 3.78541178;
	private static final double MILES_PER_GALLON_PER_KPL = LITERS_PER_GALLON / KILOMETERS_PER_MILE; // This is 2.35214
	
	private final double distanceInMiles;
	private final double gasCostPerGallon;
	private final double mileageInMPG;
	private final double hotelCost;
	private final double foodCost;
	private final int numDays;
	private final double attractionCost;
	
	// Constructor
	public TripCost(double distance, String distanceUnit,
					double gasCost, String gasUnit,
					double mileage, String mileageUnit,
					double hotelCost, double foodCost, 
					int numDays, double attractionCost) {
		
		// Test which unit is selected and convert if necessary
		if (distanceUnit.equals("kilometers")) {
			distanceInMiles = distance / KILOMETERS_PER_MILE; // Divide the distance by KILOMETERS_PER_MILE to get the distance in miles
		} else {
			distanceInMiles = distance;
		}
		
		if (gasUnit.equals("dollars/liter")) {
			gasCostPerGallon = gasCost * LITERS_PER_GALLON; // Multiply the price by LITERS_PER_GALLON to get the cost in dollars per gallon
		} else {
			gasCostPerGallon = gasCost;
		}
		
		if (mileageUnit.equals("kms/liter")) {
			mileageInMPG = mileage * MILES_PER_GALLON_PER_KPL; // Multiply kms/liter by the constant MILES_PER_GALLON_PER_KPL to get the mileage in MPG
		} else {
			mileageInMPG = mileage;
		}
		
		this.hotelCost = hotelCost;
		this.foodCost = foodCost;
		this.numDays = numDays;
		this.attractionCost = attractionCost;
	}
	
	public double calculateTotalCost() {
		double gasTotalCost = (distanceInMiles / mileageInMPG) * gasCostPerGallon; // Find the total cost of the gas
		return gasTotalCost + (hotelCost + foodCost) * numDays + attractionCost;
	}
}
