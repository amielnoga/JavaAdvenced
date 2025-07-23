import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class EX2Controller {

	@FXML
	private TextArea text;    
	@FXML
	private Button point,equal,plus,minus,multiply,divide,clear,zero,plusOrMinus;
	@FXML
	private GridPane grid;

	private SimpleCalculator simpleCalculator; 
	private final int SIZE=3;
	private Button[] buttons;

	public void initialize() {
		simpleCalculator= new SimpleCalculator();
		buttons=new Button[SIZE*SIZE];
		for(int i=0;i<SIZE*SIZE;i++)
		{
			buttons[i]=new Button(""+(i+1));
			buttons[i].setPrefSize(grid.getPrefWidth()/SIZE,
					grid.getPrefHeight()/SIZE);
			buttons[i].setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					handleButton(e);
				}
			});
			grid.add(buttons[i], i%SIZE, i/SIZE);
		}
	}
	private void handleButton(ActionEvent e) {
		Button selectedButton=(Button)e.getSource();
		simpleCalculator.setNumber(selectedButton.getText());
		displyOnScreen();
	}

	@FXML
	void zeroPressed(ActionEvent event) {
		simpleCalculator.setNumber("0");
		displyOnScreen();
	}

	void displyOnScreen() {
		text.setText(simpleCalculator.getTextToScreen());
	}

	@FXML
	void clearPressed(ActionEvent event) {
		simpleCalculator.clear();
		displyOnScreen();
	}

	@FXML
	void equalPressed(ActionEvent event) {
		simpleCalculator.calculate();
		displyOnScreen();
		simpleCalculator.continueCalculation();
	}

	@FXML
	void plusPressed(ActionEvent event) {
		simpleCalculator.setOperator('+');
	}

	@FXML
	void minusPressed(ActionEvent event) {
		simpleCalculator.setOperator('-');
	}

	@FXML
	void multiplyPressed(ActionEvent event) {
		simpleCalculator.setOperator('*');
	}

	@FXML
	void dividePressed(ActionEvent event) {
		simpleCalculator.setOperator('/');
	}

	@FXML
	void plusOrMinusPressed(ActionEvent event) {
		simpleCalculator.changeNumberSign();
		displyOnScreen();
	}

	@FXML
	void pointPressed(ActionEvent event) {
		simpleCalculator.setPointToNumber();
		displyOnScreen();
	}
}