package misc;

public class BasicTest {

	public static void main(String[] args) {
		System.out.println("*****Basic Test ****");
		
		//byte
			byte x = 1, y=1;
			//byte z = x+y; 
				//Compile error : Type mismatch: cannot convert from int to byte
				//any arithmetic operation on variable type less than int, produces int.
			
			byte z = (byte)(x+y); //2
			System.out.println(z);
			
			x=127;
			z = (byte)(x+y); //-128 ; because addition crossed byte limit and it started circling (-128 to 127)
			System.out.println(z);
			
		//char
			char c = 'a';
			char d = ++c;   //++ or -- operators does not change the type of variable (e.g. here it was + but type was not changed to int)
			
			System.out.println(d); //b
			
			//d = c+1; //type mismatch: cannot convert from int to char
			
			d=(char)(c+1);
			System.out.println(d); //c
			
			
		//float

		//String
			int s1=4, s2=6;
			System.out.println("S1+S2 = "+s1+s2); //S1+S2 = 46     //order of operation is important; here string comes first so it all concatenated
			System.out.println("S1+S2 = "+(s1+s2)); //S1+S2 = 10  // bracket overrides the string concatenation :  int operation
			System.out.println(s1+s2+" S1+S2 = "+s1+s2); //10 S1+S2 = 46
			
		//ifs
			if(s1==4)System.out.println("4444");
			else if (s1==2) System.out.println("2222");
			else if (s1==5) System.out.println("5555");
			else System.out.println("OUT");
			
			
		//
			Employee e1 = new Employee(1,"Emp1");
			Employee e2 = new Employee(1,"Emp2");
			
			System.out.println(e1+"\n"+e2); //Employee [id=1, name=Emp1] //Employee [id=1, name=Emp2]
			System.out.println(e1==e2); // false
			System.out.println(e1.equals(e2)); //true
			
	}

}

class Employee
{
	private int id;
	private String name;
	
	Employee()
	{
		
	}
	Employee(int id, String name)
	{
		this.id=id;
		this.name=name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		return 1;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return ((Employee)obj).id==id;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	
}