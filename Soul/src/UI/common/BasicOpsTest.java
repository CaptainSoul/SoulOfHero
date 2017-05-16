package UI.common;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
 
public class BasicOpsTest extends Application {
 
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Package");
        Group root = new Group();
        Canvas canvas = new Canvas(300, 500);
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        // 在用户拖动鼠标时擦除部分内容
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, 
        new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                gc.clearRect(e.getX() - 2, e.getY() - 2, 5, 5);
            }
        });
  
     // 当用户双击鼠标时使用蓝色矩形填充Canvas
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, 
         new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent t) {            
                 if (t.getClickCount() >1) {
                     reset(canvas, Color.BLUE);
                 }  
             }
         });
        root.getChildren().add(canvas);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void drawShapes(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                       new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90},
                         new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140},
                          new double[]{210, 210, 240, 240}, 4);
    }
    private void reset(Canvas canvas, Color color) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(color);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
}
