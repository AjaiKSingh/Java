package enumT;

/*
You can NEVER invoke an enum constructor directly. The enum constructor
is invoked automatically, with the arguments you define after the constant
value. For example, BIG(8) invokes the CoffeeSize constructor that takes
an int, passing the int literal 8 to the constructor. (Behind the scenes, of
course, you can imagine that BIG is also passed to the constructor, but we
don't have to know—or care—about the details.)


*/
public enum CoffeeSize 
{
	BIG(8),
	HUGE(10){
	public String getLidCode()
		{
			return "C";
		}
	},
	OVERWHELMING(16){
		public String getLidCode()
		{
			return "A";
		}
	};
	CoffeeSize(int ounces)
	{
		this.ounces=ounces;
	}
	public int getOunces()
	{
		return this.ounces;
	}
	public String getLidCode()
	{
		return "B";
	}
	private int ounces;
}
