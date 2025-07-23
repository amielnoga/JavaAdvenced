/**
 * class HighInterestSavings- represents a savings bank account that has a minimum balance carries a
 * higher interest rate than a regular savings account.
 * @author Noga Amiel
 * @version 23.12.23
 */
public class HighInterestSavings extends SavingsAccount {
	private static final double INTEREST_RATE=500;
	private double _interestRate;
	private static final double MIN_BALANCE=1000;
	protected double _minBalance;

	/**
	 * Constructor for objects of class HighInterestSavings - the constructor accepts bank account information and
	 * creates a new high interest savings bank account with default rate interest and a new minimum balance.
	 */
	public HighInterestSavings(String accountNumber, String nameOfAccountHolder, String idOfAccountHolder, double balance, double minBalance)
	{
		super(accountNumber, nameOfAccountHolder,idOfAccountHolder,balance);
		_interestRate=INTEREST_RATE;
		_minBalance=minBalance;
	}

	/**
	 * Constructor for objects of class HighInterestSavings - the constructor accepts bank account information and
	 * creates a new high interest savings bank account with new rate interest and a new minimum balance.
	 */
	public HighInterestSavings(String accountNumber, String nameOfAccountHolder, String idOfAccountHolder, double balance, double minBalance, double rateInterest)
	{
		super(accountNumber, nameOfAccountHolder,idOfAccountHolder,balance);
		_interestRate=rateInterest;
		_minBalance=minBalance;
	}

	/**
	 * Constructor for objects of class HighInterestSavings - the constructor accepts bank account information and
	 * creates a new high interest savings bank account with default rate interest a default minimum balance.
	 */
	public HighInterestSavings(String accountNumber, String nameOfAccountHolder, String idOfAccountHolder, double balance)
	{
		super(accountNumber, nameOfAccountHolder,idOfAccountHolder,balance);
		_interestRate=INTEREST_RATE;
		_minBalance=MIN_BALANCE;
	}

	/**
	 * Constructor for objects of class HighInterestSavings - the constructor accepts bank account information and
	 * creates a new high interest savings bank account with new rate interest a default minimum balance.
	 */
	public HighInterestSavings( double rateInterest, String accountNumber, String nameOfAccountHolder, String idOfAccountHolder, double balance)
	{
		super(accountNumber, nameOfAccountHolder,idOfAccountHolder,balance);
		_interestRate=rateInterest;
		_minBalance=MIN_BALANCE;
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
	 * getMinBalance method
	 * @return the minimum balance
	 */
	public double getMinBalance() {
		return _minBalance;
	}

	/**
	 * setMinBalance method
	 * @param minBalance the minimum balance to set
	 */
	public void setMinBalance(double minBalance) {
		_minBalance = minBalance;
	}

	/**
	 * toString method - returns a string in of  high interest savings bank account
	 * @return     high interest savings bank account data as a string
	 */
	@Override
	public String toString() {
		return super.toString()+ " ,HighInterestSavings [rateInterest=" + _interestRate +", minBalance="+_minBalance+ "]";
	}

	/**
	 * equals method - checks if a high interest savings bank account received as a parameter is equal to
	 * the high interest savings bank account on which the method was run
	 * @param  Object  high interest savings bank account
	 * @return    true if their data is equal, otherwise false
	 */
	@Override
	public boolean equals(Object obj) {
		if (null == obj || !(obj instanceof HighInterestSavings)) {
			return false;
		}

		HighInterestSavings other = (HighInterestSavings) obj;
		return super.equals(other) && _interestRate == other._interestRate 
				&& _minBalance==other._minBalance;
	}	
}