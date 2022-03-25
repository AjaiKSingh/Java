package pattern.sigleton;
//https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
public class SingletonTest {

	public static void main(String[] args) {
		System.out.println(EnumSingleton.INSTANCE.hashCode()); //366712642
		System.out.println(EnumSingleton.INSTANCE.hashCode()); //366712642
		
		EnumSingleton singleton = EnumSingleton.INSTANCE;

	        System.out.println(singleton.getValue()); //0
	        singleton.setValue(2);
	        System.out.println(singleton.getValue()); //2
	       
	        EnumSingleton singleton2 = EnumSingleton.INSTANCE;
	        System.out.println(singleton.getValue());//2
	}

}
