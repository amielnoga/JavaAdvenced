import java.util.ArrayList;
import java.util.Random;

/**
 * class WordsStock represents word bank for the word guessing game
 *
 * @author Noga Amiel
 * @version 08.12.23
 */
public class WordsStock {
	private ArrayList<String> wordsArray;

	/**
	 * Constructor for objects of class WordsStock
	 * The word bank initialized within the program and is permanent.
	 */		
	public WordsStock(){
		this.wordsArray=new ArrayList<String>();
		wordsArray.add("love");
		wordsArray.add("war");
		wordsArray.add("king");
		wordsArray.add("prince");
		wordsArray.add("pizza");
		wordsArray.add("pineapple");
		wordsArray.add("apple");
		wordsArray.add("river");
		wordsArray.add("sea");
		wordsArray.add("peace");  
	}

	/**
	 * getRandomWord method
	 *
	 * @return    random word of word bank for user to guess
	 */
	public String getRandomWord(){
		Random rand=new Random();
		return wordsArray.get(rand.nextInt(wordsArray.size()));
	}
}