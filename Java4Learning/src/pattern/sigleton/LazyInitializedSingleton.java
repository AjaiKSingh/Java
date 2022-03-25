package pattern.sigleton;

public class LazyInitializedSingleton {

    private static LazyInitializedSingleton instance;
    
    private LazyInitializedSingleton(){}
    
    public static LazyInitializedSingleton getInstance(){
        if(instance == null){
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}

/****************************************************************************************************************************
 * https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
Lazy Initialization
Lazy initialization method to implement Singleton pattern creates the instance in the global access method. 
Above is the sample code for creating Singleton class with this approach.
 
The above implementation works fine in case of the single-threaded environment but when it comes to multi-threaded systems,
 it can cause issues if multiple threads are inside the if condition at the same time. 
It will destroy the singleton pattern and both threads will get the different instances of the singleton class. 

We should try different ways to create a thread-safe singleton class. 
******************************************************************************************************************************/
