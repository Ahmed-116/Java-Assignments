module com.example.employeesalarymanagement {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.employeesalarymanagement to javafx.fxml;
    exports com.example.employeesalarymanagement;
}