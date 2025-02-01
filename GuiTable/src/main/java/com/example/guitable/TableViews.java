package com.example.guitable;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class TableViews extends Application {

    private final ObservableList<Person> data = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        // Create TableView
        TableView<Person> tableView = new TableView<>();
        tableView.setEditable(false);

        // Create Columns
        TableColumn<Person, String> col1 = new TableColumn<>("Name");
        TableColumn<Person, Integer> col2 = new TableColumn<>("Age");
        TableColumn<Person, String> col3 = new TableColumn<>("Gender");
        TableColumn<Person, Integer> col4 = new TableColumn<>("Height");
        TableColumn<Person, Integer> col5 = new TableColumn<>("Weight");

        // Set Cell Value Factories
        col1.setCellValueFactory(new PropertyValueFactory<>("name"));
        col1.setCellFactory(TextFieldTableCell.forTableColumn());
        col1.setOnEditCommit(event -> event.getRowValue().setName(event.getNewValue()));

        col2.setCellValueFactory(new PropertyValueFactory<>("age"));
        col2.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        col2.setOnEditCommit(event -> event.getRowValue().setAge(event.getNewValue()));

        col3.setCellValueFactory(new PropertyValueFactory<>("gender"));
        col3.setCellFactory(TextFieldTableCell.forTableColumn());
        col3.setOnEditCommit(event -> event.getRowValue().setGender(event.getNewValue()));

        col4.setCellValueFactory(new PropertyValueFactory<>("height"));
        col4.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        col4.setOnEditCommit(event -> event.getRowValue().setHeight(event.getNewValue()));

        col5.setCellValueFactory(new PropertyValueFactory<>("weight"));
        col5.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        col5.setOnEditCommit(event -> event.getRowValue().setWeight(event.getNewValue()));

        // Add Data
        data.add(new Person("Ahmed", 19, "Male", 5, 68));
        data.add(new Person("Bob", 22, "Female", 5, 68));

        // Set Data and Columns
        tableView.setItems(data);
        tableView.getColumns().addAll(col1, col2, col3, col4, col5);

        // Style Table (Padding, cell spacing)
        tableView.setStyle("-fx-padding: 10;");
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Input Fields with HBox (Horizontal layout)
        HBox inputBox = new HBox(10); // 10px horizontal spacing between elements
        inputBox.setPadding(new Insets(10)); // Padding for the whole HBox

        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        TextField ageField = new TextField();
        ageField.setPromptText("Age");

        TextField genderField = new TextField();
        genderField.setPromptText("Gender");

        TextField heightField = new TextField();
        heightField.setPromptText("Height");

        TextField weightField = new TextField();
        weightField.setPromptText("Weight");

        Button addBtn = new Button("Add");
        addBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // Add a new person to the table
                data.add(new Person(nameField.getText(),
                        Integer.parseInt(ageField.getText()), genderField.getText(),
                        Integer.parseInt(heightField.getText()), Integer.parseInt(weightField.getText())));

                // Clear input fields
                nameField.clear();
                ageField.clear();
                genderField.clear();
                heightField.clear();
                weightField.clear();
            }
        });

        // Add input fields and button to HBox
        inputBox.getChildren().addAll(nameField, ageField, genderField, heightField, weightField, addBtn);

        // Set up the layout with the table and input fields
        root.setCenter(tableView); // Set the table to the center of the BorderPane
        root.setBottom(inputBox); // Set the input fields at the bottom of the BorderPane

        // Create the scene and set up the stage
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("TableView Example");
        //primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Person class to hold data for each row in the table
    public static class Person {
        private String name;
        private int age;
        private String gender;
        private int height;
        private int weight;

        public Person(String name, int age, String gender, int height, int weight) {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.height = height;
            this.weight = weight;
        }

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
