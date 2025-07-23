import java.util.Scanner;

/**
 * class Game represents a word guessing game.
 *
 * @author Noga Amiel
 * @version 08.12.23
 */
public class Game {
	private ChosenWord chosenWord;
	private int guessConter;
	private String lettersNotChosen;

	/**
	 * Constructor for objects of class Game
	 * the constructor initialize game:
	 * creates a new word bank and initialize the word the user needs to guess.
	 * initialize guess counter to 0 - no guess done yet.
	 * initialize letters not chosen to all a-z letters.
	 */
	public Game(){
		WordsStock wordsStock=new WordsStock();
		this.chosenWord= new ChosenWord(wordsStock.getRandomWord());
		this.guessConter=0;
		this.lettersNotChosen="abcdefghijklmnopqrstuvwxyz";
	}
	/**
	 * play method represents the whole game.
	 * it used to interact with the user in order to execute the game.
	 */
	public void play(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("Welcome to word guessing game");
		chosenWord.printGuessedWord();
		String gamerInput;
		char userChar;
		while (!(chosenWord.equalsGussedWord())){	
			boolean validInput;
			do{
				validInput=true;
				System.out.print("Enter a lowercase letter (a-z): ");
				gamerInput=scanner.next();
				userChar=gamerInput.charAt(0);
				if(gamerInput.length()!=1){
					System.out.println("enter only one letter.");
					validInput=false;
				}
				else if (!(userChar >= 'a' && userChar <= 'z')) {
					System.out.println("enter a lowercase letter.");
					validInput=false;
				} 
				else if(lettersNotChosen.indexOf(userChar)==-1){
					System.out.println(userChar+" was already choosen, try anoter letter form "+lettersNotChosen);
					validInput=false;
				}
			}
			while(!validInput);

			guessConter++; //counting only valid guesses
			lettersNotChosen=lettersNotChosen.replace(String.valueOf(userChar),"");

			if(chosenWord.checkChar(userChar)){
				chosenWord.printGuessedWord();
			}
			else
				System.out.println("Sorry, try again! "+userChar+" is not in the word ");
		}
		System.out.println("Well Done! The number of guesses: "+guessConter);
		System.out.println("Click y to continue the game or click n to quit");
		userChar=scanner.next().charAt(0);
		switch (userChar)
		{
		case 'n':
			System.out.println("Come to play another time, don't forget to rate us in the store.");
			break;
		case 'y':
		default:
		{
			WordsStock wordsStock=new WordsStock();
			this.chosenWord= new ChosenWord(wordsStock.getRandomWord());
			this.guessConter=0;
			this.lettersNotChosen="abcdefghijklmnopqrstuvwxyz";		
			play();
		}
		}

	}

	public static void main(String[] args) {
		Game game=new Game();
		game.play();
	}
}
