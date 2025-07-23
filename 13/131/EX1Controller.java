import java.util.Optional;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class EX1Controller 
{
	@FXML
	private TextField  questionId;
	@FXML
	private RadioButton answer1;
	@FXML
	private RadioButton answer2;
	@FXML
	private RadioButton answer3;
	@FXML
	private RadioButton answer4;   
	@FXML
	private ToggleGroup answers;    

	private Game game;

	/**
	 * initialize method - starts new exam
	 */   
	public void initialize() {
		game = new Game();
		loadQuestion();
	}

	/**
	 * setQuestion method
	 * @param the question to set in the screen
	 */
	public void setQuestion(String question) {
		this.questionId.setText(question);
	}

	/**
	 * setAnswer method
	 * @param the number of answer to set,  the answer to set in the screen
	 */
	public void setAnswer(int numberOfAnswer, String answer) {
		RadioButton radioButton=null;
		switch(numberOfAnswer)
		{
		case 1:
		{
			radioButton=answer1;
			break;
		}
		case 2:
		{
			radioButton=answer2;
			break;
		}
		case 3:
		{
			radioButton=answer3;
			break;
		}
		case 4:
		{
			radioButton=answer4;
			break;
		}
		}
		radioButton.setText(answer);
	}

	/**
	 * continuePressed method - Handles the user's click
	 * event the number of answer to set,  the answer to set in the screen
	 */
	@FXML
	void continuePressed(ActionEvent event) {
		Alert alert;
		AlertType alertType;
		String title, headerText,contentText;   	
		RadioButton selectedToggle=(RadioButton)answers.getSelectedToggle();
		if(selectedToggle!=null)
		{
			if(game.verifyAnswerIsCorrect(selectedToggle.getText()))
			{
				alertType=AlertType.INFORMATION;
				title="Verifing Answer";
				headerText="Good Job!";
				contentText="Keep it up";
			}
			else
			{
				alertType=AlertType.ERROR;
				title="Verifing Answer";
				headerText="Try harder!";
				contentText="Do not give up";
			}    	
			alert = new Alert(alertType);
			alert.setTitle(title);
			alert.setHeaderText(headerText);
			alert.setContentText(contentText);
			alert.show();
			if(game.getNumberOfCurrentQuestions()+1<game.getNumberOfQuestions())
			{
				answers.selectToggle(null); //clearing user selection
				game.nextQuestion();
				loadQuestion();	
			}
			else
			{
				answers.selectToggle(null); //clearing user selection
				alert.close();
				alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Thanks for submitting the test");
				alert.setHeaderText("Your final grade is");
				alert.setContentText(""+game.getGrade());
				alert.showAndWait();
				finishExam();	
			} 	
		}
		else
		{
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("You didn't selcet any answer");
			alert.setHeaderText("You must choose one answer");
			alert.setContentText("if you don't know you may guess");
			alert.showAndWait();
		}
	}

	/**
	 * finishExam method- the method renders pop-up on the screen 
	 * allows the user to start the questions from the start or finish test.
	 */
	private void finishExam() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("The test ended successfully");
		alert.setHeaderText("Do you want to start a new exam?");
		alert.setContentText("You have a chance to improve your grade, last grade counts!");
		ButtonType yes = new ButtonType("Yes");
		ButtonType no = new ButtonType("No");
		alert.getButtonTypes().setAll(yes, no);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.isPresent()) 
		{
			ButtonType response = result.get();
			if (response == yes) 
			{
				game.startNewGame();
				loadQuestion();
			}
			else 
				Platform.exit();
		}       
	}

	/**
	 * loadQuestion method- the method renders the question on the screen
	 */
	private void loadQuestion()
	{
		setQuestion(game.getCurrentQuestion());
		setAnswer(1,game.getAnswers().get(0));
		setAnswer(2,game.getAnswers().get(1));
		setAnswer(3,game.getAnswers().get(2));
		setAnswer(4,game.getAnswers().get(3));	
	}    
}