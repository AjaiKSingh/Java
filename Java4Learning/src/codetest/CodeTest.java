package codetest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.IntStream;

public class CodeTest {

	//Main
	public static void main(String[] args) {
		
		//CodeTest oCodeTest = new CodeTest();

		multiply();
		
		System.out.println(Math.exp(Math.log(100)));
		System.out.println(Math.exp(Math.log(100)));
		
		get2Sum();
		fizzBuzz(30);
		
		printReverse("Ajai Singh");
		
		int atPosition = 10;
		System.out.println("Fibo at "+atPosition+" --> " + fiboForNumber(atPosition));
		
		System.out.println("**************Substring count******************");
			countStringOccurance("MyTestMyFoundMyLocation", "My");
		System.out.println("********************************");
		
		System.out.println("**************Find all elements in an array that are greater than all elements to their right******************");
		int[] arr = { 10, 4, 6, 3, 5 };
		findArray(arr);
		System.out.println("\n********************************");

	}
	
/*
	 Find all elements in an array that are greater than all elements to their right
	 Input array [10, 4, 6, 3, 5]. 
	 Output: 10,6,5 
	 The elements that are greater than all elements to their right are 10, 6, and 5.

	 E.g. o(n) - start from right -> define var max -> 
	 			5 -> Max: 5 -> Output
	 			3 -> 3 > 5 : No: 
	 			6 -> 6>5 : Yes : Max(6) -> output
	 			4 -> 4>6 : NO
	 			10-> 10>6 : Yes : max(10) -> output
	 
	 A better solution is to use a stack. 
	 For each element, pop all the elements present in the stack that are less than it and then push it into the stack. 
	 Finally, the stack is left with the elements which are greater than all elements present to their right.
*/
	
