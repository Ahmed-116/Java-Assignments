package com.example.guitable;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        //backgroung image sett
        Image backgroundImage = new Image("pic 11.png");
        ImageView backgroundView = new ImageView(backgroundImage);
        backgroundView.setFitWidth(1550);
        backgroundView.setFitHeight(700);
        backgroundView.setPreserveRatio(false);
        primaryStage.setFullScreen(true);

        //welcome label added
        Label welcomeLabel = new Label("Welcome to ATDOOR");
        welcomeLabel.setFont(Font.font("Halvetica", FontWeight.BOLD, 52));          //can also change FontPostire:to ITALIC etc
        welcomeLabel.setTextFill(Color.web("#031b73"));
        welcomeLabel.setStyle("-fx-effect: dropshadow(gaussian, cornflowerblue, 5, 0.5, 2, 2);");
        welcomeLabel.setAlignment(Pos.CENTER);
        welcomeLabel.setStyle("-fx-font-weight: bold;");


        Button adminLoginButton = new Button("Admin Login");
        Button userLoginButton = new Button("User Login");
        adminLoginButton.setEffect(new DropShadow());
        userLoginButton.setEffect(new DropShadow());
        //implementing styling method
        styleButton(adminLoginButton);
        styleButton(userLoginButton);
        //adding the animations
        addButtonAnimation(adminLoginButton);
        addButtonAnimation(userLoginButton);
        //defining functionalities
        adminLoginButton.setOnAction(e -> {
            AdminLogin adminLogin = new AdminLogin(primaryStage);
            adminLogin.show();
        });
        userLoginButton.setOnAction(e -> {
            UserLoginOptions userLoginOptions = new UserLoginOptions(primaryStage);
            userLoginOptions.show();
        });

        VBox buttonLayout = new VBox(20);
        buttonLayout.getChildren().addAll(adminLoginButton, userLoginButton);
        buttonLayout.setAlignment(Pos.CENTER);

        VBox mainLayout = new VBox(30);
        mainLayout.getChildren().addAll(welcomeLabel, buttonLayout);
        mainLayout.setAlignment(Pos.TOP_CENTER);
        mainLayout.setPadding(new Insets(330, 0, 0, 0));
        //using staack pane bcz buttons are stacked over backgorund
        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundView, mainLayout);
        //adding everything to scene
        Scene scene = new Scene(root, 1550, 670);
        primaryStage.setTitle("E-Commerce System - Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //styling buttons method
    private void styleButton(Button button) {
        button.setFont(new Font("Didot", 18));
        button.setStyle("-fx-background-color: #263988; -fx-text-fill: white; -fx-padding: 10 20; "
                + "-fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: #031b73;-fx-border-width: 2;");
        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #263988; -fx-text-fill: white; "
                + "-fx-padding: 10 20; -fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: #031b73; -fx-border-width: 2;"));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #263988; -fx-text-fill: white; "
                + "-fx-padding: 10 20; -fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: #031b73; -fx-border-width: 2;"));
    }

    //buttons animations
    private void addButtonAnimation(Button button) {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), button);
        scaleTransition.setFromX(1.0);
        scaleTransition.setFromY(1.0);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        button.setOnMouseEntered(e -> scaleTransition.playFromStart());
        button.setOnMouseExited(e -> scaleTransition.stop());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
