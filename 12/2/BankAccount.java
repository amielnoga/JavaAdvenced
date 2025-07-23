/**
 * class BankAccount- represents a bank account
 * @author Noga Amiel
 * @version 22.12.23
 */
public abstract class BankAccount
{
	private String _accountNumber;
	private String _nameOfAccountHolder;
	private String _idOfAccountHolder;
	protected double _balance;

	/**
	 * Constructor for objects of class BankAccount - the constructor accepts bank account information and
	 * creates a new bank account.
	 */
	public BankAccount(String accountNumber, String nameOfAccountHolder, String idOfAccountHolder, double balance)
	{
		_accountNumber=accountNumber;
		_nameOfAccountHolder=nameOfAccountHolder;
		_idOfAccountHolder=idOfAccountHolder;
		_balance=balance;
	}

	/**
	 * getAccountNumber method
	 * @return the account number
	 */
	public String getAccountNumber() {
		return _accountNumber;
	}

	/**
	 * getNameOfAccountHolder method
	 * @return the name of the account holder
	 */
	public String getNameOfAccountHolder() {
		return _nameOfAccountHolder;
	}

	/**
	 * setNameOfAccountHolder method
	 * @param nameOfAccountHolder the name of the account holder number to set to the bank account
	 */
	public void setNameOfAccountHolder(String nameOfAccountHolder) {
		_nameOfAccountHolder = nameOfAccountHolder;
	}

	/**
	 * getIDOfAccountHolder method
	 * @return the ID of the bank account holder
	 */
	public String getIDOfAccountHolder() {
		return _idOfAccountHolder;
	}

	/**
	 * getBalance method
	 * @return the balance of the bank account
	 */
	public double getBalance() {
		return _balance;
	}

	/**
	 * setBalance method
	 * @param balance the balance of the bank account
	 */
	public void setBalance(double balance) {
		_balance = balance;
	}

	/**
	 * deposit method
	 * @param money the money to deposit in the bank account
	 */
	public void deposit(double money)
	{
		if(money>0)
			_balance+=money;
	}

	/**
	 * withdrawal method - overdraft is not possible
	 * @param money the money to withdrawal from the bank account
	 * @throws IllegalBalance 
	 */
	public void withdrawal(double money)
	{
		try {
			if(money-getMinBalance()>_balance)
				throw new IllegalBalance();
			_balance-=money;
		}
		catch(IllegalBalance e){
			System.out.println("Sorry! You don't have enough money in your account");	
		}
	}
	
	/**
	 * getMinBalance method 
	 * return the minimum balance must be in the bank account
	 */
	private double getMinBalance() {
		return 0;
	}

	/**
	 * monthlyManagement method - an operation will be performed according to the type of bank account.
	 */
	public abstract void monthlyManagement();

	/**
	 * toString method - returns a string of the bank account
	 * @return    bank account data as a string
	 */
	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + _accountNumber + ", nameOfAccountHolder=" + _nameOfAccountHolder
				+ ", idOfAccountHolder=" + _idOfAccountHolder + ", balance=" + _balance + "]";
	}

	/**
	 * equals method - checks if a bank account received as a parameter is equal to the the bank account
	 * on which the method was run.
	 * @param  Object  bank account
	 * @return    true if if their data is equal, otherwise false
	 */
	@Override
	public boolean equals(Object obj) {
		if (null == obj || !(obj instanceof BankAccount)) {
			return false;
		}

		BankAccount other = (BankAccount) obj;
		return _accountNumber.equals(other._accountNumber)
				&& _balance == other._balance
				&& _idOfAccountHolder.equals(other._idOfAccountHolder)
				&& _nameOfAccountHolder.equals(other._nameOfAccountHolder);
	}


}
