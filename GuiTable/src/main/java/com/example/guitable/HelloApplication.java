////package com.example.guitable;
////
////import javafx.application.Application;
////import javafx.beans.value.ChangeListener;
////import javafx.beans.value.ObservableValue;
////import javafx.fxml.FXMLLoader;
////import javafx.geometry.Insets;
////import javafx.geometry.Pos;
////import javafx.scene.Scene;
////import javafx.scene.control.*;
////import javafx.scene.image.Image;
////import javafx.scene.image.ImageView;
////import javafx.scene.layout.Border;
////import javafx.scene.layout.GridPane;
////import javafx.scene.layout.HBox;
////import javafx.stage.FileChooser;
////import javafx.stage.Stage;
////
////
////import java.io.IOException;
////import java.time.LocalDate;
////
////public class HelloApplication extends Application {
////    @Override
////    public void start(Stage stage) throws IOException {
////        //  FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
////
////        GridPane gridPane = new GridPane();
////        //f://c:/
////        Image topBanner= new Image(this.getClass().getResource("download.jpg").toExternalForm());
////        ImageView imageView = new ImageView(topBanner);
////
////        DatePicker dob = new DatePicker();
////        Label dobLabel = new Label("DOB:");
////
////        HBox datePickerBox= new HBox();
////        datePickerBox.setPadding(new Insets(10));
////        dob.valueProperty().addListener(new ChangeListener<LocalDate>() {
////            @Override
////            public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) {
////                int age = LocalDate.now().getYear() - newValue.getYear();
////                if (newValue.getMonthValue() > LocalDate.now().getMonthValue()
////                        || (newValue.getMonthValue() == LocalDate.now().getMonthValue()
////                        && newValue.getDayOfMonth() > LocalDate.now().getDayOfMonth())) {
////                    age--;
////                }
////                // System.out.println();
////                dobLabel.setText("Age: " + age);
////            }
////        });
////
////        RadioButton maleRadioButton = new RadioButton("Male");
////        RadioButton femaleRadioButton = new RadioButton("Female");
////        HBox genderBox = new HBox();
////        genderBox.setPadding(new Insets(10));
////        genderBox.setAlignment(Pos.CENTER);
////        genderBox.setSpacing(20);
////        // genderBox.setBorder(new Border(null,null,null,null,null));
////        genderBox.setStyle("-fx-border-color: #4682B4; -fx-border-width: 2px; -fx-border-radius: 5px;");
////
////        ToggleGroup genderToggleGroup = new ToggleGroup();
////        maleRadioButton.setToggleGroup(genderToggleGroup);
////        femaleRadioButton.setToggleGroup(genderToggleGroup);
////        genderBox.getChildren().addAll(maleRadioButton, femaleRadioButton);
////
////        Slider weightSlider = new Slider();
////        weightSlider.setMin(40);
////        weightSlider.setMax(200);
////        weightSlider.setMajorTickUnit(20);
////        weightSlider.setMinorTickCount(5);
////        weightSlider.setSnapToTicks(true);
////        weightSlider.setShowTickLabels(true);
////        weightSlider.setShowTickMarks(true);
////        Label weightValueLabel = new Label(String.valueOf((int) weightSlider.getValue()));
////
////        FileChooser fileChooser = new FileChooser();
////
////        HBox hightHBox= new HBox();
////        hightHBox.getChildren().addAll(weightSlider,weightValueLabel);
////        hightHBox.setStyle("-fx-border-color: #4682B4; -fx-border-width: 2px; -fx-border-radius: 5px;");
////
////        Slider heightSlider =new Slider();
////        heightSlider.setShowTickLabels(true);
////        heightSlider.setMinorTickCount(5);
////        heightSlider.setMajorTickUnit(10);
////        heightSlider.setSnapToTicks(true);
////        heightSlider.setShowTickMarks(true);
////        Label heightValueLabel = new Label(String.valueOf((int)heightSlider.getValue()));
////
////        heightSlider.valueProperty().addListener(new ChangeListener<Number>() {
////            @Override
////            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
////                heightValueLabel.setText(String.valueOf(newValue.intValue()));
////
////            }
////        });
////
////
////
////
////        HBox heightHBox = new HBox();
////        heightHBox.getChildren().addAll(heightSlider, heightValueLabel);
////        Button calculateBMI=new Button("BMI");
////        calculateBMI.setOnAction(e -> {
////            double weight = weightSlider.getValue();
////            double height = heightSlider.getValue();
////            double bmi = weight / Math.pow(height, 2);
////            Label bmiValueLabel = new Label("BMI: " + String.format("%.2f", bmi));
////            gridPane.add(bmiValueLabel, 0, 7);
////        });
////
////        datePickerBox.getChildren().addAll( dob,dobLabel);
////
////
////        gridPane.add(imageView, 0, 0, 1, 1);
////        gridPane.add(datePickerBox, 0, 1, 1, 1);
////        gridPane.add(genderBox, 0, 2, 1, 1);
////        gridPane.add(hightHBox, 0, 4);
////        gridPane.add(heightHBox, 0, 5);
////        gridPane.add(calculateBMI, 0, 6);
////
////
////        gridPane.add(weightSlider, 0,3);
////        Scene scene = new Scene(gridPane, 700, 500);
////        stage.setTitle("Hello!");
////        stage.setScene(scene);
////        //stage.setScene(createSecondScreen());
////        stage.show();
////    }
////
////    public static void main(String[] args) {
////        launch();
////    }
////
////    public static Scene createSecondScreen(){
////        return new Scene(new GridPane(),500,600);
////    }
////}
//
//package com.example.guitable;
//
//import javafx.application.Application;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//import javafx.stage.Stage;
//
//import java.time.LocalDate;
//
//public class HelloApplication extends Application {
//    @Override
//    public void start(Stage stage) {
//        GridPane gridPane = new GridPane();
//
//        Image topBanner = new Image(getClass().getResource("/com/example/guitable/download.jpg").toExternalForm());
//
//        //Image topBanner = new Image(this.getClass().getResource("download.jpg").toExternalForm());
//        ImageView imageView = new ImageView(topBanner);
//
//        DatePicker dob = new DatePicker();
//        Label dobLabel = new Label("DOB:");
//
//        HBox datePickerBox = new HBox();
//        datePickerBox.setPadding(new Insets(10));
//        datePickerBox.setSpacing(10);
//
//        dob.valueProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue != null) {
//                int age = LocalDate.now().getYear() - newValue.getYear();
//                if (newValue.getMonthValue() > LocalDate.now().getMonthValue()
//                        || (newValue.getMonthValue() == LocalDate.now().getMonthValue()
//                        && newValue.getDayOfMonth() > LocalDate.now().getDayOfMonth())) {
//                    age--;
//                }
//                dobLabel.setText("Age: " + age);
//            } else {
//                dobLabel.setText("DOB:");
//            }
//        });
//
//        RadioButton maleRadioButton = new RadioButton("Male");
//        RadioButton femaleRadioButton = new RadioButton("Female");
//        HBox genderBox = new HBox(20, maleRadioButton, femaleRadioButton);
//        genderBox.setPadding(new Insets(10));
//        genderBox.setAlignment(Pos.CENTER);
//        genderBox.setStyle("-fx-border-color: #4682B4; -fx-border-width: 2px; -fx-border-radius: 5px;");
//
//        ToggleGroup genderToggleGroup = new ToggleGroup();
//        maleRadioButton.setToggleGroup(genderToggleGroup);
//        femaleRadioButton.setToggleGroup(genderToggleGroup);
//
//        Slider weightSlider = new Slider(40, 200, 70);
//        weightSlider.setMajorTickUnit(20);
//        weightSlider.setMinorTickCount(5);
//        weightSlider.setSnapToTicks(true);
//        weightSlider.setShowTickLabels(true);
//        weightSlider.setShowTickMarks(true);
//        Label weightValueLabel = new Label(String.valueOf((int) weightSlider.getValue()));
//
//        weightSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
//            weightValueLabel.setText(String.valueOf(newValue.intValue()));
//        });
//
//        HBox weightBox = new HBox(10, weightSlider, weightValueLabel);
//
//        Slider heightSlider = new Slider(100, 250, 170);
//        heightSlider.setMajorTickUnit(10);
//        heightSlider.setMinorTickCount(5);
//        heightSlider.setSnapToTicks(true);
//        heightSlider.setShowTickLabels(true);
//        heightSlider.setShowTickMarks(true);
//        Label heightValueLabel = new Label(String.valueOf((int) heightSlider.getValue()));
//
//        heightSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
//            heightValueLabel.setText(String.valueOf(newValue.intValue()));
//        });
//
//        HBox heightBox = new HBox(10, heightSlider, heightValueLabel);
//
//        Label bmiValueLabel = new Label();
//        Button calculateBMI = new Button("Calculate BMI");
//        calculateBMI.setOnAction(e -> {
//            double weight = weightSlider.getValue();
//            double height = heightSlider.getValue() / 100; // Convert to meters
//            double bmi = weight / (height * height);
//            bmiValueLabel.setText("BMI: " + String.format("%.2f", bmi));
//        });
//
//        gridPane.setPadding(new Insets(10));
//        gridPane.setVgap(10);
//        gridPane.setHgap(10);
//        gridPane.add(imageView, 0, 0);
//        gridPane.add(datePickerBox, 0, 1);
//        gridPane.add(genderBox, 0, 2);
//        gridPane.add(weightBox, 0, 3);
//        gridPane.add(heightBox, 0, 4);
//        gridPane.add(calculateBMI, 0, 5);
//        gridPane.add(bmiValueLabel, 0, 6);
//
//        Scene scene = new Scene(gridPane, 700, 500);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
//}

