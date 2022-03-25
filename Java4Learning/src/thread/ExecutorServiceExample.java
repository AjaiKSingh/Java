package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {  
	  
    public static void main(String[] args) {  
        
    	ExecutorService executorService = Executors.newFixedThreadPool(10);  

    	//Instantiating ExecutorService
    	//We can use Java ExecutorService to create a single thread, a pool of threads, 
    	//or a scheduled pool of threads. The Executors class provides factory methods to instantiate an ExecutorService as follows-
    	
	    	ExecutorService executorService1 = Executors.newSingleThreadExecutor(); //Creates //a ExecutorService object having a single thread.  
	    	
	    	// Creates a //ExecutorService object having a pool of 10 threads.
	    	ExecutorService executorService2 = Executors.newFixedThreadPool(10);  
	    	
	    	//Creates a scheduled thread pool executor with 10 threads.
	    	//In scheduled thread pool, we can schedule tasks of the threads.
	    	ExecutorService executorService3 = Executors.newScheduledThreadPool(10);   

	    	
	    	executorService.execute(new Runnable() {  
              
            @Override  
            public void run() {  
                System.out.println("ExecutorService");  
                  
            }  
        });  

	/*
		 Once we are done with our tasks given to ExecutorService, then we have to shut it down because ExecutorService performs
		 the task on different threads.
		 If we don't shut down the ExecutorService, the threads will keep running, and the JVM won't shut down.
		
		The process of shutting down can be done by the following three methods-
		
		shutdown() method
		shutdownNow() method
		awaitTermination() method        
	 */
        executorService.shutdown();  
    }  
  
}  

/*
In this program, we are creating an ExecutorService with ten threads 
and assigning it an anonymous runnable implementation which performs 
a task to print "ExecutorService" and after its task is over, we are shutting down the executor service.
*/