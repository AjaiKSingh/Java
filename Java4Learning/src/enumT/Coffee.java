package enumT;

public class Coffee 
{
	CoffeeSize size;

	public static void main(String[] args) 
	{
		Coffee drink1=new Coffee();
		drink1.size=CoffeeSize.BIG;
		
		Coffee drink2=new Coffee();
		drink2.size=CoffeeSize.HUGE;
		
		Coffee drink3=new Coffee();
		drink3.size=CoffeeSize.OVERWHELMING;
		

		System.out.println("Big Coffee size is : "+drink1.size.getOunces()+ "\t Lid Code is : "+drink1.size.getLidCode());
		System.out.println("Huge Coffee size is : "+drink2.size.getOunces()+ "\t Lid Code is : "+drink2.size.getLidCode());
		System.out.println("Overwhelming Coffee size is : "+drink3.size.getOunces()+ "\t Lid Code is : "+drink3.size.getLidCode());
		

	}
}

