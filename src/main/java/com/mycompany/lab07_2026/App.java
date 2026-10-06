package com.mycompany.lab07_2026;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
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
        var ellipse = new Ellipse(75, 50);
        ellipse.setFill(Color.RED); 
        ellipse.setCenterX(320);
        ellipse.setCenterY(240);
               
        // PathTransition for the circle & rectangle nodes
        PathTransition pt = new PathTransition(Duration.millis(6000), rectangle, circle);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setRate(-1);
        pt.play();
        
        // SequentialTransition with its base Transitions
        FadeTransition st1 = new FadeTransition(Duration.millis(2000), ellipse);
        st1.setFromValue(1.0);
        st1.setToValue(0.5);
        st1.setAutoReverse(true);
        
        ScaleTransition st2 = new ScaleTransition(Duration.millis(1100), ellipse);
        st2.setToX(1.5);
        st2.setToY(1.5);
        st2.setCycleCount(1);
        st2.setAutoReverse(true);
        
        RotateTransition st3 = new RotateTransition(Duration.millis(1400), ellipse);
        st3.setByAngle(90);
        
        TranslateTransition st4 = new TranslateTransition(Duration.millis(1500), ellipse);
        st4.setToX(150);
        
        SequentialTransition ellipseTransitions = new SequentialTransition(st1, st2, st3, st4);
        ellipseTransitions.play();
        
        var scene = new Scene(new Pane(rectangle, circle, ellipse), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}