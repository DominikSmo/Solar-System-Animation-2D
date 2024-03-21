package com.example.solar;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("solar.fxml"));
        Parent root = fxmlLoader.load();
        HelloController helloController = fxmlLoader.getController();
        helloController.setHelloController(helloController);
        Scene scene = new Scene(root, 1200, 600);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        helloController.setScene(scene, stage);
        helloController.zoomButton();

        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}