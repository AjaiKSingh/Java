package thread;

/***
 * since 1.5
  Java provides two approaches for creating threads one by implementing the Runnable interface and the other by inheriting the Thread class. 
  However, one important feature missing with the implementation of the Runnable interface is that it is not possible for a thread to return 
  something when it completes its execution,   i.e., when the run() method execution is over. 
  
  In order to support this feature, the Java Callable interface is used.
 
  A Future object holds the result obtained from the different thread, which is sent from the call() method.
  
  Just like Callable, Future is also an interface. Therefore, to use it, its implementation is a must. However, we do not have to take the 
  	pain to implement the Future interface. 
  The Java library already has the class called, FutureTask that implements the Runnable as well as the Future interfaces.


  Explanation:
   In the code, we have produced 10 different threads. Each thread invokes the call() method, generates a random number, and returns it. 
   The get() method is used to receive the returned random number object obtained from the different threads to the main thread. 
   The get() method is declared in the Future interface and implemented in the FutureTask class.
  
***/

//A Java program that illustrates Callable  
//to generate and return a random number between 0 - 9  

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.Random;

public class CallableExample 
{
	static int noOfThreads = 50;
	  // main method  
	  public static void main(String argvs[]) throws Exception  
	  {  
	    
	    // FutureTask is the concrete class  
	    // creating an array of 5 objects of the FutureTask class  
	    FutureTask[] randomNoTasks = new FutureTask[noOfThreads];  
	    
	    // loop for spawning 10 threads  
	    for (int j = 0; j < noOfThreads; j++)  
	    {  
	      // Creating a new object of the JavaCallable class  
	      Callable clble = new JavaCallable();  
	    
	      // Creating the FutureTask with Callable  
	      randomNoTasks[j] = new FutureTask(clble);  
	    
	      // Since FutureTask implements Runnable,   
	      // one can create a Thread  
	      // with a FutureTask object  
	      Thread th = new Thread(randomNoTasks[j]);  
	      th.start();  
	    }  
	    
	    // loop for receiving the random numbers  
	    for (int j = 0; j < noOfThreads; j++)  
	    {  
	  
	      // invoking the get() method  
	      Object o = randomNoTasks[j].get();  
	        
	      // The get method holds the control until the result is received  
	      // The get method may throw the checked exceptions  
	      // like when the method is interrupted. Because of this reason  
	      // we have to add the throws clause to the main method  
	        
	       // printing the generated random number  
	      System.out.println("The random number is: " + o);  
	  
	    }  
	  }  
	}  

class JavaCallable implements Callable {

	int noOfThreads = 50;
	public Object call() throws Exception {
// Creating an object of the  Random class   
		Random randObj = new Random();

// generating a random number between 0 to 9  
		Integer randNo = randObj.nextInt(noOfThreads);

// the thread is delayed for some random time  
		Thread.sleep(randNo * 100);

		return randNo;
	}
}