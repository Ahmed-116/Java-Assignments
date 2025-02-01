//package com.example.employeesalarymanagement;
//
//import javafx.application.Application;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXMLLoader;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class HelloApplication extends Application {
//
//    //Employee employee;
//    ObservableList<Employee> employees = FXCollections.observableArrayList();
//    private final File file = new File("employees.txt");
//    String fileName = "employees.txt";
//
//
//    @Override
//    public void start(Stage stage) throws IOException {
//
//
//
//        Button addEmployeeButton = new Button("Add Employee");
//        Button viewPayrollButton = new Button("View Payroll Records");
//        Button exitButton = new Button("Exit");
//
//        VBox mainMenu = new VBox(20, addEmployeeButton, viewPayrollButton, exitButton);
//        mainMenu.setAlignment(Pos.CENTER);
//        mainMenu.setPadding(new Insets(20));
//
//        addEmployeeButton.setOnAction(e -> {
//            try {
//                addEmployee(stage);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        Scene mainScene = new Scene(mainMenu, 600, 400);
//        stage.setScene(mainScene);
//        stage.setTitle("Employee Payroll System");
//        stage.show();
//
//        viewPayrollButton.setOnAction(e -> {
//            try {
//                tableView(stage);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//        exitButton.setOnAction(e -> {
//            System.exit(0);
//        });
//    }
//
//    public void tableView(Stage stage) throws IOException {
//        loadFromFile();
//
//
//        TableView<Employee> tableView = new TableView<>();
//        tableView.setItems(employees);
//
//        TableColumn<Employee, String> nameCol = new TableColumn<>("Name");
//        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
//
//        TableColumn<Employee, String> idCol = new TableColumn<>("ID");
//        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
//
//        TableColumn<Employee, String> ageCol = new TableColumn<>("Age");
//        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
//
//        TableColumn<Employee, String> genderCol = new TableColumn<>("Gender");
//        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
//
//        TableColumn<Employee, String> departmentCol = new TableColumn<>("Department");
//        departmentCol.setCellValueFactory(new PropertyValueFactory<>("department"));
//
//        TableColumn<Employee, String> baseSalaryCol = new TableColumn<>("Base Salary");
//        baseSalaryCol.setCellValueFactory(new PropertyValueFactory<>("baseSalary"));
//
//        TableColumn<Employee, String> hoursWorkedCol = new TableColumn<>("Hours Worked");
//        hoursWorkedCol.setCellValueFactory(new PropertyValueFactory<>("hoursWorked"));
//
//        TableColumn<Employee, String> ratingCol = new TableColumn<>("Performance Rating");
//        ratingCol.setCellValueFactory(new PropertyValueFactory<>("performanceRating"));
//
//        TableColumn<Employee, Double> totalSalaryCol = new TableColumn<>("Total Salary");
//        totalSalaryCol.setCellValueFactory(new PropertyValueFactory<>("totalSalary"));
//
//
//
//        tableView.getColumns().addAll(nameCol,idCol,ageCol,genderCol,departmentCol,baseSalaryCol,hoursWorkedCol,ratingCol, totalSalaryCol);
//
//        Button backButton = new Button("Back");
//        backButton.setOnAction(e -> {
//            try {
//                start(stage);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        VBox layout = new VBox(20, tableView, backButton);
//        layout.setAlignment(Pos.CENTER);
//        layout.setPadding(new Insets(20));
//        layout.setSpacing(20);
//
//        Scene scene = new Scene(layout, 600, 400);
//        stage.setScene(scene);
//        stage.setTitle("Employee Payroll System");
//        stage.show();
//
//
//    }
//
//    public void addEmployee(Stage stage) throws IOException {
//        Label nameLabel = new Label("Employee Name:");
//        TextField nameField = new TextField();
//
//        Label idLabel = new Label("Employee ID:");
//        TextField idField = new TextField();
//
//        Label departmentLabel = new Label("Department:");
//        ComboBox<String> departmentBox = new ComboBox<>(FXCollections.observableArrayList("IT", "HR", "Sales", "Finance", "Operations"));
//
//        Label baseSalaryLabel = new Label("Base Salary:");
//        TextField baseSalaryField = new TextField();
//
//        Label hoursWorkedLabel = new Label("Hours Worked:");
//        TextField hoursWorkedField = new TextField();
//
//        Label ratingLabel = new Label("Performance Rating:");
//        ComboBox<String> ratingBox = new ComboBox<>(FXCollections.observableArrayList("Excellent", "Good", "Average", "Poor"));
//
//        Label gender = new Label("Gender:");
//        RadioButton male = new RadioButton("Male");
//        RadioButton female = new RadioButton("Female");
//        ToggleGroup group = new ToggleGroup();
//        male.setToggleGroup(group);
//        female.setToggleGroup(group);
//
//        VBox genderBox = new VBox(male, female);
//
//        Label age = new Label("Age:");
//        DatePicker dob = new DatePicker();
//
//        Button saveButton = new Button("Save");
//        Button resetButton = new Button("Reset");
//        Button backButton = new Button("Back");
//
//
//
//        GridPane form = new GridPane();
//        form.setHgap(10);
//        form.setVgap(10);
//        form.setPadding(new Insets(20));
//
//        form.add(nameLabel, 0, 0);
//        form.add(nameField, 1, 0);
//        form.add(idLabel, 0, 1);
//        form.add(idField, 1, 1);
//        form.add(age,0,2);
//        form.add(dob,1,2);
//        form.add(gender,0,3);
//        form.add(genderBox, 1, 3);
//
//        form.add(departmentLabel, 0, 4);
//        form.add(departmentBox, 1, 4);
//        form.add(baseSalaryLabel, 0, 5);
//        form.add(baseSalaryField, 1, 5);
//        form.add(hoursWorkedLabel, 0, 6);
//        form.add(hoursWorkedField, 1, 6);
//        form.add(ratingLabel, 0, 7);
//        form.add(ratingBox, 1, 7);
//        form.add(saveButton, 0, 9);
//        form.add(resetButton, 1, 9);
//        form.add(backButton, 0, 11);
//
//        Scene formScene = new Scene(form, 600, 400);
//        stage.setScene(formScene);
//        stage.setTitle("Employee Payroll System");
//        stage.show();
//
//
//        saveButton.setOnAction(e -> {
//            String name = nameField.getText();
//            int id = Integer.parseInt(idField.getText());
//            String department = departmentBox.getValue();
//            double baseSalary = Double.parseDouble(baseSalaryField.getText());
//            int hoursWorked = Integer.parseInt(hoursWorkedField.getText());
//            String rating = ratingBox.getValue();
//            String Age = (String.valueOf(dob.getValue()));
//            String Gender = ((RadioButton)group.getSelectedToggle()).getText();
//            double TotalSalary = baseSalary;
//
//            Employee employee = new Employee(id,name,Age,Gender,department,baseSalary,hoursWorked,rating,TotalSalary);
//            employees.add(employee);
//            saveToFile();
//
//
//        });
//
//
//        backButton.setOnAction(e -> {
//            try {
//                start(stage);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//    }
//
//    private void saveToFile(){
//try{
//FileOutputStream data1 = new FileOutputStream(fileName);
//    ObjectOutputStream data = new ObjectOutputStream(data1);
//
//    data.writeObject(new ArrayList<>(employees));
//
//}catch (Exception e){
//    throw new RuntimeException(e);
//}
//    }
//
//    private void loadFromFile(){
//
//        if(file.exists()){
//            try{
//                FileInputStream data2 = new FileInputStream(fileName);
//                ObjectInputStream data = new ObjectInputStream(data2);
//                List<Employee> loadedData = (ArrayList<Employee>) data.readObject();
//                employees.clear();
//                employees.addAll(loadedData);
//
//            }catch (Exception e){
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
//}

