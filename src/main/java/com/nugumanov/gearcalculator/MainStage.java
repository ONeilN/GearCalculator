package com.nugumanov.gearcalculator;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainStage extends Application {

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Gear Calculator");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
