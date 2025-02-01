
package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class HelloApplication extends Application {
    ArrayList<Person> personArrayList=new ArrayList<>();
    @Override
    public void start(Stage stage) {
        // Main layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));
        root.setAlignment(Pos.TOP_CENTER);

        // Banner
        Label banner = new Label("ID FORM:");
        banner.setStyle("-fx-font-size: 20px; -fx-border-color: #3d3232; -fx-padding: 10;");
        banner.setMaxWidth(Double.MAX_VALUE);
        banner.setAlignment(Pos.CENTER);

        // GridPane for Form
        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.setAlignment(Pos.CENTER_LEFT);

        // Form Fields
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label fatherNameLabel = new Label("Father Name:");
        TextField fatherNameField = new TextField();

        Label cnicLabel = new Label("CNIC:");
        TextField cnicField = new TextField();

        Label dobLabel = new Label("Date of Birth:");
        DatePicker dobPicker = new DatePicker();

        Label genderLabel = new Label("Gender:");
        ToggleGroup genderGroup = new ToggleGroup();
        RadioButton maleButton = new RadioButton("Male");
        RadioButton femaleButton = new RadioButton("Female");
        maleButton.setToggleGroup(genderGroup);
        femaleButton.setToggleGroup(genderGroup);
        HBox genderBox = new HBox(10, maleButton, femaleButton);

        Label cityLabel = new Label("City:");
        ComboBox<String> cityComboBox = new ComboBox<>();
        cityComboBox.getItems().addAll("Lahore", "Karachi", "Islamabad", "Peshawar");

        // Adding fields to GridPane
        form.add(nameLabel, 0, 0);
        form.add(nameField, 1, 0);
        form.add(fatherNameLabel, 0, 1);
        form.add(fatherNameField, 1, 1);
        form.add(cnicLabel, 0, 2);
        form.add(cnicField, 1, 2);
        form.add(dobLabel, 0, 3);
        form.add(dobPicker, 1, 3);
        form.add(genderLabel, 0, 4);
        form.add(genderBox, 1, 4);
        form.add(cityLabel, 0, 5);
        form.add(cityComboBox, 1, 5);

        // Image and File Chooser Section
        VBox imageSection = new VBox(10);
        imageSection.setAlignment(Pos.CENTER);

        Label imageLabel = new Label("Image:");
        ImageView imageView = new ImageView();
        imageView.setFitWidth(150);
        imageView.setFitHeight(150);
        imageView.setStyle("-fx-border-color: gray;");
        Button fileChooserButton = new Button("Choose File");
        fileChooserButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
           fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));

            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                imageView.setImage(new Image(file.toURI().toString()));
            }
        });

        imageSection.getChildren().addAll(imageLabel, imageView, fileChooserButton);

        // Save Button
        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            String name = nameField.getText();
            String fatherName = fatherNameField.getText();
            String cnic = cnicField.getText();
            String dob = (dobPicker.getValue() != null) ? dobPicker.getValue().toString() : "Not Selected";
            RadioButton selectedGender = (RadioButton) genderGroup.getSelectedToggle();
            String gender = (selectedGender != null) ? selectedGender.getText() : "Not Selected";
            String city = cityComboBox.getValue();
            Person person = new Person(name, fatherName, cnic, dob, gender, city);
            personArrayList.add(person);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Saved Data");
            alert.setHeaderText("Form Data Saved Successfully!");
            alert.setContentText("Name: " + name + "\nFather Name: " + fatherName + "\nCNIC: " + cnic +
                    "\nDate of Birth: " + dob + "\nGender: " + gender + "\nCity: " + city);
            alert.showAndWait();
        });
        // Add the Print Data Button
        Button printButton = new Button("Print Data");
        printButton.setOnAction(e -> {
            if (personArrayList.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("No Data");
                alert.setHeaderText("No Data Available");
                alert.setContentText("The list is empty. Please save some data first.");
                alert.showAndWait();
            } else {
                StringBuilder data = new StringBuilder();
                for (Person person : personArrayList) {
                    data.append("Name: ").append(person.getName())
                            .append("\nFather Name: ").append(person.getFathername())
                            .append("\nCNIC: ").append(person.getCnic())
                            .append("\nDate of Birth: ").append(person.getDob())
                            .append("\nGender: ").append(person.getGender())
                            .append("\nCity: ").append(person.getCity())
                            .append("\n-------------------------\n");
                }

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Print Data");
                alert.setHeaderText("All Saved Data");
                alert.setContentText(data.toString());
                alert.showAndWait();
            }
        });

// Add Print Button to the Root
        root.getChildren().add(printButton);

        // Combine form and image section
        HBox mainContent = new HBox(20, form, imageSection);
        mainContent.setAlignment(Pos.CENTER);

        // Add all components to the root
        root.getChildren().addAll(banner, mainContent, saveButton);

        // Scene and Stage
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("My Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}
