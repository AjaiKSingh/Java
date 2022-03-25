package misc;

import java.util.ArrayList;
import java.util.List;

public class BasicTest2 {

	int a= 10;
	int x =10;
	
	public static void main (String abc[])
	{
//		int []a= {1,2,3,4,5,6};
//		int i = a.length-1;
//		while (i>=0)
//		{
//			System.out.println(a[i]); //654321
//			i--;
//		}
		
		
//		int x=0,y=10;
//		try
//		{
//			y/=x;
//		}
//		System.out.println("/ by 0"); //compile error
//		catch(Exception e)
//		{
//			System.out.println("Error");	
//		}
		
//		int []a= {1,2,3,4,5,6};
//		System.out.println(a instanceof Object); //true

//		int []a= {1,2,053,4};
//		int b[][] = {{1,2,4},{2,2,1},{0,43,2}};
//		System.out.print(a[3]==b[0][2]);
//		
//		System.out.print(a[2]); //43
//		System.out.print(b[2][1]); //43
//		
//		System.out.print(" " + (a[2]==b[2][1]));
//		
//		int x = 053; //octal value : 43
//		System.out.print(x); //43
		
//		int x = 2_43, y = 0_53; 
//		System.out.println(x); //243
//		System.out.println(y); //43 -> 5*8+3 => 43
		

//		int [][] a = new int [3][];
//		a[1]=new int [] {1,2,3};
//		a[2]=new int [] {4,5};
//		System.out.println(a[1][1]); //2
		
		//The only allowed characters for identifiers are all alphanumeric characters([A-Z],[a-z],[0-9]), '$'(dollar sign) and '_' (underscore). 
		//For example “geek@” is not a valid java identifier as it contain '@' special character. Identifiers should not start with digits([0-9]).
//		String $ = "test";
//		String getSize = "test";
//		String @name = "test"; //invalid
//		String 1stName = "test"; //invalid
//		String _4_ = "test";
		
//		new BasicTest2().print(); //8
		
//		for (int x=0;x<5;x++)
//		{}
//		System.out.println(x); //Unresolved compilation problem: Cannot make a static reference to the non-static field x

//		Person p1= new Person("John",22);
//		BasicTest2 b = new BasicTest2();
//		Person p2= b.change(p1);
//		System.out.println(p2.pid + ":"+p2.name +":"+p2.age); //1:John:25
//		System.out.println(p1.pid + ":"+p1.name +":"+p1.age); //1:John:25

//		int x =10;
//		int y = new BasicTest2().change(x);
//		System.out.println(x+y); //22
		
//		String s = "Java";
//		s.concat(" SE 7"); //assignment is not done // new staring every time
//		s.replace('7','8');
//		System.out.println(s); //Java

//		String s = "Java";
//		s.concat(" SE 7"); //assignment is not done // new staring every time
//		s.toLowerCase();
//		System.out.println(s); //Java
		
//		StringBuilder sb = new StringBuilder(5);
//		String s="";
//		if(sb.equals(s)) System.out.println("Match1");
//		else if (sb.toString().equals(s.toString())) System.out.println("Match2");
//		else System.out.println("No Match");
		
		
//		List<String> colors = new ArrayList<String>();
//		colors.add("green");
//		colors.add("red");
//		colors.add("blue");
//		colors.add("yellow");
//		System.out.println(colors);
//		colors.remove(2);
//		System.out.println(colors);		
//		colors.add(3,"cyan");
//		System.out.println(colors);
		
//		String str1="Java";
//		String str11="Java";
//		
//		String[] str2= {"J","a","v","a"};
//		
//		System.out.println(str1.hashCode() + " -- " + str11.hashCode()+ " -- " + str2.hashCode());
//		
//		String str3="";
//		for(String str:str2)
//		{
//			str3=str3+str;
//		}
//		System.out.println(str3 +" -- " + str3.hashCode());
//		System.out.println(str1==str3);
//		System.out.println(str1.equals(str3));

//		ArrayList list = new ArrayList();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		System.out.println(list); //[1, 2, 3, 4]
//		list.add(null);
//		System.out.println(list); //[1, 2, 3, 4, null]
//		list.remove(2);
//		System.out.println(list); //[1, 2, 4, null]
//		list.remove(null);
//		System.out.println(list); //[1, 2, 4]

//		String[] names = {"Thomas","Peter","Joseph"};
//		String pwd[]=new String[3];
//		
//		int idx=0;
//		
//		try
//		{
//			 System.out.println("hamburger".substring(4, 8));  //urge
//		     System.out.println("smiles".substring(1, 5) ); //mile
//			for(String n:names)
//			{
//				System.out.println(n + " : : ");//;+n.substring(2,6)); //Thomas : : omas
//				pwd[idx]=n.substring(2,6);
//				System.out.println(idx + " : : "+pwd[idx]); //0 : : omas
//				idx++;
//			}
//		}
//		catch(Exception e)
//		{
//			System.out.println("Invalid name ... " + e.getMessage()); //Invalid name ... String index out of range: 6
//		}
//		
//		for(String n:pwd)
//		{
//			System.out.println(n); //	omas null null
//		}

//		int x = 010; //octal value : 8
//		System.out.print(x); //
//		x=07;
//		System.out.print(x);
		
		System.out.println("Ajai".format("%07d", 1));
		
		
	}
	
	int change(int x)
	{
		x=12;
		return x;
	}
	public void pass()
	{
		int a = 10,b=20;
		print(a);
	}
	
	public void print(int a)
	{
//		int c = b/a; //compilation error
//		System.out.println(c);
	}
		
	public void print()
	{
		int a = 8;
		System.out.println(a+" ");
	}
	
	private Person change(Object o)
	{
		Person p2=(Person)o;
		p2.age=25;
		return p2;
	}
}

class Person
{
Person(String s, int i)
{
	++pid;
	name=s;
	age=i;
}
static int pid;
int age;
String name;
}