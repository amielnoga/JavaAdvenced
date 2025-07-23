/**
 * class NoServiceChargeChecking- represents a type of checking account that has minimum balance 
 * which below no withdrawals can be made.
 * @author Noga Amiel
 * @version 22.12.23
 */
public class NoServiceChargeChecking extends CheckingAccount {
	
	protected static final double MIN_BALANCE=10;
	protected double _minimumBalance;
	
	/**
	 * Constructor for objects of class NoServiceChargeChecking - the constructor accepts the no service charge
	 * checking bank account information and a creates new one with default minimum balance.
	 */
	public NoServiceChargeChecking(String accountNumber, String nameOfAccountHolder, String idOfAccountHolder, double balance) {
		super(accountNumber, nameOfAccountHolder, idOfAccountHolder, balance);
		_minimumBalance=MIN_BALANCE;
	}
	
	/**
	 * Constructor for objects of class NoServiceChargeChecking - the constructor accepts the no service charge
	 * checking bank account information and creates a new one and initialize minimum balance to the given value.
	 */
	public NoServiceChargeChecking(String accountNumber, String nameOfAccountHolder, String idOfAccountHolder, double balance, double minimumBalance ) {
		super(accountNumber, nameOfAccountHolder, idOfAccountHolder, balance);
		_minimumBalance=minimumBalance;
	}
	
	/**
	 * @return the minimum balance of this account
	 */
	public double getMinBalance() {
		return _minimumBalance;
	}
	
	/**
	 * @param  minimumBalance the minimum balance to set
	 */
	public void setMinimumBalance(double minimumBalance) {
		_minimumBalance = minimumBalance;
	}
	
	/**
	 * toString method - returns a string of the no service charge checking bank account
	 * @return    bank account data as a string
	 */
	@Override
	public String toString() {
		return super.toString()+" ,NoServiceChargeChecking ["+ "minimumBalance= " + _minimumBalance + "]";
	}

	/**
	 * equals method - checks if a no service charge checking bank account received as a parameter is equal to
	 * the no service charge checking bank account on which the method was run
	 * @param  Object  service charge checking bank account
	 * @return    true if their data is equal, otherwise false
	 */
	@Override
	public boolean equals(Object obj) {
		if (null == obj || !(obj instanceof NoServiceChargeChecking)) {
			return false;
		}

		NoServiceChargeChecking other = (NoServiceChargeChecking) obj;
		return super.equals(this)
				&& _minimumBalance == other._minimumBalance;
	}

	/**
	 * monthlyManagement method - no action is needed
	 */
	@Override
	public void monthlyManagement() {
	}

}
