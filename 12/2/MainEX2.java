/**
 * class Main declare an array of different types of bank accounts and performs relevant actions on them.
 * @author Noga Amiel
 * @version 23.12.23
 */
public class MainEX2 {

	public static void main(String[] args) throws IllegalBalance {
		BankAccount[] bankAccounts=new BankAccount[17];
		bankAccounts[0]=new ServiceChargeChecking("000001", "Israel Israeli", "256890741", 150000);
		bankAccounts[1]=new NoServiceChargeChecking("000004", "Elia Peretz", "512326021", 20);
		bankAccounts[2]=new InterestChecking("000005", "Daniel Perez", "415680978",100000);
		bankAccounts[3]=new SavingsAccount("000007", "Daniela Mor", "745153007",750);
		bankAccounts[4]=new HighInterestSavings("000009", "Dima Talker", "451412323", 8000);
		bankAccounts[5]=new ServiceChargeChecking("000001", "Israel Israeli", "256890741", 150000);
		bankAccounts[6]=new NoServiceChargeChecking("000004", "Elia Peretz", "512326021", 20);
		bankAccounts[7]=new InterestChecking("000005", "Daniel Perez", "415680978",10000000);
		bankAccounts[8]=new SavingsAccount("000012", "Keren Heart", "454547807",750);
		bankAccounts[9]=new HighInterestSavings("000013", "Dima Talker", "451412323", 8000,200);
		bankAccounts[10]=new ServiceChargeChecking("000002", "Israela Israeli", "256890952", 899000,10);
		bankAccounts[11]=new NoServiceChargeChecking("000003", "Elia Peretz", "512326021", 200,100);
		bankAccounts[12]=new InterestChecking("000006", "Sara Lopez", "693248074",10000000,0.01);
		bankAccounts[13]=new SavingsAccount("000008", "Michael Levin", "475893657",75000,0.02);
		bankAccounts[14]=new HighInterestSavings("000010", "Alex Neski", "369747777", 8000,20,0.7);
		bankAccounts[15]=new HighInterestSavings("000011", "Dima Talker", "451412323", 8000,200,0.05);
		bankAccounts[16]=new HighInterestSavings("000011", "Dima Talker", "451412323", 8000,200,0.05);

		
		for(int i=0;i<bankAccounts.length;i++)
		{
			System.out.println(bankAccounts[i]);
		}
		
		for(int i=0;i<bankAccounts.length;i++)
		{
			System.out.println("bank account info: "+bankAccounts[i]);
			bankAccounts[i].deposit(50);
			System.out.println("after deposit of 50: "+bankAccounts[i]);
			bankAccounts[i].withdrawal(100);
			System.out.println("after withdrawal of 100: "+bankAccounts[i]);
			bankAccounts[i].monthlyManagement();
			System.out.println("after monthly management of 100: "+bankAccounts[i]);
			System.out.println("");
		}		
	}
}
