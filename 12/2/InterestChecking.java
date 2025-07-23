/**
 * class InterestChecking- represents a type of checking account that has interest.
 * These accounts are free from service charge, with higher minimum balance. 
 * @author Noga Amiel
 * @version 23.12.23
 */
public class InterestChecking extends NoServiceChargeChecking {

	private static final double MIN_BALANCE=100;
	private static final double INTEREST_RATE=0.3;
	private double _interestRate;
	
	/**
	 * Constructor for objects of class InterestChecking - the constructor accepts bank account information and
	 * creates a new interest checking bank account with default interest rate.
	 */
	public InterestChecking(String accountNumber, String nameOfAccountHolder, String idOfAccountHolder,
			double balance) 
	{
		super(accountNumber, nameOfAccountHolder, idOfAccountHolder, balance);
		_interestRate=INTEREST_RATE;
	} 
	
	/**
	 * Constructor for objects of class InterestChecking - the constructor accepts bank account information and
	 * creates a new interest checking bank account with given interest rate.
	 */
	public InterestChecking(String accountNumber, String nameOfAccountHolder, String idOfAccountHolder,
			double balance,double interestRate) 
	{
		super(accountNumber, nameOfAccountHolder, idOfAccountHolder, balance);
		_interestRate=interestRate;
	} 
	
	/**
	 * @return the interest rate
	 */
	public double getInterestRate() {
		return _interestRate;
	}
	/**
	 * @param interest rate the interest rate to set
	 */
	public void setInterestRate(double interestRate) {
		_interestRate = interestRate;
	}
	
	/**
	 * @return the calculated interest
	 */
	public double calculateInterest()
	{
		return _interestRate*_balance;
	}
	
	/**
	 * The monthly management method will credit the interest checking bank account with the
	 * monthly interest amount.
	 */
	public void monthlyManagement()
	{
		_balance+=calculateInterest();
	}
	
	/**
	 * toString method - returns a string of the interest checking bank account
	 * @return     interest checking bank account data as a string
	 */
	@Override
	public String toString() {
		return super.toString()+ " ,InterestChecking [interestRate=" + _interestRate+ "]";
	}

	/**
	 * equals method - checks if an interest checking bank account received as a parameter is equal to
	 * the interest checking bank account on which the method was run
	 * @param  Object  interest checking bank account
	 * @return    true if their data is equal, otherwise false
	 */
	@Override
	public boolean equals(Object obj) {
		if (null == obj || !(obj instanceof InterestChecking)) {
			return false;
		}
		
		InterestChecking other = (InterestChecking) obj;
		return super.equals(other) && _interestRate == other._interestRate;
	}	
}
