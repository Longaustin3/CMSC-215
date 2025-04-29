// Austin Long
// 04/21/2025
// Project 3
// This is the main class for Project 3 which defines the GUI and handles all input and output
package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Project3 extends Application {
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create the GridPane and set the padding, vertical, and horizontal gaps
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10));
		grid.setVgap(5);
		grid.setHgap(5); 
		
		// Creating all of the nodes to be added to the GridPane after
		// Distance
		Label distanceLabel = new Label("Distance:");
		TextField distanceField = new TextField();
		distanceField.setAlignment(Pos.CENTER_RIGHT);
		ComboBox<String> distanceUnit = new ComboBox<>();
		distanceUnit.getItems().addAll("miles", "kilometers");
		distanceUnit.setValue("miles");
		distanceUnit.setPrefWidth(110);
		
		// Gasoline Cost
		Label gasCostLabel = new Label("Gasoline Cost:");
		TextField gasCostField = new TextField();
		gasCostField.setAlignment(Pos.CENTER_RIGHT);
		ComboBox<String> gasCostUnit = new ComboBox<>();
		gasCostUnit.getItems().addAll("dollars/gal", "dollars/liter");
		gasCostUnit.setValue("dollars/gal");
		gasCostUnit.setPrefWidth(110);
		
		// Gas Mileage 
		Label gasMileageLabel = new Label("Gas Mileage:");
		TextField gasMileageField = new TextField();
		gasMileageField.setAlignment(Pos.CENTER_RIGHT);
		ComboBox<String> gasMileageUnit = new ComboBox<>();
		gasMileageUnit.getItems().addAll("miles/gallon", "kms/liter");
		gasMileageUnit.setValue("miles/gallon");
		gasMileageUnit.setPrefWidth(110);
		
		// Number of Days
		Label numDaysLabel = new Label("Number of Days:");
		TextField numDaysField = new TextField();
		numDaysField.setAlignment(Pos.CENTER_RIGHT);
		
		// Hotel Cost
		Label hotelCostLabel = new Label("Hotel Cost:");
		TextField hotelCostField = new TextField();
		hotelCostField.setAlignment(Pos.CENTER_RIGHT);
		
		// Food Cost
		Label foodCostLabel = new Label("Food Cost:");
		TextField foodCostField = new TextField();
		foodCostField.setAlignment(Pos.CENTER_RIGHT);
		
		// Attractions
		Label attractionsLabel = new Label("Attractions:");
		TextField attractionsField = new TextField();
		attractionsField.setAlignment(Pos.CENTER_RIGHT);
		
		// Output section
		Label tripCostLabel = new Label("Total Trip Cost:");
		TextField tripCostField = new TextField();
		tripCostField.setAlignment(Pos.CENTER_RIGHT);
		tripCostField.setEditable(false);
		
		// Calculate Button
		Button calculateButton = new Button("Calculate");
		calculateButton.setPrefWidth(150);
		
		// Lambda expression for the event handler on the calculate button
		calculateButton.setOnAction(e -> {
			try {
				// From the distance section
				double distance = Double.parseDouble(distanceField.getText());
				String distUnit = distanceUnit.getValue();
				
				// From the gas cost section
				double gasCost = Double.parseDouble(gasCostField.getText());
				String gasUnit = gasCostUnit.getValue();
				
				// From the gas mileage section
				double gasMileage = Double.parseDouble(gasMileageField.getText());
				String mileageUnit = gasMileageUnit.getValue();
				
				// The rest of the inputs
				int days = Integer.parseInt(numDaysField.getText());
				double hotel = Double.parseDouble(hotelCostField.getText());
				double food = Double.parseDouble(foodCostField.getText());
				double attractions = Double.parseDouble(attractionsField.getText());
				
				// Calculations using a the TripCost constructor and calculateTotalCost method
				TripCost trip = new TripCost(distance, distUnit, gasCost, gasUnit, gasMileage, mileageUnit, hotel, food, days, attractions);
				double totalCost = trip.calculateTotalCost();
				
				// Output formatting
				tripCostField.setText(String.format("$%.2f", totalCost)); // Add $ for cost and round to 2 decimals
			} catch (NumberFormatException ex) { // catch any errors with the input
				tripCostField.setText("Invalid input");
			}
		});
		
		// Adding everything to the GridPane
		// Distance line
		grid.add(distanceLabel, 0, 0);
		grid.add(distanceField, 1, 0);
		grid.add(distanceUnit, 2, 0);
		
		//Gas Cost line
		grid.add(gasCostLabel, 0, 1);
		grid.add(gasCostField, 1, 1);
		grid.add(gasCostUnit, 2, 1);
		
		// Gas Mileage line
		grid.add(gasMileageLabel, 0, 2);
		grid.add(gasMileageField, 1, 2);
		grid.add(gasMileageUnit, 2, 2);
		
		// Number of Days line
		grid.add(numDaysLabel, 0, 3);
		grid.add(numDaysField, 1, 3);
		
		// Hotel Cost line
		grid.add(hotelCostLabel, 0, 4);
		grid.add(hotelCostField, 1, 4);
		
		// Food Cost line
		grid.add(foodCostLabel, 0, 5);
		grid.add(foodCostField, 1, 5);
		
		// Attractions line
		grid.add(attractionsLabel, 0, 6);
		grid.add(attractionsField, 1, 6);
		
		// Calculate Button
		grid.add(calculateButton, 1, 7);
		
		// Total Cost line
		grid.add(tripCostLabel, 0, 8);
		grid.add(tripCostField, 1, 8);
		
		// Create a scene, add the grid to it, and place the scene in the stage
		Scene scene = new Scene(grid, 400, 300);
		primaryStage.setTitle("Trip Cost Estimator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
