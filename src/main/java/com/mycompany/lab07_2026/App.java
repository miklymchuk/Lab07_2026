package com.mycompany.lab07_2026;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        // Shapes 
        var rectangle = new Rectangle(560, 400);
        rectangle.setFill(null);
        rectangle.setStroke(Color.BLACK);
        rectangle.setX(40);
        rectangle.setY(40);
        var circle = new Circle(40, 40, 25, Color.BLUE);
        
        var pt = new PathTransition(Duration.millis(6000), rectangle, circle);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setRate(-1);
        pt.play();
        
        var scene = new Scene(new Pane(rectangle, circle), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}