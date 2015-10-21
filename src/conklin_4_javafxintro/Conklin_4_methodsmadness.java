/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conklin_4_javafxintro;

/**
 *
 * @author jconklin2391
 */
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

class RegularPolygon {

    int numberOfSides;
    double interiorAngle;
    double[] coords_x;
    double[] coords_y;
    double[] centerpoint;
    double radius;
    double sideLength;

    RegularPolygon(int n, double[] cp, double r) {
        numberOfSides = n;
        centerpoint = cp;
        radius = r;
        interiorAngle = 360 / numberOfSides;
        coords_x = new double[numberOfSides]; //array to store x-coordinate of each point
        coords_y = new double[numberOfSides]; //array to store y-coordinate of each point
        setCoords();
    }

    void setCoords() {
        double x; // values for coordinate storage
        double y;
        for (int i = 0; i < numberOfSides; i++) {
            //Centers polygon onto centerpoint and scales apropriately
            x = centerpoint[0] + (radius * Math.cos(Math.toRadians(interiorAngle * (i + 1))));
            y = centerpoint[1] + (radius * Math.sin(Math.toRadians(interiorAngle * (i + 1))));
            coords_x[i] = x; //populates the arrays with the correct coordinate pair
            coords_y[i] = y;
        }
    }

}

public class Conklin_4_methodsmadness extends Application {

    int screenwidth = 300;
    int screenheight = 300;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Method Madness");
        Group root = new Group();
        Canvas canvas = new Canvas(screenwidth, screenheight);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        RegularPolygon square = new RegularPolygon(4, new double[]{screenwidth / 2, screenheight / 2}, 50);
        RegularPolygon hexagon = new RegularPolygon(6, new double[]{screenwidth / 8, screenheight / 8}, 30);
        RegularPolygon triangle = new RegularPolygon(3, new double[]{screenwidth / 3, screenheight / 8}, 30);
        RegularPolygon pentagon = new RegularPolygon(5, new double[]{screenwidth - screenwidth / 8, screenheight / 8}, 30);
        RegularPolygon septagon = new RegularPolygon(7, new double[]{screenwidth /4, screenheight - screenheight / 8}, 30);
        drawRegularPolygonFractal(gc, square, Color.BLACK, 1, 4);
        drawRegularPolygon(gc, hexagon, Color.ORANGE, 5);
        drawRegularPolygon(gc, triangle, Color.DODGERBLUE, 5);
        drawCircle(gc, Color.TOMATO, 10, new double[]{190, screenheight / 8}, 60);
        drawPolygonInscribed(gc, pentagon, Color.DARKSLATEGRAY, 2);
        drawPolygonStar(gc, septagon, Color.BLACK, 1);
        //drawRegularPolygon(gc, square, Color.BLACK, 10);
        //drawRegularPolygonWithLines(gc, Color.BLACK, 1, new double[]{screenwidth / 2 , screenheight / 2}, screenwidth / 2, 8);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void drawRegularPolygon(GraphicsContext gc, RegularPolygon polygon, Color color, int lineWidth) {
        gc.setStroke(color);
        gc.setLineWidth(lineWidth);
        gc.strokePolygon(polygon.coords_x, polygon.coords_y, polygon.numberOfSides);
    }
    
    private void drawPolygonInscribed(GraphicsContext gc, RegularPolygon polygon, Color color, int lineWidth) {
            drawRegularPolygon(gc, polygon, color, lineWidth);
            drawCircle(gc, color, lineWidth, polygon.centerpoint, polygon.radius * 2);
    }
private void drawPolygonCrissCross(GraphicsContext gc, RegularPolygon polygon, Color color, int lineWidth) {
            drawRegularPolygon(gc, polygon, color, lineWidth);
            for(int i = 0; i < polygon.numberOfSides; i++){
                for(int a = 0; a < polygon.numberOfSides; a++){
                gc.strokeLine(polygon.coords_x[i], polygon.coords_y[i], polygon.coords_x[a], polygon.coords_y[a]);
            }
            }
            
    }
private void drawPolygonStar(GraphicsContext gc, RegularPolygon polygon, Color color, int lineWidth) {
            drawRegularPolygon(gc, polygon, color, lineWidth);
            for(int i = 0; i < polygon.numberOfSides; i++){
                for(int a = 0; a < polygon.numberOfSides; a++){
                                            gc.strokeLine(polygon.coords_x[i], polygon.coords_y[i], polygon.coords_x[a], polygon.coords_y[a]);
                    
                
            }
            }
            
    }
    private void drawRegularPolygonFractal(GraphicsContext gc, RegularPolygon polygon, Color color, int lineWidth, int iterations) {
        if (iterations == 0) {
            return;
        } else {
            iterations--;
        }
        double[] x = polygon.coords_x;
        double[] y = polygon.coords_y;
        drawRegularPolygon(gc, polygon, color, lineWidth);
        for (int i = 0; i < polygon.numberOfSides; i++) {
            RegularPolygon fractalpoly = new RegularPolygon(polygon.numberOfSides, new double[]{x[i], y[i]}, polygon.radius / 2);
            drawRegularPolygonFractal(gc, fractalpoly, color, lineWidth, iterations);
        }
    }
        private void drawCircle(GraphicsContext gc, Color color, int lineWidth, double[] centerpoint, double diameter){
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokeOval(centerpoint[0] - (diameter / 2), centerpoint[1] - (diameter / 2), diameter, diameter);
       
    }
}
