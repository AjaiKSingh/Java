package j8.stream;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Testing {

	public static void main(String aj[])
	{
		int[] arr = {3,2,2,4,1,5,7,3};
	
		//pick unique elements
		
		//square them in natural order (ascending(default))
		Arrays.stream(arr).distinct().map(i -> i*i).sorted().forEach(i -> System.out.println(i));
		//sort them
		//Arrays.stream(arr).sorted().forEach(i -> System.out.println(i));
		//print in the console
		//Arrays.stream(arr).forEach(i -> System.out.println(i));
		//using java 8 streams
		System.out.println("***************");
		Arrays.asList(arr).stream().forEach(System.out::println);//[I@404b9385
		
		System.out.println("***************");
		Arrays.asList(3,2,2,4,1,5,7,3).stream().forEach(System.out::print);//3 2 2 4 1 5 7 3	
		
		System.out.println("\n***************");
		Arrays.asList(3,2,2,4,1,5,7,3).parallelStream().forEach(System.out::print);//5 7 3 3 2 2 4 1
		
		System.out.println("\n***************");
		int chararcter='a';//a: 97 A: 65
		System.out.println(chararcter);
		
		/*
		 Input: Stream = [A, j, a, i, s]
		 Output: [0 -> A, 1 -> j, 2 -> a, 3 -> i, 4 -> s]

		 */
		System.out.println("\n***************");
		String[] inputArray = {"A", "j", "a", "i", "k", "u", "m", "a", "r", "S", "i", "n", "g", "h"};
		
		IntStream.range(0, inputArray.length)
				.mapToObj(index->String.format("%d -> %s , ",index, inputArray[index]))
				.forEach(System.out::print);
		
		System.out.println("\n***************");
		IntStream.range(0, inputArray.length)
					.forEach(index-> System.out.println(index + " -> "+ inputArray[index]));
		
		System.out.println("\n***************");
		Stream.iterate(0, n->n+1)
				.limit(inputArray.length)
				.forEach(index-> System.out.println(index + " -> "+ inputArray[index]));
				
		
		System.out.println("\n***************");
		for (int i=0; i<inputArray.length;i++)
			System.out.println(i + " -> "+ inputArray[i]);
		
		System.out.println("\n*************** Multi-D Array");
		int[][] mArray = {{1,3},{2,4},{3,5},{4,6},{5,7},{6,8},{7,9},{8,10}};
		Arrays.stream(mArray).forEach(i->System.out.print(i + " : " +  (i.hashCode())));
		System.out.println("\n***************");
		Arrays.stream(mArray).flatMapToInt(Arrays::stream).forEach(System.out::println);
		
		
		System.out.println("\n***************");
		for(int value:arr)
			System.out.print(value + " "); //3 2 2 4 1 5 7 3 
	}
}
