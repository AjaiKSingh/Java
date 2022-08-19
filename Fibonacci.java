package codetest;

import java.util.Arrays;

//0,1,1,2,3,5,8,13,21,... (number is sum of previous 2 numbers)
//741 ms vs 0 ms (nonDP vs DP)
/**
This code shows the difference in time complexity while fetching Nth fibonacci number using recursion and Dynamic programing.
*/
public class Fibonacci {

	public static void main(String ajai[]) {
		int nthFib = 40; // >=0
		
		long startTime,endTime,answer=0;
		
		startTime = System.currentTimeMillis();
		answer = fiboForNumber(nthFib);
		endTime = System.currentTimeMillis();
		System.out.println(" Value (wo DP -> " + answer);
		System.out.println(" Time Taken -> " + (endTime - startTime) + " milli seconds");

		long fiboCache[] = new long[nthFib];
		Arrays.stream(fiboCache).forEach(i -> System.out.print(i + " "));
		
		startTime = System.currentTimeMillis();
		answer = fiboForNumber(nthFib, true,fiboCache);
		endTime = System.currentTimeMillis();
		System.out.println(" Value (w DP) -> " + answer);
		System.out.println(" Time Taken -> " + (endTime - startTime) + " milli seconds");
		Arrays.stream(fiboCache).forEach(i -> System.out.print(i + " "));

	}

	/**
	 * @param atPosition
	 * @return
	 */
	private static long fiboForNumber(int atPosition) {
		return fiboForNumber(atPosition, false, null);
	}

	private static long fiboForNumber(int atPosition, boolean caching, long fiboCache[]) {

		if (atPosition <= 1)
			return 1;
		else
		{
			if (caching) {
				if (atPosition <= 1)
					return 1;
				else {
					if (fiboCache[atPosition-1] != 0) // check if already cached -> return from cache
						return fiboCache[atPosition-1];
					else // else calculate and cache and return
					{
						fiboCache[atPosition-1] = fiboForNumber(atPosition - 1, true,fiboCache) + fiboForNumber(atPosition - 2, true,fiboCache);
						return fiboCache[atPosition-1];
					}
				}
			} else
			{
				return fiboForNumber(atPosition - 1) + fiboForNumber(atPosition - 2);
			}
		}
	}

}
