/**
 * class CheckingAccount- represents a checking bank account that allows to write checks.
 * @author Noga Amiel
 * @version 22.12.23
 */
public abstract class CheckingAccount extends BankAccount {

	/**
	 * Constructor for objects of class CheckingAccount - the constructor accepts bank account information and
	 * creates a new checking bank account.
	 */
	public CheckingAccount(String accountNumber, String nameOfAccountHolder, String idOfAccountHolder, double balance) {
		super(accountNumber, nameOfAccountHolder, idOfAccountHolder, balance);
	}

	/**
	 * writeCheck method
	 * @param the check amount
	 * @throws IllegalBalance 
	 */
	public void writeCheck(double checkAmount)
	{
		if (checkAmount<=this.getBalance()-getMinBalance())
			withdrawal(checkAmount);
	}
	
	/**
	 * getMinBalance method 
	 * return the minimum balance must be in the bank account
	 */
	private double getMinBalance() {
		return 0;
	}
 
}