import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * class Polynom- a polynomial is a mathematical expression consisting of indeterminate, powers and coefficients.
 * The coefficients are real numbers, and the exponents are natural numbers.
 * An example of a polynom: x^3 + 2x^2 + 1.
 * @author Noga Amiel
 * @version 21.12.23
 */
public class Polynom
{
	private ArrayList<Monom> _polynom= new ArrayList<Monom>();

	/**
	 * Constructor for objects of class Polynom - the constructor accepts an array of coefficients and
	 * an array of powers and produces a polynom. The member with the highest power will be at the top
	 * of the list and the member with the lowest power will be at the end. 
	 * (Each member will be consisting of a coefficient and a power).
	 * @throws Exception if number of coefficients is not to equal to number of powers.
	 */
	public Polynom(double[]coefficients, int []powers) throws Exception
	{
		if(coefficients.length !=powers.length)
			throw new Exception("ERROR: Number of coefficients must be equal to number of powers");
		for (int i=0;i<coefficients.length;i++)
		{
			_polynom.add(new Monom(coefficients[i],powers[i]));
		}
		Collections.sort(_polynom);
	}

	/**
	 * plus method- addition of polynomials according to the accepted rules.
	 * @param  polynom  
	 * @return    the sum of this polynom and the polynom the method was given
	 * @throws Exception 
	 */
	public Polynom plus(Polynom polynom) throws Exception
	{
		System.out.print("("+this.toString()+") + ("+polynom.toString()+") = ");
		Polynom sum=new Polynom(new double[] {}, new int [] {});

		int i=0,j=0;
		while (i<_polynom.size() && j<polynom._polynom.size())
		{
			Monom member1=_polynom.get(i);
			Monom member2=polynom._polynom.get(j);

			if(member1.getPower()==member2.getPower())
			{
				sum._polynom.add(new Monom(member1.getCoefficient()+member2.getCoefficient(),member1.getPower()));
				i++;
				j++;
			}

			else if(member1.getPower()>member2.getPower())
			{
				sum._polynom.add(new Monom(member1.getCoefficient(),member1.getPower()));
				i++;
			}

			else
			{
				sum._polynom.add(new Monom(member2.getCoefficient(),member2.getPower()));
				j++;
			}		
		}

		while (i<_polynom.size())
		{
			sum._polynom.add(_polynom.get(i));
			i++;
		}

		while (j<polynom._polynom.size())
		{
			sum._polynom.add(polynom._polynom.get(j));
			j++;
		}			

		return sum;
	}

	/**
	 * minus method-  subtraction of polynomials according to the accepted rules.
	 * using plus method to avoid duplicate code.
	 * @param  polynom  
	 * @return    the subtraction of this polynum by the polynom the method was given
	 * @throws Exception 
	 */
	public Polynom minus(Polynom polynom) throws Exception
	{
		Polynom subtrahend =new Polynom(new double[] {}, new int [] {});
		for (int j=0;j<polynom._polynom.size();j++)
		{
			Monom member=polynom._polynom.get(j);
			subtrahend._polynom.add(new Monom(member.getCoefficient()*(-1),member.getPower()));
		}
		return this.plus(subtrahend);
	}

	/**
	 * derivative method - a method for deriving a polynom.
	 * @return    polynom's derivative
	 * @throws Exception 
	 */
	public Polynom derivative() throws Exception
	{
		System.out.print("("+this.toString()+")' = ");
		Polynom derivative =new Polynom(new double[] {}, new int [] {});
		for (int i=0;i<_polynom.size();i++)
		{
			Monom member=_polynom.get(i);
			derivative._polynom.add(new Monom(member.getCoefficient()*member.getPower(),member.getPower()-1));
		}
		return derivative;
	}

	/**
	 * toString method - returns a string in the usual form of polynom.
	 * @return    polynom as a string
	 */
	public String toString()
	{
		String polynomRepresentation = "";
		for (int i=0;i<_polynom.size();i++)
		{
			Monom member=_polynom.get(i);
			if(member.getCoefficient()!=0)
			{
				if(member.getCoefficient()>0 && i>0)
					polynomRepresentation+="+";
				if(member.getCoefficient()==-1 && member.getPower()>0)
					polynomRepresentation+="-";
				else if ((Math.abs(member.getCoefficient()) != 1) ||
						(Math.abs(member.getCoefficient()) == 1 && member.getPower() == 0))
					polynomRepresentation+=member.getCoefficient();
				if(member.getPower()==1)
					polynomRepresentation+="x";
				else if(member.getPower()>1)
					polynomRepresentation+="x^"+member.getPower();
			}			
		}
		if (polynomRepresentation.equals(""))
			polynomRepresentation+=0;
		return polynomRepresentation;
	}

	/**
	 * equals method - checks if a polynom received as a parameter is equal to the polynom
	 * on which the method was run
	 * @param  Object  polynom
	 * @return    true if if their members are equal, otherwise false
	 */
	public boolean equals (Object object)
	{
		if(object==null || !(object instanceof Polynom))
			return false;

		Polynom polynom=(Polynom)object;

		if (_polynom.size() != polynom._polynom.size())
			return false;

		int i=0,j=0;
		while (i<_polynom.size() && j<polynom._polynom.size())
		{
			Monom member1=_polynom.get(i);
			Monom member2=polynom._polynom.get(j);

			if(member1.getPower()!=member2.getPower() || member1.getCoefficient()!=member2.getCoefficient())
				return false;
			else {
				i++;
				j++;
			}
		}
		return true;
	}
}