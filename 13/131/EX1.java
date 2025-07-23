import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * EX1 class
 */
public class EX1 extends Application{ 

	/**
	 * start method
	 */	
	public void start(Stage stage) throws Exception{ 
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("EX1.fxml")); 
		Scene scene = new Scene(root); 
		stage.setTitle("EX1"); 
		stage.setScene(scene); 
		stage.show(); 
	} 

	/**
	 * main method
	 */
	public static void main(String[] args) { 
		launch(args); 
	} 
}