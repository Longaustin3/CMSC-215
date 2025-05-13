// Austin Long
// 05/5/2025
// Project 4
// This is class for the generic Interval object with methods to test if an interval is a subinterval or overlaps with another interval, and to test if a value exists within the interval

package application;

public class Interval <T extends Comparable<T>> {
	// Private generic attributes start and end
	private final T start;
	private final T end;
	
	// Constructor that takes a start and end time
	public Interval(T start, T end) {
		if (start.compareTo(end) > 0) { // If the start time is greater than the end time, it will return greater than 0 and throw an error
			throw new IllegalArgumentException("Start must be less than or equal to end.");
		}
		// Assign start and end times
		this.start = start;
		this.end = end;
	}
	
	// Method to check if a given time is within an interval
	public boolean within (T value) {
		return value.compareTo(start) >= 0 && value.compareTo(end) <= 0;
	}
	
	// Method to determine if one interval exists entirely within another interval as a subinterval
	public boolean subinterval (Interval<T> other) {
		return other.start.compareTo(this.start) >= 0 && other.end.compareTo(this.end) <= 0; // Returns true if other is within this
	}
	
	// Method to check if the two intervals overlap at one end or the other
	public boolean overlaps (Interval<T> other) {
		return !(other.end.compareTo(this.start) < 0 || other.start.compareTo(this.end) > 0); // Returns true if other overlaps this
	}
	
	// Get methods for start and end
	public T getStart() { return start; }
	public T getEnd() { return end; }
	
	@Override
	public String toString() {
		return "[" + start + " - " + end + "]";
	}
}
