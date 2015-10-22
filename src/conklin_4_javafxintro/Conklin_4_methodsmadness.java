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

    int screenwidth = 500;
    int screenheight = 500;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Method Madness");
        Group root = new Group();
        Canvas canvas = new Canvas(screenwidth, screenheight);
        GraphicsContext gc = canvas.getGraphicsContext2D();
//        RegularPolygon square = new RegularPolygon(4, new double[]{screenwidth / 2, screenheight / 2}, 60);
//        RegularPolygon hexagon = new RegularPolygon(6, new double[]{screenwidth / 8, screenheight / 8}, 30);
//        RegularPolygon triangle = new RegularPolygon(3, new double[]{screenwidth / 8, screenheight / 8}, 30);
//        RegularPolygon triangle2 = new RegularPolygon(3, new double[]{screenwidth / 4, screenheight * 7 / 8}, 13);
//        RegularPolygon pentagon = new RegularPolygon(5, new double[]{screenwidth / 1.5, screenheight / 8}, 30);
//        RegularPolygon septagon = new RegularPolygon(7, new double[]{screenwidth / 8, screenheight * 2 / 3}, 30);
//        RegularPolygon octagon = new RegularPolygon(8, new double[]{screenwidth / 4, screenheight * 7 / 8}, 13);
//        RegularPolygon nonagon = new RegularPolygon(9, new double[]{screenwidth / 2, screenheight / 2}, 50);
//        int num = screenwidth / 10;
//        RegularPolygon[] tesselation = new RegularPolygon[num];
//        tesselation[0] = new RegularPolygon(6, new double[]{0, num}, num);
//        drawRegularPolygon(gc, tesselation[0], Color.RED, 5);
//        for(int i = 1; i < num; i++){
//            tesselation[i] = new RegularPolygon(6, new double[]{tesselation[(i-1)].centerpoint[0] + (tesselation[(i-1)].radius * Math.cos(Math.toRadians(tesselation[i].interiorAngle))), tesselation[(i-1)].centerpoint[1] + (tesselation[(i-1)].radius * Math.cos(Math.toRadians(tesselation[i].interiorAngle)))}, num);
//            drawRegularPolygon(gc, tesselation[i], Color.RED, 5);
//        }
        RegularPolygon triangle = new RegularPolygon(3, new double[]{screenwidth / 10, screenheight / 10}, 25);
        RegularPolygon square = new RegularPolygon(4, new double[]{3 * screenwidth / 10, screenheight / 10}, 25);
        RegularPolygon pentagon = new RegularPolygon(5, new double[]{screenwidth / 2, screenheight / 10}, 25);
        RegularPolygon hexagon = new RegularPolygon(6, new double[]{7 *screenwidth / 10, screenheight / 10}, 25);
        RegularPolygon septagon = new RegularPolygon(7, new double[]{screenwidth / 10, screenheight / 4}, 25);
        RegularPolygon octagon = new RegularPolygon(8, new double[]{3 * screenwidth / 10, screenheight / 4}, 25);
        RegularPolygon nonagon = new RegularPolygon(9, new double[]{screenwidth / 2, screenheight / 4}, 25);
        RegularPolygon decagon = new RegularPolygon(10, new double[]{7 * screenwidth / 10, screenheight / 4}, 25);
        RegularPolygon squareF = new RegularPolygon(4, new double[]{screenwidth / 2, 4 * screenheight / 5}, 50);
        RegularPolygon septagonS = new RegularPolygon(7, new double[]{screenwidth / 10, screenheight / 2}, 50);
        drawRegularPolygonFractal(gc, squareF, Color.BLACK, 1, 4);
      drawRegularPolygon(gc, triangle, Color.RED, 5);
      drawRegularPolygon(gc, square, Color.GOLDENROD, 5);
      drawRegularPolygon(gc, pentagon, Color.BLUE, 5);
      drawRegularPolygon(gc, hexagon, Color.DARKSLATEBLUE, 5);
      drawRegularPolygon(gc, septagon, Color.MAGENTA, 5);
      drawRegularPolygon(gc, octagon, Color.OLIVEDRAB, 5);
      drawRegularPolygon(gc, nonagon, Color.TAN, 5);
      drawRegularPolygon(gc, decagon, Color.MAROON, 5);
      drawPolygonStar(gc, septagonS, Color.GREEN, 2);
//     drawRegularPolygon(gc, square, Color.BLACK, 1);
//        drawRegularPolygon(gc, pentagon, Color.BLACK, 1);
        //drawRegularPolygon(gc, hexagon, Color.BLACK, 1);
        //drawRegularPolygon(gc, septagon, Color.BLACK, 1);
        //drawRegularPolygon(gc, octagon, Color.BLACK, 1);
        //drawVenn(gc, triangle, Color.TOMATO, 1, 100);
        //drawVenn(gc, octagon, Color.TOMATO, 1, 50);
        //drawVenn(gc, pentagon, Color.TOMATO, 1, 100);
        //drawVenn(gc, nonagon, Color.BLACK, 1, 100);
        //drawRegularPolygon(gc, triangle, Color.DODGERBLUE, 5);
        //drawCircle(gc, Color.TOMATO, 10, new double[]{190, screenheight / 8}, 30);
      //  drawPolygonStar(gc, septagon, Color.GREEN, 1);
     // drawPolygonInscribed(gc, pentagon, Color.BLUE, 2);
        //drawPolygonStar(gc, septagon, Color.GREEN, 1);
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
    private void drawVenn(GraphicsContext gc, RegularPolygon polygon, Color color, int lineWidth, int diameter) {
        gc.setStroke(color);
        gc.setLineWidth(lineWidth);
        for(int i = 0; i < polygon.numberOfSides; i++){
            drawCircle(gc, color, lineWidth, new double[]{polygon.coords_x[i], polygon.coords_y[i]}, diameter);
        }
    }
    private void drawPolygonInscribed(GraphicsContext gc, RegularPolygon polygon, Color color, int lineWidth) {
            drawRegularPolygon(gc, polygon, color, lineWidth);
            drawCircle(gc, color, lineWidth, polygon.centerpoint, polygon.radius * 2);
    }

private void drawPolygonStar(GraphicsContext gc, RegularPolygon polygon, Color color, int lineWidth) {
            gc.setStroke(color);
        gc.setLineWidth(lineWidth);
            for(int i = 0; i < polygon.numberOfSides; i++){
                for(int a = 0; a < polygon.numberOfSides; a++){
                    if(i - a > 1 && i - a != polygon.numberOfSides - 1){
                        System.out.println("[" + i + "] " + "[" + a + "]");
                        gc.strokeLine(polygon.coords_x[i], polygon.coords_y[i], polygon.coords_x[a], polygon.coords_y[a]);
                    }
                      
                    
                
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
