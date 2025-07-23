import java.util.ArrayList;
/**
 * QuestionsBank - class represents a questions bank
 */
public class QuestionsBank  {

	private ArrayList<Question> _questions=new ArrayList<Question>();

	/**
	 * QuestionsBank contractor- initialize question of questions bank 
	 */
	public QuestionsBank() {
		_questions.add(new Question("What is the capital city of Israel?","Jerusalem","Tel Aviv","Haifa","Be'er Sheva"));
		_questions.add(new Question("What is the capital city of USA?","Washington D.C","Phoenix","New York City","Houston"));
		_questions.add(new Question("What is the capital city of Iran?","Tehran","Shiraz","Isfahan","Mashhad"));
		_questions.add(new Question("What is the capital city of Egypt?","Cairo","Alexandria","Suez","Sharm El Sheikh"));
		_questions.add(new Question("What is the capital city of Lebanon?","Beirut","Bint Jbeil","Tripoli","Jounieh"));
	}

	/**
	 * @param index the index of the question
	 * @return specific question of the bank
	 */
	public Question getQuestionPerIndex(int index) {
		return _questions.get(index);
	}

	/**
	 * @return the number of questions in the bank
	 */
	public int getNumberOfQuestionsInTheBank() {
		return _questions.size();
	}		
}
