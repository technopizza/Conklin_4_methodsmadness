/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.util.Calendar;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

/**
 *
 * @author Jason
 */
public class JavaFXApplication1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(500, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //drawTrinity(gc, new double[]{150, 150}, 50);
        drawRegularPolygonFractal(gc, Color.RED, 1, new double[]{250, 250}, 250, 4, 6);
        //drawPolygonInscribedInCircle(gc, Color.RED, 1, new double[]{150, 150}, 100, 4);
        //drawCircle(gc, Color.RED, 1, new double[]{150, 150}, 100);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    private void drawRegularPolygon(GraphicsContext gc, Color color, int lineWidth, double[] centerpoint, double radius, int numberOfSides) {
        double y; //initialize temporary
        double x; // values for coordinate storage
        double[] x_coords = new double[numberOfSides]; //array to store x-coordinate of each point
        double[] y_coords = new double[numberOfSides]; //array to store y-coordinate of each point
        double interior_angle = 360 / numberOfSides;
        //adds a point every interior_angle degrees around the unit circle
        for (int i = 0; i < numberOfSides; i++) {
            //Centers polygon onto centerpoint and scales apropriately
            x = centerpoint[0] + (radius * Math.cos(Math.toRadians(interior_angle * (i + 1))));
            y = centerpoint[1] + (radius * Math.sin(Math.toRadians(interior_angle * (i + 1))));
            System.out.println("(" + x + ", " + y + ")");
            x_coords[i] = x; //populates the arrays with the correct coordinate pair
            y_coords[i] = y;
        }
        gc.setStroke(color);  //Draw the polygon
        gc.setLineWidth(lineWidth);
        gc.strokePolygon(x_coords, y_coords, numberOfSides);
    }

    private void drawRegularPolygonWithLines(GraphicsContext gc, Color color, int lineWidth, double[] centerpoint, double radius, int numberOfSides) {
        double y; //initialize temporary
        double x; // values for coordinate storage
        double[] x_coords = new double[numberOfSides]; //array to store x-coordinate of each point
        double[] y_coords = new double[numberOfSides]; //array to store y-coordinate of each point
        double interior_angle = 360 / numberOfSides;
        //adds a point every interior_angle degrees around the unit circle
        for (int i = 0; i < numberOfSides; i++) {
            //Centers polygon onto centerpoint and scales apropriately
            x = centerpoint[0] + (radius * Math.cos(Math.toRadians(interior_angle * (i + 1))));
            y = centerpoint[1] + (radius * Math.sin(Math.toRadians(interior_angle * (i + 1))));
            System.out.println("(" + x + ", " + y + ")");
            x_coords[i] = x; //populates the arrays with the correct coordinate pair
            y_coords[i] = y;
        }
        gc.setStroke(color);  //Draw the polygon
        gc.setLineWidth(lineWidth);
        for (int i = 0; i < numberOfSides; i++) {
            for (int i2 = 0; i2 < numberOfSides; i2++) {
                gc.strokeLine(x_coords[i], y_coords[i], x_coords[i2], y_coords[i2]);
            }
        }
    }

    private void drawCircle(GraphicsContext gc, Color color, int lineWidth, double[] centerpoint, double radius) {
        double center_x = centerpoint[0] - radius; //adjust centerpoint because
        double center_y = centerpoint[1] - radius; // JavaFX draws circle from top left
        gc.setStroke(color);  //Draw the circle
        gc.setLineWidth(lineWidth);
        gc.strokeOval(center_x, center_y, radius * 2, radius * 2);
    }

    private void drawPolygonInscribedInCircle(GraphicsContext gc, Color color, int lineWidth, double[] centerpoint, double radius, int numberOfSides) {
        drawCircle(gc, color, lineWidth, centerpoint, radius);
        drawRegularPolygon(gc, color, lineWidth, centerpoint, radius, numberOfSides);
    }

    private void drawRegularPolygonFractal(GraphicsContext gc, Color color, int lineWidth, double[] centerpoint, double radius, int numberOfSides, int max) {
        if (max == 0) {
            return;
        }
        else{
            max--;
        }
        double y; //initialize temporary
        double x; // values for coordinate storage
        double[] x_coords = new double[numberOfSides]; //array to store x-coordinate of each point
        double[] y_coords = new double[numberOfSides]; //array to store y-coordinate of each point
        double interior_angle = 360 / numberOfSides;
        //adds a point every interior_angle degrees around the unit circle
        for (int i = 0; i < numberOfSides; i++) {
            //Centers polygon onto centerpoint and scales apropriately
            x = centerpoint[0] + (radius * Math.cos(Math.toRadians(interior_angle * (i + 1))));
            y = centerpoint[1] + (radius * Math.sin(Math.toRadians(interior_angle * (i + 1))));
            System.out.println("(" + x + ", " + y + ")");
            x_coords[i] = x; //populates the arrays with the correct coordinate pair
            y_coords[i] = y;
        }
        gc.setStroke(color);  //Draw the polygon
        gc.setLineWidth(lineWidth);
        gc.strokePolygon(x_coords, y_coords, numberOfSides);
        for (int i = 0; i < numberOfSides; i++) {

            drawRegularPolygonFractal(gc, color, lineWidth, new double[]{x_coords[i], y_coords[i]}, radius / 2, numberOfSides, max);
        }
    }
}

