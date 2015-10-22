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

    RegularPolygon(int n, double[] cp, int r) {
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
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(screenwidth, screenheight);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //drawRegularPolygonFractal(gc, Color.BLACK, 1, new double[]{screenwidth / 2 , screenheight / 2}, screenwidth / 3, 6, 3);
        RegularPolygon square = new RegularPolygon(4, new double[]{screenwidth / 2, screenheight / 2}, screenwidth / 4);
        drawRegularPolygon(gc, square, Color.BLACK, 10);
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

    private void drawRegularPolygonFractal(GraphicsContext gc, RegularPolygon polygon, Color color, int lineWidth, int iterations) {
        int currentIteration = iterations--;
        gc.setStroke(color);
        gc.setLineWidth(lineWidth);
        gc.strokePolygon(polygon.coords_x, polygon.coords_y, polygon.numberOfSides);
        for(int i = 0; i < polygon.numberOfSides; i++){
            
        }
    }
//    private void drawEquilateralTriangle(GraphicsContext gc, double[] centerpoint, double side) {
//               double x=side/2;
//               double height = Math.sqrt(3) * x;
//               gc.setStroke(Color.LIGHTCORAL);
//               gc.setLineWidth(5);
//               gc.strokePolygon(new double[]{centerpoint[0], centerpoint[0] - x, centerpoint[0] + x},
//                       new double[]{(centerpoint[1] - (0.5*height)), (centerpoint[1] + (0.5*height)), (centerpoint[1] + (0.5*height))}, 3);
//    }
//    private void drawSquare(GraphicsContext gc, double[] centerpoint, double side) {
//               double x=side/2;
//               gc.setStroke(Color.BROWN);
//               gc.setLineWidth(5);
//               gc.strokePolygon(new double[]{centerpoint[0] - x, centerpoint[0] + x, centerpoint[0] + x, centerpoint[0] - x},
//                       new double[]{centerpoint[1] + x, centerpoint[1] + x, centerpoint[1] - x, centerpoint[1] - x}, 4);
//    }
//    
//    private void drawCircle(GraphicsContext gc, double[] centerpoint, double diameter, Color color){
//        gc.setLineWidth(5);
//        gc.setStroke(color);
//        gc.strokeOval(centerpoint[0], centerpoint[1], diameter, diameter);
//       
//    }
//    private void drawTrinity(GraphicsContext gc, double[] centerpoint, double size){
//        double x = size / 2;
//         double apothem = 0.5 * x * Math.sqrt(3);
//        double[] coords_x = {centerpoint[0] - x, centerpoint[0], centerpoint[0] + x};
//        double[] coords_y = {centerpoint[1] + apothem, centerpoint[1] - apothem, centerpoint[1] + apothem};
//       for(int i =0; i < coords_x.length; i++){
//          // gc.strokeOval(coords_x[i] - (size), coords_y[i] - (size), size * 2, size * 2);
//           drawCircle(gc, new double[]{coords_x[i] - (size), coords_y[i] - (size)}, size * 2, Color.GOLDENROD);
//       }

//       private void drawRegularPolygon(GraphicsContext gc, Color color, int lineWidth, double[] centerpoint, double radius, int numberOfSides) {
//        double y; //initialize temporary
//        double x; // values for coordinate storage
//        double[] x_coords = new double[numberOfSides]; //array to store x-coordinate of each point
//        double[] y_coords = new double[numberOfSides]; //array to store y-coordinate of each point
//        double interior_angle = 360 / numberOfSides;
//        //adds a point every interior_angle degrees around the unit circle
//        for (int i = 0; i < numberOfSides; i++) {
//            //Centers polygon onto centerpoint and scales apropriately
//            x = centerpoint[0] + (radius * Math.cos(Math.toRadians(interior_angle * (i + 1))));
//            y = centerpoint[1] + (radius * Math.sin(Math.toRadians(interior_angle * (i + 1))));
//            System.out.println("(" + x + ", " + y + ")");
//            x_coords[i] = x; //populates the arrays with the correct coordinate pair
//            y_coords[i] = y;
//        }
//        gc.setStroke(color);  //Draw the polygon
//        gc.setLineWidth(lineWidth);
//        gc.strokePolygon(x_coords, y_coords, numberOfSides);
//    }
//
//    private void drawRegularPolygonWithLines(GraphicsContext gc, Color color, int lineWidth, double[] centerpoint, double radius, int numberOfSides) {
//        double y; //initialize temporary
//        double x; // values for coordinate storage
//        double[] x_coords = new double[numberOfSides]; //array to store x-coordinate of each point
//        double[] y_coords = new double[numberOfSides]; //array to store y-coordinate of each point
//        double interior_angle = 360 / numberOfSides;
//        //adds a point every interior_angle degrees around the unit circle
//        for (int i = 0; i < numberOfSides; i++) {
//            //Centers polygon onto centerpoint and scales apropriately
//            x = centerpoint[0] + (radius * Math.cos(Math.toRadians(interior_angle * (i + 1))));
//            y = centerpoint[1] + (radius * Math.sin(Math.toRadians(interior_angle * (i + 1))));
//            System.out.println("(" + x + ", " + y + ")");
//            x_coords[i] = x; //populates the arrays with the correct coordinate pair
//            y_coords[i] = y;
//        }
//        gc.setStroke(color);  //Draw the polygon
//        gc.setLineWidth(lineWidth);
//        for (int i = 0; i < numberOfSides; i++) {
//            for (int i2 = 0; i2 < numberOfSides; i2++) {
//                gc.strokeLine(x_coords[i], y_coords[i], x_coords[i2], y_coords[i2]);
//            }
//        }
//    }
//
//    private void drawCircle(GraphicsContext gc, Color color, int lineWidth, double[] centerpoint, double radius) {
//        double center_x = centerpoint[0] - radius; //adjust centerpoint because
//        double center_y = centerpoint[1] - radius; // JavaFX draws circle from top left
//        gc.setStroke(color);  //Draw the circle
//        gc.setLineWidth(lineWidth);
//        gc.strokeOval(center_x, center_y, radius * 2, radius * 2);
//    }
//
//    private void drawPolygonInscribedInCircle(GraphicsContext gc, Color color, int lineWidth, double[] centerpoint, double radius, int numberOfSides) {
//        drawCircle(gc, color, lineWidth, centerpoint, radius);
//        drawRegularPolygon(gc, color, lineWidth, centerpoint, radius, numberOfSides);
//    }
//
//    private void drawRegularPolygonFractal(GraphicsContext gc, Color color, int lineWidth, double[] centerpoint, double radius, int numberOfSides, int max) {
//        if (max == 0) {
//            return;
//        }
//        else{
//            max--;
//        }
//        double y; //initialize temporary
//        double x; // values for coordinate storage
//        double[] x_coords = new double[numberOfSides]; //array to store x-coordinate of each point
//        double[] y_coords = new double[numberOfSides]; //array to store y-coordinate of each point
//        double interior_angle = 360 / numberOfSides;
//        //adds a point every interior_angle degrees around the unit circle
//        for (int i = 0; i < numberOfSides; i++) {
//            //Centers polygon onto centerpoint and scales apropriately
//            x = centerpoint[0] + (radius * Math.cos(Math.toRadians(interior_angle * (i + 1))));
//            y = centerpoint[1] + (radius * Math.sin(Math.toRadians(interior_angle * (i + 1))));
//            System.out.println("(" + x + ", " + y + ")");
//            x_coords[i] = x; //populates the arrays with the correct coordinate pair
//            y_coords[i] = y;
//        }
//        gc.setStroke(color);  //Draw the polygon
//        gc.setLineWidth(lineWidth);
//        gc.strokePolygon(x_coords, y_coords, numberOfSides);
//        for (int i = 0; i < numberOfSides; i++) {
//
//            drawRegularPolygonFractal(gc, color, lineWidth, new double[]{x_coords[i], y_coords[i]}, radius / 2, numberOfSides, max);
//        }
//    }
}
//    private void drawShapes(GraphicsContext gc) {
//        gc.setFill(Color.GREEN);
//        gc.setFill(Color.GREEN);
//        gc.setStroke(Color.BLUE);
//        gc.setLineWidth(5);
//        gc.strokeLine(40, 10, 10, 40);
//        gc.fillOval(10, 60, 30, 30);
//        gc.strokeOval(60, 60, 30, 30);
//        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
//        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
//        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
//        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
//        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
//        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
//        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
//        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
//        gc.fillPolygon(new double[]{10, 40, 10, 40},
//                       new double[]{210, 210, 240, 240}, 4);
//        gc.strokePolygon(new double[]{60, 90, 60, 90},
//                         new double[]{210, 210, 240, 240}, 4);
//        gc.strokePolyline(new double[]{110, 140, 110, 140},
//                          new double[]{210, 210, 240, 240}, 4);
//    }
