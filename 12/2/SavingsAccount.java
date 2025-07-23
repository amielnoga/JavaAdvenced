/**
 * class SavingsAccount- represents a savings bank account that has interest.
 * @author Noga Amiel
 * @version 23.12.23
 */
public class SavingsAccount extends BankAccount 
{
	protected static final double INTEREST_RATE=50;
	protected double _interestRate;
	
	/**
	 * Constructor for objects of class SavingsAccount - the constructor accepts bank account information and
	 * creates a new savings bank account with default rate interest.
	 */
	public SavingsAccount(String accountNumber, String nameOfAccountHolder, String idOfAccountHolder, double balance)
	{
		super(accountNumber, nameOfAccountHolder,idOfAccountHolder,balance);
		_interestRate=INTEREST_RATE;
	}
	
	/**
	 * Constructor for objects of class SavingsAccount - the constructor accepts bank account information and
	 * creates a new savings bank account with the given rate interest.
	 */
	public SavingsAccount(String accountNumber, String nameOfAccountHolder, String idOfAccountHolder, double balance, double rateInterst)
	{
		super(accountNumber, nameOfAccountHolder,idOfAccountHolder,balance);
		_interestRate=rateInterst;
	}
	
	/**
	 * getRateInterest method
	 * @return the rate interest
	 */
	public double getRateInterest() {
		return _interestRate;
	}
	
	/**
	 * setRateInterst method
	 * @param rateInterst the rate interest to set
	 */
	public void setRateInterst(double rateInterst) {
		_interestRate = rateInterst;
	}
	
	/**
	 * getCalculateInterest method
	 * @return the calculate interest
	 */
	public double getCalculateInterest() {
		return _interestRate*_balance;
	}
	
	/**
	 * monthlyManagement method - implementation of a bank account function 
	 */
	public void monthlyManagement()
	{
		_balance+=getCalculateInterest();
	}
	
	/**
	 * toString method - returns a string of savings account
	 * @return    savings account data as a string
	 */
	@Override
	public String toString() {
		return super.toString()+ " ,SavingsAccount [interestRate=" + _interestRate + "]";
	}

	/**
	 * equals method - checks if a savings account received as a parameter is equal to the the savings account
	 * on which the method was run
	 * @param  Object  savings account
	 * @return    true if their data is equal, otherwise false
	 */
	@Override
	public boolean equals(Object obj) {
		if (null == obj || !(obj instanceof SavingsAccount)) {
			return false;
		}
		
		SavingsAccount other = (SavingsAccount) obj;
		return super.equals(other) && _interestRate == other._interestRate;
	}
}