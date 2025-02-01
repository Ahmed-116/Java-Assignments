package com.example.guitable;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class TableViews extends Application {

    private final ObservableList<Person> data = FXCollections.observableArrayList();

    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        TableView<Person> tableView = new TableView<>();
        tableView.setEditable(true);
        TableColumn<Person, String> col1 = new TableColumn<>("Name");
        TableColumn<Person, Integer> col2 = new TableColumn<>("Age");
        TableColumn<Person, String> col3 = new TableColumn<>("Gender");
        TableColumn<Person, Integer> col4 = new TableColumn<>("Height");
        TableColumn<Person, Integer> col5 = new TableColumn<>("Weight");

        col1.setCellValueFactory(new PropertyValueFactory<>("name"));
        col1.setCellFactory(TextFieldTableCell.forTableColumn());
        col1.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {


            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> personIntegerCellEditEvent) {
                Person person = personIntegerCellEditEvent.getRowValue();
                person.setName(personIntegerCellEditEvent.getNewValue());
            }
        });
        col2.setCellValueFactory(new PropertyValueFactory<>("age"));
        col2.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        col2.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, Integer>>() {


            @Override
            public void handle(TableColumn.CellEditEvent<Person, Integer> personIntegerCellEditEvent) {
                Person person = personIntegerCellEditEvent.getRowValue();
                person.setAge(personIntegerCellEditEvent.getNewValue());
            }
        });
        col3.setCellValueFactory(new PropertyValueFactory<>("gender"));
        col3.setCellFactory(TextFieldTableCell.forTableColumn());
        col3.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {


            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> personIntegerCellEditEvent) {
                Person person = personIntegerCellEditEvent.getRowValue();
                person.setGender(personIntegerCellEditEvent.getNewValue());
            }
        });
        col4.setCellValueFactory(new PropertyValueFactory<>("height"));
        col4.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        col4.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, Integer>>() {


            @Override
            public void handle(TableColumn.CellEditEvent<Person, Integer> personIntegerCellEditEvent) {
                Person person = personIntegerCellEditEvent.getRowValue();
                person.setHeight(personIntegerCellEditEvent.getNewValue());
            }
        });
        col5.setCellValueFactory(new PropertyValueFactory<>("weight"));
        col5.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        col5.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, Integer>>() {


            @Override
            public void handle(TableColumn.CellEditEvent<Person, Integer> personIntegerCellEditEvent) {
                Person person = personIntegerCellEditEvent.getRowValue();
                person.setWeight(personIntegerCellEditEvent.getNewValue());
            }
        });


        data.add(new Person("Ahmed", 19, "Male", 5, 68));
        data.add(new Person("Bob", 22, "Female", 5, 68));

        tableView.setItems(data);
        tableView.getColumns().addAll(col1, col2, col3, col4, col5);


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
                data.add(new Person(nameField.getText(),
                        Integer.parseInt(ageField.getText()),genderField.getText(),
                        Integer.parseInt(heightField.getText()),Integer.parseInt(weightField.getText())));
                nameField.clear();
                ageField.clear();
                genderField.clear();
                heightField.clear();
                weightField.clear();



            }
        });
        HBox hBox = new HBox(20);
        hBox.getChildren().addAll(nameField, ageField, genderField, heightField, weightField);
        hBox.setSpacing(4);

        root.getChildren().addAll( tableView,tableView);


        tableView.getColumnResizePolicy();
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("TableView");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

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
