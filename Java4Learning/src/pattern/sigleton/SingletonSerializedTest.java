package pattern.sigleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SingletonSerializedTest {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        SerializedSingleton instanceOne = SerializedSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
        out.writeObject(instanceOne);
        out.close();
        
        //deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
        SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
        in.close();
        
        System.out.println("*********** Without readResolve() **************");
        System.out.println("instanceOne hashCode="+instanceOne.hashCode());
        System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());
        
        //With readResolve()
        SerializedSingletonWithReadResolve serializedSingletonWithReadResolveInstanceOne = SerializedSingletonWithReadResolve.getInstance();
        ObjectOutput out1 = new ObjectOutputStream(new FileOutputStream("filename1.ser"));
        out1.writeObject(serializedSingletonWithReadResolveInstanceOne);
        out1.close();
        
        //deserailize from file to object
        ObjectInput in1 = new ObjectInputStream(new FileInputStream("filename1.ser"));
        SerializedSingletonWithReadResolve serializedSingletonWithReadResolveInstanceTwo = (SerializedSingletonWithReadResolve) in1.readObject();
        in1.close();
        
        System.out.println("*********** With readResolve() **************");
        System.out.println("instanceOne hashCode="+serializedSingletonWithReadResolveInstanceOne.hashCode());
        System.out.println("instanceTwo hashCode="+serializedSingletonWithReadResolveInstanceTwo.hashCode());        
    }

}

/***********************************************************************************************************************************************
The output of the above program is;

*********** Without readResolve() **************
instanceOne hashCode=865113938
instanceTwo hashCode=1096979270

*********** With readResolve() **************
instanceOne hashCode=1023892928
instanceTwo hashCode=1023892928


So it destroys the singleton pattern, to overcome this scenario all we need to do it provide the implementation of readResolve() method.

***************************************************************************************************************************************************/
