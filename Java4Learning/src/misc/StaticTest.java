package misc;

class BaseClass
{
	public static void staticTest()
	{
		System.out.println("I m in : BaseClass");
	}
}
class SubClass extends BaseClass
{
	public static void staticTest()
	{
		System.out.println("I m in : SubClass");
	}
}
public class StaticTest 
{
	static{System.out.println("I m in : StaticTest : Static Block");}
	static void ajai()
	{
		System.out.println("I m in : StaticTest : Static method");	
	}
	public static void main(String[] args) 
	{
		BaseClass base=new SubClass();
		SubClass sub=new SubClass();
				/*SubClass sub1=(SubClass)new BaseClass();
				sub1.staticTest();*/
		base.staticTest();
		sub.staticTest();
		ajai();
	}
}

