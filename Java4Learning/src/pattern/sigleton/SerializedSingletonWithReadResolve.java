package pattern.sigleton;

import java.io.Serializable;

public class SerializedSingletonWithReadResolve implements Serializable{

    private static final long serialVersionUID = -7604766932017737115L;

    private SerializedSingletonWithReadResolve(){}
    
    private static class SingletonHelper{
        private static final SerializedSingletonWithReadResolve instance = new SerializedSingletonWithReadResolve();
    }
    
    public static SerializedSingletonWithReadResolve getInstance(){
        return SingletonHelper.instance;
    }
    
    protected Object readResolve() {
        return getInstance();
    }
}

/************************************************************************
Serialization and Singleton
Sometimes in distributed systems, we need to implement Serializable interface in Singleton class so that we can store its state
 in the file system and retrieve it at a later point of time.
Here is a small singleton class that implements Serializable interface also.

The problem with serialized singleton class is that whenever we deserialize it, 
 it will create a new instance of the class. Let’s see it with a simple program. 
 So it destroys the singleton pattern,
  to overcome this scenario all we need to do it provide the implementation of readResolve() method,
   which is called when preparing the deserialized object before returning it to the caller.
 ************************************************************************/
