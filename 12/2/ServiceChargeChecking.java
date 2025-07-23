/**
 * class ServiceChargeChecking- represents a type of checking account that is charged with a monthly fee.
 * @author Noga Amiel
 * @version 22.12.23
 */
public class ServiceChargeChecking extends CheckingAccount {

	private static final double MONTLY_FEE=10;
	private double _monthlyFee;
	
	/**
	 * Constructor for objects of class ServiceChargeChecking - the constructor accepts the service charge
	 * checking bank account information and a creates new one with default monthly fee.
	 */
	public ServiceChargeChecking(String accountNumber, String nameOfAccountHolder, String idOfAccountHolder, double balance) {
		super(accountNumber, nameOfAccountHolder, idOfAccountHolder, balance);
		_monthlyFee=MONTLY_FEE;
	}
	
	/**
	 * Constructor for objects of class ServiceChargeChecking - the constructor accepts the service charge
	 * checking bank account information and creates a new one with initialize monthly fee to the given value.
	 */
	public ServiceChargeChecking(String accountNumber, String nameOfAccountHolder, String idOfAccountHolder, double balance, double monthlyFee) {
		super(accountNumber, nameOfAccountHolder, idOfAccountHolder, balance);
		_monthlyFee=monthlyFee;
	}

	/**
	 * @return the monthly fee of the bank account
	 */
	public double getMonthlyFee() {
		return _monthlyFee;
	}

	/**
	 * @param monthlyFee the new monthly fee to set to the bank account
	 */
	public void setMonthlyFee(double monthlyFee) {
		_monthlyFee = monthlyFee;
	}
	
	/**
	 * monthlyManagement method - implementation of a bank account function 
	 */
	public void monthlyManagement()
	{
		_balance-=_monthlyFee;
	}
	
	/**
	 * toString method - returns a string of the service charge checking bank account
	 * @return    bank account data as a string
	 */
	@Override
	public String toString() {
		return super.toString()+" ,ServiceChargeChecking ["+ "monthlyFee= " + _monthlyFee + "]";
	}

	/**
	 * equals method - checks if a service charge checking bank account received as a parameter is equal to the
	 * the service charge checking bank account on which the method was run
	 * @param  Object  service charge checking bank account
	 * @return    true if their data is equal, otherwise false
	 */
	@Override
	public boolean equals(Object obj) {
		if (null == obj || !(obj instanceof ServiceChargeChecking)) {
			return false;
		}

		ServiceChargeChecking other = (ServiceChargeChecking) obj;
		return super.equals(this)
				&& _monthlyFee == other._monthlyFee;
	}
	
	

}
