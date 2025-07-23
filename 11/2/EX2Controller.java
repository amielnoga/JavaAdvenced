import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * class EX2Controller - JavaFX application that after clicking on button displays a drawing
 * of ten shapes with random properties as follows:
 * The shapes are squares, ovals and lines.
 * Their color is determined randomly.
 * The size of the shapes in pixels is limited so that the width and height is less than a quarter
	from the width and height of the drawing surface.
 * The position of the shapes is randomly determined according to the width and height of the drawing surface.
 *
 * @author Noga Amiel
 * @version 09.12.23
 */
public class EX2Controller {

    @FXML
    private GridPane gridPame;
    @FXML
    private Button button;
    @FXML
    private Canvas canvas;
    private GraphicsContext gc;
    private final int NUMBER_OF_SHAPES=10;
    
    public void initialize() {
    	gc = canvas.getGraphicsContext2D();
    }

    
    @FXML
    void buttonClick(ActionEvent event) {
    	gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    	for(int i=1;i<=NUMBER_OF_SHAPES;i++)
    	{
    		Random rnd = new Random();

    		Color color = Color.rgb(rnd.nextInt(255),rnd.nextInt(255),rnd.nextInt(255));
    		gc.setFill(color);
    		gc.setStroke(color);
    		
    		int shapeType=rnd.nextInt(3);
    		int x=rnd.nextInt((int)canvas.getWidth());
    		int y=rnd.nextInt((int)canvas.getHeight());
    		int w= rnd.nextInt((int)canvas.getWidth())/4;
    		int h= rnd.nextInt((int)canvas.getHeight())/4;
    		switch(shapeType) {
    		case 0:
    			gc.fillRect(x,y,w,h);
    			break;
    		case 1:
    			gc.fillOval(x,y,w,h);
    			break;
    		case 2:
    			gc.strokeLine(x,y,w,h);
    			break;
    		}    	
    	}
    }
}