package com.example.employeesalarymanagement;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {

    private ObservableList<Employee> employees = FXCollections.observableArrayList();
    private final String fileName = "employees.txt";

    @Override
    public void start(Stage stage) throws IOException {
        // Main Menu Buttons
        Button addEmployeeButton = new Button("Add Employee");
        Button viewPayrollButton = new Button("View Payroll Records");
        Button exitButton = new Button("Exit");

        VBox mainMenu = new VBox(20, addEmployeeButton, viewPayrollButton, exitButton);
        mainMenu.setAlignment(Pos.CENTER);
        mainMenu.setPadding(new Insets(20));

        Scene mainScene = new Scene(mainMenu, 600, 400);
        stage.setScene(mainScene);
        stage.setTitle("Employee Payroll System");
        stage.show();

        // Button Actions
        addEmployeeButton.setOnAction(e -> addEmployee(stage, mainScene));
        viewPayrollButton.setOnAction(e -> tableView(stage, mainScene));
        exitButton.setOnAction(e -> System.exit(0));
    }

    private void tableView(Stage stage, Scene mainScene) {
        loadFromFile();

        TableView<Employee> tableView = new TableView<>();
        tableView.setItems(employees);

        // Table Columns
        TableColumn<Employee, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Employee, String> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Employee, String> ageCol = new TableColumn<>("Age");
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Employee, String> genderCol = new TableColumn<>("Gender");
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));

        TableColumn<Employee, String> departmentCol = new TableColumn<>("Department");
        departmentCol.setCellValueFactory(new PropertyValueFactory<>("department"));

        TableColumn<Employee, String> baseSalaryCol = new TableColumn<>("Base Salary");
        baseSalaryCol.setCellValueFactory(new PropertyValueFactory<>("baseSalary"));

        TableColumn<Employee, String> hoursWorkedCol = new TableColumn<>("Hours Worked");
        hoursWorkedCol.setCellValueFactory(new PropertyValueFactory<>("hoursWorked"));

        TableColumn<Employee, String> ratingCol = new TableColumn<>("Performance Rating");
        ratingCol.setCellValueFactory(new PropertyValueFactory<>("performanceRating"));

        TableColumn<Employee, Double> totalSalaryCol = new TableColumn<>("Total Salary");
        totalSalaryCol.setCellValueFactory(new PropertyValueFactory<>("totalSalary"));

        tableView.getColumns().addAll(nameCol, idCol, ageCol, genderCol, departmentCol, baseSalaryCol, hoursWorkedCol, ratingCol, totalSalaryCol);

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> stage.setScene(mainScene));

        VBox layout = new VBox(20, tableView, backButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene tableScene = new Scene(layout, 800, 600);
        stage.setScene(tableScene);
    }

    private void addEmployee(Stage stage, Scene mainScene) {
        // Form Labels and Inputs
        Label nameLabel = new Label("Employee Name:");
        TextField nameField = new TextField();

        Label idLabel = new Label("Employee ID:");
        TextField idField = new TextField();

        Label ageLabel = new Label("Age:");
        DatePicker dob = new DatePicker();

        Label genderLabel = new Label("Gender:");
        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");
        ToggleGroup genderGroup = new ToggleGroup();
        male.setToggleGroup(genderGroup);
        female.setToggleGroup(genderGroup);

        Label departmentLabel = new Label("Department:");
        ComboBox<String> departmentBox = new ComboBox<>(FXCollections.observableArrayList("IT", "HR", "Sales", "Finance", "Operations"));

        Label baseSalaryLabel = new Label("Base Salary:");
        TextField baseSalaryField = new TextField();

        Label hoursWorkedLabel = new Label("Hours Worked:");
        TextField hoursWorkedField = new TextField();

        Label ratingLabel = new Label("Performance Rating:");
        ComboBox<String> ratingBox = new ComboBox<>(FXCollections.observableArrayList("Excellent", "Good", "Average", "Poor"));

        Button saveButton = new Button("Save");
        Button backButton = new Button("Back");

        // Form Layout
        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.setPadding(new Insets(20));

        form.add(nameLabel, 0, 0);
        form.add(nameField, 1, 0);
        form.add(idLabel, 0, 1);
        form.add(idField, 1, 1);
        form.add(ageLabel, 0, 2);
        form.add(dob, 1, 2);
        form.add(genderLabel, 0, 3);
        form.add(male, 1, 3);
        form.add(female, 1, 4);
        form.add(departmentLabel, 0, 5);
        form.add(departmentBox, 1, 5);
        form.add(baseSalaryLabel, 0, 6);
        form.add(baseSalaryField, 1, 6);
        form.add(hoursWorkedLabel, 0, 7);
        form.add(hoursWorkedField, 1, 7);
        form.add(ratingLabel, 0, 8);
        form.add(ratingBox, 1, 8);
        form.add(saveButton, 0, 9);
        form.add(backButton, 1, 9);

        Scene formScene = new Scene(form, 600, 400);
        stage.setScene(formScene);

        saveButton.setOnAction(e -> {
            try {
                String name = nameField.getText();
                int id = Integer.parseInt(idField.getText());
                String age = (dob.getValue() != null) ? dob.getValue().toString() : "Unknown";
                String gender = (genderGroup.getSelectedToggle() != null) ? ((RadioButton) genderGroup.getSelectedToggle()).getText() : "Unknown";
                String department = (departmentBox.getValue() != null) ? departmentBox.getValue() : "Unknown";
                double baseSalary = Double.parseDouble(baseSalaryField.getText());
                int hoursWorked = Integer.parseInt(hoursWorkedField.getText());
                String rating = (ratingBox.getValue() != null) ? ratingBox.getValue() : "Unknown";
                double totalSalary = baseSalary;

                Employee employee = new Employee(id, name, age, gender, department, baseSalary, hoursWorked, rating, totalSalary);
                employees.add(employee);
                saveToFile();
                showAlert("Success", "Employee added successfully!");
            } catch (Exception ex) {
                showAlert("Error", "Invalid input. Please check your data.");
            }
        });

        backButton.setOnAction(e -> stage.setScene(mainScene));
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(new ArrayList<>(employees));
        } catch (IOException e) {
            showAlert("File Error", "Failed to save employee data.");
        }
    }

    private void loadFromFile() {
        File file = new File(fileName);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                List<Employee> loadedData = (ArrayList<Employee>) ois.readObject();
                employees.clear();
                employees.addAll(loadedData);
            } catch (IOException | ClassNotFoundException e) {
                showAlert("File Error", "Failed to load employee data.");
            }
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}
