module com.example.guitable {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.guitable to javafx.fxml;
    exports com.example.guitable;
}