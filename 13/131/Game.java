import java.util.ArrayList;

/**
 * Game class- 
 */
public class Game {

	private int _successAnswersConounter;
	private int _numberOfQuestions;
	private int _numberOfCurrentQuestions;
	private QuestionsBank _questionsBank;

	/**
	 * Game contractor- initialize exam according the question bank.
	 */    
	public Game() {
		_questionsBank=new QuestionsBank();
		_numberOfQuestions= _questionsBank.getNumberOfQuestionsInTheBank();
		_successAnswersConounter=0;
		_numberOfCurrentQuestions=0;
	}	

	/**
	 * getNumberOfCurrentQuestions method
	 * @return the number of current questions
	 */
	public int getNumberOfCurrentQuestions() {
		return _numberOfCurrentQuestions;
	}	

	/**
	 * getNumberOfQuestions method
	 * @return the number of questions
	 */
	public int getNumberOfQuestions() {
		return _numberOfQuestions;
	}

	/**
	 * getCurrentQuestion method
	 * @return the current question
	 */
	public String getCurrentQuestion()
	{
		return _questionsBank.getQuestionPerIndex(_numberOfCurrentQuestions).getQuestionValue();
	}

	/**
	 * getAnswers method
	 * @return the possible answers of the current question 
	 */
	public ArrayList<String> getAnswers()
	{
		return _questionsBank.getQuestionPerIndex(_numberOfCurrentQuestions).getPossibleAnswers();
	}

	/**
	 * verifyAnswerIsCorrect method
	 * @param the answer
	 * @return true if the answer is correct, otherwise false.
	 */
	public boolean verifyAnswerIsCorrect(String answer)
	{
		if(answer.equals(_questionsBank.getQuestionPerIndex(_numberOfCurrentQuestions).getCorrectAnswer()))
		{
			_successAnswersConounter++;
			return true;
		}
		else
			return false;
	}

	/**
	 * nextQuestion method- updates the current question to be the next question.
	 */
	public void nextQuestion()
	{
		_numberOfCurrentQuestions++;
	}		

	/**
	 * getGrade method
	 * @return the grade of the examinee.
	 */
	public int getGrade()
	{
		return (int) (100*(_successAnswersConounter/((double)_numberOfQuestions)));
	}		

	/**
	 * startNewGame method- initialize game values to be initial values
	 */
	public void startNewGame() {
		_successAnswersConounter=0;
		_numberOfCurrentQuestions=0;
	}

}
