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
 
public class Conklin_JavaFXArt extends Application {
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
        drawEquilateralTriangle(gc, new double[]{screenwidth - 100, screenheight - 75}, 50);
        drawTrinity(gc, new double[]{screenwidth/2, screenheight/3}, 50);
        drawCircle(gc, new double[]{50, screenheight - 75}, 50, Color.LIMEGREEN);
        drawSquare(gc, new double[]{screenwidth/2, screenheight - 75}, 20);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    private void drawEquilateralTriangle(GraphicsContext gc, double[] centerpoint, double side) {
               double x=side/2;
               double height = Math.sqrt(3) * x;
               gc.setStroke(Color.LIGHTCORAL);
               gc.setLineWidth(5);
               gc.strokePolygon(new double[]{centerpoint[0], centerpoint[0] - x, centerpoint[0] + x},
                       new double[]{(centerpoint[1] - (0.5*height)), (centerpoint[1] + (0.5*height)), (centerpoint[1] + (0.5*height))}, 3);
    }
    private void drawSquare(GraphicsContext gc, double[] centerpoint, double side) {
               double x=side/2;
               gc.setStroke(Color.BROWN);
               gc.setLineWidth(5);
               gc.strokePolygon(new double[]{centerpoint[0] - x, centerpoint[0] + x, centerpoint[0] + x, centerpoint[0] - x},
                       new double[]{centerpoint[1] + x, centerpoint[1] + x, centerpoint[1] - x, centerpoint[1] - x}, 4);
    }
    
    private void drawCircle(GraphicsContext gc, double[] centerpoint, double diameter, Color color){
        gc.setLineWidth(5);
        gc.setStroke(color);
        gc.strokeOval(centerpoint[0], centerpoint[1], diameter, diameter);
       
    }
    private void drawTrinity(GraphicsContext gc, double[] centerpoint, double size){
        double x = size / 2;
         double apothem = 0.5 * x * Math.sqrt(3);
        double[] coords_x = {centerpoint[0] - x, centerpoint[0], centerpoint[0] + x};
        double[] coords_y = {centerpoint[1] + apothem, centerpoint[1] - apothem, centerpoint[1] + apothem};
       for(int i =0; i < coords_x.length; i++){
          // gc.strokeOval(coords_x[i] - (size), coords_y[i] - (size), size * 2, size * 2);
           drawCircle(gc, new double[]{coords_x[i] - (size), coords_y[i] - (size)}, size * 2, Color.GOLDENROD);
       }
        
       
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
}
