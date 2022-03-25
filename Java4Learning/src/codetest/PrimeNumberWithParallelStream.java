package codetest;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/***********************
 * @author AJAISING
 * 
 *         Prime number is a number that is greater than 1 and divided by 1 or
 *         itself only. In other words, prime numbers can't be divided by other
 *         numbers than itself or 1. For example 2, 3, 5, 7, 11, 13, 17.... are
 *         the prime numbers.
 * 
 *         Note: - 0 and 1 are not prime numbers. - The 2 is the only even prime
 *         number because all the other even numbers can be divided by 2.
 * 
 ****************************************/
public class PrimeNumberWithParallelStream {

	public static void main(String[] args) {

		int noOfCores = Runtime.getRuntime().availableProcessors();
		ForkJoinPool corePools = ForkJoinPool.commonPool();

		// Without Stream
		checkPrime(1);
		checkPrime(3);
		checkPrime(17);
		checkPrime(20);
		
		int num=33;
		System.out.println(num + (isPrime(num)? " is a ": " is not a ") + "prime number");
		num=31;
		System.out.println(num + (isPrime(num)? " is a ": " is not a ") + "prime number");
		
		long startTime,endTime;
		startTime = System.currentTimeMillis();
		
		IntStream.rangeClosed(2,10)
					.parallel()
					.forEach(n->System.out.println(n + (isPrime(n)? " is a ": " is not a ") + "prime number"));//Total execution time: 5645
		
		endTime = System.currentTimeMillis();
		System.out.println("Parallel : Total execution time: " + (endTime - startTime) + "milisec - "+  (endTime - startTime)/1000 + "sec");

		startTime = System.currentTimeMillis();
		
		IntStream.rangeClosed(2,10)
					.forEach(n->System.out.println(n + (isPrime(n)? " is a ": " is not a ") + "prime number"));//Total execution time: 6686
		
		endTime = System.currentTimeMillis();
		System.out.println("Sequential : Total execution time: " + (endTime - startTime) + "milisec - "+  (endTime - startTime)/1000 + "sec");

		// With Stream
		System.out.println("**************************************");
		int numPrimeJava8=31;
		System.out.println(numPrimeJava8 + (isPrimeJava8(numPrimeJava8)? " is a ": " is not a ") + "prime number");
		
		System.out.println("**************************************");
		startTime = System.currentTimeMillis();
		
		long totalPrimes = Stream.iterate(0, n->n+1)
								.limit(500000)
								.parallel()
								.filter(PrimeNumberWithParallelStream::isPrimeJava8)
								.peek(x->System.out.println(x + " : " + corePools.getParallelism()+ " : " + corePools.getActiveThreadCount()))
								.count();
		
		System.out.println("Total Prime Numbers -> " +  totalPrimes);
		endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) + " milisec - "+  (endTime - startTime)/1000 + " sec");
		//Parallel:
		//Total Prime Numbers -> 41538
		//Total execution time: 11060 milisec - 11 sec
		
		//Sequential:
		//Total Prime Numbers -> 41538
		//Total execution time: 28389 milisec - 28 sec
		
		System.out.println("**************************************");
		int maxParallelProcess = corePools.getParallelism();
		int poolSize = corePools.getPoolSize();
		int activeThreadCount = corePools.getActiveThreadCount();
		
		System.out.println("**************************");
		System.out.println("No of CPU Cores ->"+noOfCores); //8
		System.out.println("Core -> other than main ->" + maxParallelProcess); //7
		System.out.println("poolSize ->" + poolSize); //7
		System.out.println("activeThreadCount ->" + activeThreadCount); //0
	}

	 public static boolean isPrimeJava8(int num) {  
	       if (num <= 1) return false;  
	       boolean isPrimeJava8 = !(IntStream.rangeClosed(2, num/2).anyMatch(i -> num%i == 0));
	       return isPrimeJava8;  
	   }  	
	/*
	Here, note that we are looping from 2 to num/2. It is because a number is not divisible by more than its half.

	Inside the for loop, we check if the number is divisible by any number in the given range (2...num/2).

	If num is divisible, flag is set to true and we break out of the loop. This determines num is not a prime number.
	If num isn't divisible by any number, flag is false and num is a prime number.
	*/
	static void checkPrime(int n) {
		int i, m = 0, flag = 0;
		m = n / 2; //number is not divisible by more than its half
		if (n == 0 || n == 1) {
			System.out.println(n + " is not prime number");
		} else {
			for (i = 2; i <= m; i++) {
				if (n % i == 0) {
					System.out.println(n + " is not prime number");
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				System.out.println(n + " is prime number");
			}
		} // end of else
	}

	 public static boolean isPrime(int n) {  
	       if (n <= 1) {  
	           return false;  
	       }  
	       for (int i = 2; i < Math.sqrt(n); i++) {  
	           if (n % i == 0) {  
	               return false;  
	           }  
	       }  
	       return true;  
	   }  
	 
}
