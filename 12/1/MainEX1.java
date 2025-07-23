/**
 * class Main uses Polynom class. 
 * Main declare 2 polynoms and performs relevant actions on them.
 * Main assumes the numbers are valid
 * @author Noga Amiel
 * @version 21.12.23
 */
public class MainEX1 
{
	public static void main (String []args) throws Exception
	{
		double[]coefficients1= {1,15.0};
		int []powers1={2,0};
		Polynom p= new Polynom(coefficients1,powers1);

		double[]coefficients2= {8.0,-3.0,-1,7.0};
		int []powers2={3,2,1,0};
		Polynom q= new Polynom(coefficients2,powers2);

		System.out.println("p: "+p);
		System.out.println("q: "+q); 

		System.out.println();

		System.out.print("p+p = ");
		System.out.println(p.plus(p));
		System.out.print("p+q = ");
		System.out.println(p.plus(q));
		System.out.print("q+p = ");
		System.out.println(q.plus(p));
		System.out.print("q+q = ");
		System.out.println(q.plus(q));

		System.out.println();

		System.out.print("p-p = ");
		System.out.println(p.minus(p));
		System.out.print("p-q = ");
		System.out.println(p.minus(q));
		System.out.print("q-p = ");
		System.out.println(q.minus(p));
		System.out.print("q-q = ");
		System.out.println(q.minus(q));

		System.out.println();

		System.out.print("p' = ");
		System.out.println(p.derivative());
		System.out.print("q' = ");
		System.out.println(q.derivative());

		System.out.println();

		System.out.println("p equals p: "+ p.equals(p));
		System.out.println("p equals q: "+ p.equals(q));
		System.out.println("q equals p: "+ q.equals(p));
		System.out.println("q equals q: "+ q.equals(q));
	}
}