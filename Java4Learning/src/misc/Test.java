package misc;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		System.out.println("Ajai Test Java 8 ");
		int[] ajai = {2,3,5,9,10,8};

	     System.out.println("Java Version :: "+ System.getProperty("java.version") );
		 
	     System.out.println("4114758%200  ==> " + (4114758%200));
	     System.out.println("4114758/200  ==> " + (4114758/200));
	     System.out.println("2*2  ==> " + (2*2));
		 List<Integer> iajai = Arrays.stream(ajai).boxed().collect(Collectors.toList());
		System.out.println(iajai.toString());
		iajai.forEach(i->System.out.println("Print : "+i));
		
		int[] ints = {1, 2, 3};
		List<Integer> intList = new ArrayList<Integer>(ints.length);
		for (int i : ints)
		{
		    intList.add(i);
		}
		System.out.println(intList.toString());
		
		System.out.println(ajai.hashCode());
		
		int _test = 123_456;
		System.out.println(_test);
		
		System.out.println(25/2);
		System.out.println(25%2);
		
	}
	

}
//practice 