	private static void findArray(int[] arr) {
		System.out.print("\nOriginal: ");
		Arrays.stream(arr).forEach(str -> System.out.print(str+" "));
		//IntStream stream = Arrays.stream(arr);
		//stream.forEach(str -> System.out.print(str + " "));
		
		int maxValue = arr[arr.length-1];
		StringBuilder resultValue = new StringBuilder();
		resultValue.append(maxValue);
		for (int i = arr.length-1;i>=0;i--)
		{
			if(arr[i] > maxValue)
			{
				resultValue.append(" , "+arr[i]);
				maxValue = arr[i];
			}
			else{}
		}
		System.out.println("\nResult with array : "+resultValue.toString());
		
		
		//2. Stack implementation
		Stack<Integer> stack = new Stack<>();
		for(int value:arr)
		{
			// pop all the elements that are less than the current element
            while (!stack.isEmpty() && stack.peek() < value) {
                stack.pop();
            }
 
            // push current element into the stack
            stack.push(value);			
		}
        // print all elements in the stack
		System.out.print("Result with Stack : ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
	}

	//Reverse String
	private static void printReverse(String string) {
		System.out.println("Original String -> "+string);
		
		//1. using string builder reverse API
			StringBuilder stbString = new StringBuilder(string);
			System.out.println("Reversed String is (API) -> " + stbString.reverse().toString());
			
		//2. without API: manually
			//toCharArray
			char[] stringCharArray = string.toCharArray();
			System.out.print("Reversed String is (Char Array) -> ");
	        for (int i = stringCharArray.length - 1; i >= 0; i--)
	            System.out.print(stringCharArray[i]);
		
	        StringBuilder stbnew = new StringBuilder();
	        System.out.println();
	        for(int i=string.length();i>0;i--)
	        {
	        	stbnew.append(string.charAt(i-1));
	        }
	        System.out.println("Reversed String (charAt)  -> " +stbnew.toString());
	}


	/**
	 * Multiply
	 */
	public static void multiply()
	{
		//Multiply numbers from array ****************
		int[] ajai = {2,3,5,9,10,8};
		double result = 0;
		Long resultByExplicitMulitplying = 1L;
		for(int i=0; i<ajai.length; i++){
			result = result + Math.log(ajai[i]);//one way to get the multiplication result
			resultByExplicitMulitplying = resultByExplicitMulitplying*ajai[i];
		}
		System.out.println("Using Log/exp ::: " + Math.round(Math.exp(result))); // logX+logY = log(X*Y);
		System.out.println("With Multiplicaction operator ::: "+resultByExplicitMulitplying); //explicit mulitply
		 
		//**********************************************		
	}
	
	/*
	Challenge: 
		Given an array and an expected sum, you are required to find the index of the two numbers 
		in the array whose sum adds up to the number
	
	E.g.
	 	array = [1,2,3,4] 
		target/sum: 6
		rerun [1,3], because array[1] = 2, array[3] = 4 => 2+4= 6
	
	Questions/Assumptions:
	1. distinct numbers
	2. one solution or multiple solutions
	3. sum of 2 no
	4. in case of no result, return some message
	*/
	
	/*
	loop in nested
	 for j=0..n
	   for j=1 ..n-1
	      array[i]+array[j] = sum -> check
	
	this above is time consuming O(n2)
	
	Another approach:
	map1 = initialize .. map <key,value>
	for i=0...n
	  diff/delta = sum-array[i]
	  if map1 contains diff
	  	return [i,map1(diff).value]
	  map1.put(array[i],i)
	*/ 
	public static void get2Sum()
	{
		int[] num = {2,3,5,9,1,8}; 
		int sum = 13; //[2=>5,5=>8] ===> 5+8 = 13
		sum=17;
		System.out.println("Input Array ::"+ Arrays.toString(num));
	    // In Java 8 we have lambda expressions
	    Arrays.stream(num).forEach(System.out::print);
		
		System.out.println("\nTarget ::"+ sum);
		Map<Integer, Integer> iteratedNumber = new HashMap<>();
		boolean isFound = false;
		for(int i =0; i<num.length;i++)
		{
			int diff = sum-num[i];
			System.out.println("Value :: "+num[i] + "  Delta :: "+diff);
			
			if (iteratedNumber.containsKey(diff)) {
				System.out.println("Result : [" + i +" , " + iteratedNumber.get(diff)+"]");
				isFound = true;
				return;
			}
			else
			{
				iteratedNumber.put(num[i], i);
			}
		}
		if(!isFound)
			System.out.println("Not Found...");
		
	}
	
	public static void fizzBuzz(int number)
	{
		/*
			Write a short program that prints each number 1 to 100 ona new line
			For each multiple of 3, print "Fizz" instead of number
			For each multiple of 5, print "Buzz" instead of number
			For numbers which are multiplies by 3 and 5 both, print "FizzBuzz" instead of number.
			
			Rules of the FizzBuzz Game
			The rules of the FizzBuzz game are very simple.
			
			Say Fizz if the number is divisible by 3.
			Say Buzz if the number is divisible by 5.
			Say FizzBuzz if the number is divisible by both 3 and 5.
			Return the number itself, if the number is not divisible by 3 and 5.			 
		 */

		//int number = 15; //upper limit

		//1: by looping and if..else condition
			for (int i=1; i<=number; i++) {
				
				System.out.print(i%3==0? (i%5==0 ? "FizzBuzz ":"Fizz "):(i%5==0? "Buzz ":i+" " ));
				
				
//				if(i%3==0 && i%5==0)
//				{
//					System.out.println("FizzBuzz");
//				}
//				else if(i%3==0)
//					System.out.println("Fizz");
//				else if(i%5==0)
//					System.out.println("Buzz");
//				else
//					System.out.println(i);
				
				//System.out.println("\n");
			}
				
			System.out.println("");
		//2. using java 8 feature : IntStream
			//the rangeClosed() method returns a sequential IntStream for the specified range of int elements  
			//for-each iterate over the Stream and prints the elements   
			IntStream.rangeClosed(1, number)
						.mapToObj(i->i%3==0?(i%5==0? "FizzBuzz ":"Fizz "):(i%5==0? "Buzz ": i+" "))
						.forEach(i->System.out.print(i));  
		
	}
	
	//Nth number of fibonacci series
	private static int fiboForNumber(int atPosition)
	{
		//0,1,1,2,3,5,8,13,21,... (number is sum of previous 2 numbers)
		if(atPosition <=1)
			return 1;
		return fiboForNumber(atPosition-1)+fiboForNumber(atPosition-2);
	}
	

	/*
	1. Substring counter problem (find the count of substring with in a string without using inbuild functions) - [Morgan Stanley 8+)
	Given an input string and a substring. Find the frequency of occurrences of a substring in a given string.
	Input:
		String str = "abcxyzabcefgabc";
		String toFind = "abc";
	Output: 3
	 */
	private static void countStringOccurance(String source, String subString)
	{
		int count = 0;
		
		System.out.println("Input \n Source String: " + source + "\n Sub String to find: " + subString );
		System.out.println("\nOutput: ");
		
		//java8
				
		
		//with replace
			//1. replace the substring with single space
			//2. now u get the string without any occurance of substring, get the legth
			//3.difference of length is the count devided by length of subString
			String sourceAfterSubStringReplacementWithSpace = source.replace(subString, "");
			System.out.println(" Replaced String: "+sourceAfterSubStringReplacementWithSpace);
			count = (source.length() - sourceAfterSubStringReplacementWithSpace.trim().length())/(subString.length());
			System.out.println(" Count using Replace: "+ count);
		
		//Using indexOf
			//1. Find the index of substring
			//2. Loop till the index is found by updating the start index
			int lastIndex = 0;
			count = 0;
			while (lastIndex != -1)
			{
				lastIndex = source.indexOf(subString, lastIndex);
				if(lastIndex != -1)
				{
					count++;
					lastIndex = lastIndex+subString.length();
				}
			}
			System.out.println(" Count using indexOf: "+ count);
		
		
	}

}
