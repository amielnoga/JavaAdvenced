/**
 * class ChosenWord represents the word from the bank word the user needs to guess.
 *
 * @author Noga Amiel
 * @version 08.12.23
 */
public class ChosenWord {

	private String chosenWord;
	private char[] guessedWord;

	/**
	 * Constructor for objects of class ChosenWord
	 * the Constructor gets the random word from the word bank
	 * and initialize the guessed word to include only underscore characters.
	 */
	public ChosenWord(String word){
		chosenWord=word;
		guessedWord=new char[chosenWord.length()];
		for (int i = 0; i < guessedWord.length; i++) {
			guessedWord[i] = '_';
		}
	}

	/**
	 * method printGuessedWord - printing to the console the word the user needs to guess .
	 */
	public void printGuessedWord(){
		for(int i=0;i<guessedWord.length;i++)
			System.out.print(guessedWord[i]+" ");
		System.out.println("");	
	}

	/**
	 * checkChar method verifies if char exist in chosen word.
	 * if yes it update the guessedWord accordingly.
	 *
	 * @param  guessChar  the user guess in his turn.
	 * @return    whether char exist in chosen word
	 */
	public boolean checkChar(char guessChar){
		boolean isCharExistInChosenWord = false;
		for (int i = 0; i < chosenWord.length(); i++) {
			if (chosenWord.charAt(i) == guessChar) {
				guessedWord[i] = guessChar;
				isCharExistInChosenWord = true;
			}
		}
		return isCharExistInChosenWord;
	}

	/**
	 * equalsGussedWord method verifies if guessed word is equal to the chosen word.
	 *
	 * @return    whether guessed word equals to the chosen word
	 */
	public boolean equalsGussedWord(){
		for (int i = 0; i < guessedWord.length; i++) {
			if(guessedWord[i] == '_')	
				return false;
		}
		return true;
	}
}