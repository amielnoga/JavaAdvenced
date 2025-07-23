import java.util.ArrayList;
import java.util.Collections;

/**
 * Question class- Each question has four possible answers, with only one answer being correct.
 */
public class Question {

	private String _question;
	private String _correctAnswer;
	private ArrayList<String> _possibleAnswers;

	/**
	 * Question contractor- initialize question by given parameters.
	 * The answers will be arranged in random order.
	 */
	public Question(String question, String correctAnswer,String wrongAnswer1, String wrongAnswer2, String wrongAnswer3) {
		_question=question;
		_correctAnswer=correctAnswer;
		_possibleAnswers= new ArrayList<String>();
		_possibleAnswers.add(correctAnswer);
		_possibleAnswers.add(wrongAnswer1);
		_possibleAnswers.add(wrongAnswer2);
		_possibleAnswers.add(wrongAnswer3);
		Collections.shuffle(_possibleAnswers);
	}

	/**
	 * @return the question
	 */
	public String getQuestionValue() {
		return _question;
	}

	/**
	 * @return the possible answers
	 */
	public ArrayList<String> getPossibleAnswers() {
		return _possibleAnswers;
	}

	/**
	 * @return the correct answer
	 */
	public String getCorrectAnswer() {
		return _correctAnswer;
	}
}