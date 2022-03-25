package codetest;

import java.util.Arrays;

/*******************************************************

You are given an array of 0s and 1s in random order. 
Segregate 0s on left side and 1s on right side of the array [Basically you have to sort the array]. 
Traverse array only once. 

Input array   =  [0, 1, 0, 1, 0, 0, 1, 1, 1, 0] 
Output array =  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1] 

 ******************************************************/

public class Segregate0and1 {

	public static void main(String[] ajai)
	{
		//System.out.println("Ajai");
		final int inputArray[] = new int[] { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0 }; 
		//System.out.print("Input: [");Arrays.stream(inputArray).forEach(i-> System.out.print(i + " "));System.out.print("]");
		
		System.out.println("***** Segregation by counting 1 and 0 *****");
		System.out.print("Input: "+ formatArray(inputArray,  inputArray.length));
		int outputArray[] = segregate0and1ByCounting(inputArray, inputArray.length);
		//System.out.print("Output: [");Arrays.stream(inputArray).forEach(i-> System.out.print(i + " "));System.out.print("]");
		System.out.print("\nOutput: "+ formatArray(outputArray,  outputArray.length));
		
		System.out.println("\n\n***** Segregation using sort() function *****");
		System.out.print("Input: "+ formatArray(inputArray,  inputArray.length));
		int outputArray1[] = segregate0and1ByCounting(inputArray, inputArray.length);
		System.out.print("\nOutput: "+ formatArray(outputArray1,  outputArray.length));

		System.out.println("\n\n***** Segregation using Swapping *****");
		System.out.print("Input: "+ formatArray(inputArray,  inputArray.length));
		int outputArray2[] = segregate0and1BySwap(inputArray, inputArray.length);
		System.out.print("\nOutput: "+ formatArray(outputArray2,  outputArray.length));

		System.out.println("\n\n***** Segregation using Swapping 1 *****");
		System.out.print("Input: "+ formatArray(inputArray,  inputArray.length));
		int outputArray3[] = segregate0and1BySwap1(inputArray);
		System.out.print("\nOutput: "+ formatArray(outputArray3,  outputArray.length));

	}
	//1. Take two pointer 
		//type0(for element 0) starting from beginning (index = 0) and 
		//type1(for element 1) starting from end (index = array.length-1). 
	//Initialize type0 = 0 and type1 = array.length-1 
	//2. It is intended to Put 1 to the right side of the array. Once it is done, then 0 will definitely towards the left side of the array.
	
	static int[] segregate0and1BySwap1(int inputArr[]) {
		int outputArray[] = inputArr.clone();
        int type0 = 0;
        int type1 = outputArray.length - 1;
         
        while (type0 < type1) {
            if (outputArray[type0] == 1) {
                // swap
            	outputArray[type1] = outputArray[type1]+ outputArray[type0];
            	outputArray[type0] = outputArray[type1]-outputArray[type0];
            	outputArray[type1] = outputArray[type1]-outputArray[type0];
                type1--;
            } else {
                type0++;
            }
        }
        
        return outputArray;
 
    }
	
	//Approach 3: Maintain the left pointer and swap with the position of the left when zero found in the array and increment the left pointer.
	//Time Complexity O(n)
	public static int[] segregate0and1BySwap(int inputArr[], int n)
	{
		int outputArray[] = inputArr.clone();

	    // Maintaining left pointer
        int left = 0;
 
        // Iteration over array using length function
        for (int i = 0; i < outputArray.length; ++i) {
        	
        	//System.out.println("\n FIRST " +formatArray(outputArray,  outputArray.length)); //for debugging
            // If zeros are present
            if (outputArray[i] == 0) {
 
            	//System.out.println("Inside....");
                // Swap the elements using
                // temporary variable
                int temp = outputArray[left];
                outputArray[left] = outputArray[i];
                outputArray[i] = temp;
 
                // Pre incrementing left pointer
                ++left;
                
                //System.out.println(" i -> "+ i +" : left : "+ left + " ==> "+ formatArray(outputArray,  outputArray.length)); //for debugging
            }
        }
        
        //System.out.println("LAST:  "+formatArray(outputArray,  outputArray.length)); //for debugging
		return outputArray;
	}		
	
	//Approach 2: Using sort() function
	//Time Complexity O(nlongn)
	public static int[] segregate0and1BySort(int inputArr[], int n)
	{
		int outputArray[] = inputArr.clone();
		Arrays.sort(outputArray);
		return outputArray;
	}	
	
	//Approach 1: Using segregation by counting 
	//1. Count the number of 0s.
	//2. Traversing over the whole array for looking out indices where zeros are present
	//3. Maintaining a count and incrementing as 0 appears
	//4. Print all zeros to the front
	//5. The remaining number of 1s will be 1- (total number of 0s)
	//6. Print the remaining elements
	
	//Time Complexity: O(n)
	public static int[] segregate0and1ByCounting(int inputArr[], int n)
	{
		int outputArray[] = inputArr.clone();
	    // Counts the no of zeros in array
        int count = 0;
 
        // Iteration over array
        for (int i = 0; i < n; i++) {
            if (outputArray[i] == 0)
                count++;  // Incrementing the count
        }
 
        // Loop fills the arr with 0 until count
        for (int i = 0; i < count; i++)
        	outputArray[i] = 0;
 
        // Loop fills remaining arr space with 1
        for (int i = count; i < n; i++)
        	outputArray[i] = 1;
		
        return outputArray;
	}
	

    static String formatArray(int arr[], int n)
    {
    	StringBuilder sbr= new StringBuilder("[");

    	for (int i = 0; i < n; ++i)
    		sbr.append(arr[i] + " ");
        
    	sbr.append("]");
    	
    	return sbr.toString();
    }	

}
