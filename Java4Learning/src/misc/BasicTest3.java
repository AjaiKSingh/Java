package misc;

public class BasicTest3 {

	public static void main(String[] args) {

        double grade = 80;

        String result;
        
        //this is pass: 
        /* Although the variable result was not initialized, the compiler can ascertain the value 
       		in the if/else block because it includes just an if and else. */
        if (grade >= 70)
            result = "Pass";
        else result = "Fail";
    	 System.out.println(result);
 
        //This is compile error : 
        //The variable result was not initialized. As a result, the if/else block cannot determine the value. This causes the compilation to fail.
//        if (grade >= 70)
//            result = "Pass";
//        else if (grade < 70)
//            result = "Fail";
//        
//        System.out.println(result);
    	 
    	 double x;
         x = 1.0*(2.0+3.0)/4.0-1.0;
         System.out.println(x);
	         //Arithmetic expressions are evaluated from left to right.
	         //Multiplication and division are executed first, followed by addition and subtraction. 
	         //However, parentheses take precedence. In this case, (2.0+3.0) is evaluated first as 5.0. 
	         //Then (1.0*5.0), which results in 5.0, and then (5.0/4.0), which results in 1.25, and finally (1.25-1.0), which results in 0.25.
	         
         //int a[][] = new int [][4];
	         /*The [] notation can be placed both after the type name and after the variable name in an array declaration. 
	         Multidimensional arrays are created by constructing arrays that can contain references to other arrays. 
	         The expression new int[4][] will create an array of length 4, which can contain references to arrays of int values. 
	         The expression new int[4][4] will also create a two-dimensional array, but will in addition create four more one-dimensional arrays, 
	         each of length 4 and of the type int[]. References to each of these arrays are stored in the two-dimensional array. 
	         The expression int[][4] will not work, because the arrays for the dimensions must be created from left to right.*/
	         
        
	}

}

