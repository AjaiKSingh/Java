package misc;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class CPUCores {
	public static void main(String ajai[])
	{
		int noOfCores = Runtime.getRuntime().availableProcessors();
		System.out.println("No of CPU Cores ->"+noOfCores); //8
		
		String[] myArray = {"Mike","Steve","Lambda","Tony","Karen","Mike1","Steve1","Lambda1","Tony1","Karen1"};
		List<String> myList = Arrays.asList(myArray);
		
		myList.parallelStream().forEach(System.out::println);
		
		System.out.println("**************************");
		myList.stream().sorted().forEach(System.out::println);
		System.out.println("**************************");
		Arrays.stream(myArray).filter(i->i.startsWith("M")).forEach(System.out::println);
		
		ForkJoinPool corePools = ForkJoinPool.commonPool();
		int maxParallelProcess = corePools.getParallelism();
		int poolSize = corePools.getPoolSize();
		int activeThreadCount = corePools.getActiveThreadCount();
		
		System.out.println("**************************");
		System.out.println("Core -> other than main ->" + maxParallelProcess); //7
		System.out.println("poolSize ->" + poolSize); //7
		System.out.println("activeThreadCount ->" + activeThreadCount); //0
		
		int i = 10;
		int j = 10_100;
		System.out.println(i+j);
		
	}
}

