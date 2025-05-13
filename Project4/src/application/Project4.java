// Austin Long
// 05/5/2025
// Project 4
// This is the main class for Project 4 which defines the GUI and handles all input and output

package application;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Project4 extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		// Create the GridPane and set the padding, vertical, and horizontal gaps
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10));
		grid.setVgap(5);
		grid.setHgap(5); 
		
		// Row 1
		Label startTime = new Label("Start Time");
		startTime.setMaxWidth(Double.MAX_VALUE); // sets the width to max and centers it
		startTime.setAlignment(Pos.CENTER);
		GridPane.setHalignment(startTime, HPos.CENTER);
		Label endTime = new Label("End Time");
		endTime.setMaxWidth(Double.MAX_VALUE); // sets the width to max and centers it
		endTime.setAlignment(Pos.CENTER);
		GridPane.setHalignment(endTime, HPos.CENTER);
		
		// Row 2
		Label interval1Label = new Label("Time Interval 1");
		TextField interval1StartField = new TextField();
		interval1StartField.setAlignment(Pos.CENTER); // text appears in the center of the textfield
		TextField interval1EndField = new TextField();
		interval1EndField.setAlignment(Pos.CENTER);
		
		// Row 3
		Label interval2Label = new Label("Time Interval 2");
		TextField interval2StartField = new TextField();
		interval2StartField.setAlignment(Pos.CENTER);
		TextField interval2EndField = new TextField();
		interval2EndField.setAlignment(Pos.CENTER);
		
		// Row 4
		Button compareButton = new Button("Compare Intervals");
		compareButton.setPrefWidth(410); // makes the button as wide as the content
		
		// Row 5
		Label checkTimeLabel = new Label ("Time to Check");
		TextField checkTimeField = new TextField();
		checkTimeField.setAlignment(Pos.CENTER);
		
		// Row 6
		Button checkTimeButton = new Button("Check Time");
		checkTimeButton.setPrefWidth(410); // makes the button as wide as the content
		
		// Row 7
		TextField resultField = new TextField();
		resultField.setEditable(false);
		
		compareButton.setOnAction(e -> {
			try {
				// Set the times to the information entered in the textfields
				Time t1Start = new Time(interval1StartField.getText());
				Time t1End = new Time(interval1EndField.getText());
				Time t2Start = new Time(interval2StartField.getText());
				Time t2End = new Time(interval2EndField.getText());
				
				// Create intervals from the information
				Interval<Time> interval1 = new Interval<>(t1Start, t1End);
				Interval<Time> interval2 = new Interval<>(t2Start, t2End);
				
				// Check the intervals against each other and set the result to corresponding string
				String result;
				if (interval1.subinterval(interval2)) {
					result = "Interval 2 is a sub-interval of interval 1";
				} else if (interval2.subinterval(interval1)) {
					result = "Interval 1 is a sub-interval of interval 2";
				} else if (interval1.overlaps(interval2)) {
					result = "The intervals overlap";
				} else {
					result = "The intervals are disjoint";
				}
				
				resultField.setText(result);
			// catch the possible exceptions of InvalidTime or IllegalArgumentException
			} catch (InvalidTime ex) { // If the times are of the wrong format or not a time
				resultField.setText("Error: " + ex.getMessage());
			} catch (IllegalArgumentException ex) { // If there is something wrong with the interval (start > end)
				resultField.setText("Invalid interval: " + ex.getMessage());
			}
		});
		
		checkTimeButton.setOnAction(e -> {
			try {
				// Store the time to check as a new time object
				Time checkTime = new Time(checkTimeField.getText());
				
				// Store the 2 intervals to check within
				Interval<Time> interval1 = new Interval<>(
					new Time(interval1StartField.getText()),
					new Time(interval1EndField.getText())
				);
				
				Interval<Time> interval2 = new Interval<>(
					new Time(interval2StartField.getText()),
					new Time(interval2EndField.getText())
				);
				
				// Check each interval to see if the time is within
				boolean in1 = interval1.within(checkTime);
				boolean in2 = interval2.within(checkTime);
				
				// Set the result to the corresponding string
				String result;
				if (in1 && in2) {
					result = "Both intervals contain the time " + checkTime;
				} else if (in1) {
					result = "Only interval 1 contains the time " + checkTime;
				} else if (in2) {
					result = "Only interval 2 contains the time " + checkTime;
				} else {
					result = "Neither interval contains the time " + checkTime;
				}
				
				resultField.setText(result);
			// Catch possible invalid time exception
			} catch (InvalidTime ex) {
				resultField.setText("Invalid check time: " + ex.getMessage());
			}
		});
		
		// Adding everything to its spot in the Grid pane
		// Start/Stop Line
		grid.add(startTime, 1, 0);
		grid.add(endTime, 2, 0);
		
		// Interval 1 Line
		grid.add(interval1Label, 0, 1);
		grid.add(interval1StartField, 1, 1);
		grid.add(interval1EndField, 2, 1);
		
		// Interval 2 Line
		grid.add(interval2Label, 0, 2);
		grid.add(interval2StartField, 1, 2);
		grid.add(interval2EndField, 2, 2);
		
		// Compare Button line
		grid.add(compareButton, 0, 3, 3, 1); // makes the button span the whole row
		
		// Time to Check Line
		grid.add(checkTimeLabel, 0, 4);
		grid.add(checkTimeField, 1, 4, 2, 1); // makes the button two columns wide
		
		// Check Button Line
		grid.add(checkTimeButton, 0, 5, 3, 1); // makes the button span the whole row
		
		// Results line
		grid.add(resultField, 0, 6, 3, 1); // makes the button span the whole row
		
		Scene scene = new Scene(grid, 420, 215);	
		primaryStage.setTitle("Time Interval Checker");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