package com.example.guitable;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        try {
            // Create the root layout
            GridPane gridPane = new GridPane();
            gridPane.setPadding(new Insets(10));
            gridPane.setVgap(10);
            gridPane.setHgap(10);

            // Load the image
            Image topBanner = null;
            try {
                topBanner = new Image(getClass().getResource("C:\\Users\\lenovo\\OneDrive\\Documents\\OOP\\Assignments\\GuiTable\\src\\main\\resources\\download.jpg").toExternalForm());
            } catch (NullPointerException e) {
                System.out.println("Image not found: " + e.getMessage());
            }

            ImageView imageView = new ImageView(topBanner);
            if (topBanner == null) {
                Label imageErrorLabel = new Label("Image not found.");
                gridPane.add(imageErrorLabel, 0, 0);
            } else {
                gridPane.add(imageView, 0, 0);
            }

            // DatePicker for DOB
            DatePicker dob = new DatePicker();
            Label dobLabel = new Label("DOB:");
            HBox datePickerBox = new HBox(10, dob, dobLabel);
            datePickerBox.setPadding(new Insets(10));

            dob.valueProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    int age = LocalDate.now().getYear() - newValue.getYear();
                    if (newValue.getMonthValue() > LocalDate.now().getMonthValue()
                            || (newValue.getMonthValue() == LocalDate.now().getMonthValue()
                            && newValue.getDayOfMonth() > LocalDate.now().getDayOfMonth())) {
                        age--;
                    }
                    dobLabel.setText("Age: " + age);
                } else {
                    dobLabel.setText("DOB:");
                }
            });

            // Gender selection
            RadioButton maleRadioButton = new RadioButton("Male");
            RadioButton femaleRadioButton = new RadioButton("Female");
            ToggleGroup genderToggleGroup = new ToggleGroup();
            maleRadioButton.setToggleGroup(genderToggleGroup);
            femaleRadioButton.setToggleGroup(genderToggleGroup);

            HBox genderBox = new HBox(20, maleRadioButton, femaleRadioButton);
            genderBox.setPadding(new Insets(10));
            genderBox.setAlignment(Pos.CENTER);
            genderBox.setStyle("-fx-border-color: #4682B4; -fx-border-width: 2px; -fx-border-radius: 5px;");

            // Weight slider
            Slider weightSlider = new Slider(40, 200, 70);
            weightSlider.setMajorTickUnit(20);
            weightSlider.setMinorTickCount(5);
            weightSlider.setSnapToTicks(true);
            weightSlider.setShowTickLabels(true);
            weightSlider.setShowTickMarks(true);
            Label weightValueLabel = new Label(String.valueOf((int) weightSlider.getValue()));

            weightSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
                weightValueLabel.setText(String.valueOf(newValue.intValue()));
            });

            HBox weightBox = new HBox(10, weightSlider, weightValueLabel);

            // Height slider
            Slider heightSlider = new Slider(100, 250, 170);
            heightSlider.setMajorTickUnit(10);
            heightSlider.setMinorTickCount(5);
            heightSlider.setSnapToTicks(true);
            heightSlider.setShowTickLabels(true);
            heightSlider.setShowTickMarks(true);
            Label heightValueLabel = new Label(String.valueOf((int) heightSlider.getValue()));

            heightSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
                heightValueLabel.setText(String.valueOf(newValue.intValue()));
            });

            HBox heightBox = new HBox(10, heightSlider, heightValueLabel);

            // BMI calculation
            Label bmiValueLabel = new Label();
            Button calculateBMI = new Button("Calculate BMI");
            calculateBMI.setOnAction(e -> {
                double weight = weightSlider.getValue();
                double height = heightSlider.getValue() / 100; // Convert to meters
                if (height > 0) {
                    double bmi = weight / (height * height);
                    bmiValueLabel.setText("BMI: " + String.format("%.2f", bmi));
                } else {
                    bmiValueLabel.setText("Invalid height!");
                }
            });

            // Add components to the grid
            gridPane.add(datePickerBox, 0, 1);
            gridPane.add(genderBox, 0, 2);
            gridPane.add(weightBox, 0, 3);
            gridPane.add(heightBox, 0, 4);
            gridPane.add(calculateBMI, 0, 5);
            gridPane.add(bmiValueLabel, 0, 6);

            // Set up the scene
            Scene scene = new Scene(gridPane, 700, 500);
            stage.setTitle("BMI Calculator");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
