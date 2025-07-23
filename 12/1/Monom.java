import java.util.Comparator;

/**
 * class Monom- a monom is a a polynom which has only one term.
 * @author Noga Amiel
 * @version 21.12.23
 */
public class Monom implements Comparable
{
	private double _coefficient;
	private int _power;

	/**
	 * Constructor for objects of class Monom - the constructor accepts a coefficient and
	 * a power and produces a monom.
	 */
	public Monom(double coefficient, int power)
	{
		_coefficient=coefficient;
		_power=power;
	}

	/**
	 * getCoefficient method
	 *
	 * @return    monom coefficient
	 */
	public double getCoefficient()
	{
		return _coefficient;
	}

	/**
	 * getPower method
	 * 
	 * @return   monom power
	 */
	public int getPower()
	{
		return _power;
	}

	/**
	 * setCoefficient method
	 *
	 * @param  coefficient to set for monom 
	 */
	public void setCoefficient(double newCoefficient)
	{
		_coefficient=newCoefficient;
	}

	/**
	 * setPower method
	 *
	 * @param  power to set for monom  
	 */
	public void setPower(int newPower)
	{
		_power=newPower;
	}

	/**
	 * compareTo method-  implements the Comparable interface
	 *
	 * @param  monom to compare to  
	 * @return    -1, parameter is less than monom power
	 * 			   0, powers are equal
	 * 			   1, parameter is greater monom power
	 * 
	 */
	public int compareTo(Object object) {
		if(object==null || !(object instanceof Monom))
		{} //throw an exception
		Monom monom = (Monom)object;	
		return Integer.compare(monom._power,this._power);
	}
}
