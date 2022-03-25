package pattern.sigleton;

public enum EnumSingleton {

    INSTANCE;
    
    public static void doSomething(){
        //do something
    }

    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

/************************************************************************
 Enum Singleton
To overcome this situation with Reflection, Joshua Bloch suggests the use of Enum to implement Singleton design pattern as Java ensures 
 that any enum value is instantiated only once in a Java program.
Since Java Enum values are globally accessible, so is the singleton.
The drawback is that the enum type is somewhat inflexible; for example, it does not allow lazy initialization.

 Since enums are inherently serializable, we don't need to implement it with a serializable interface. 
 The reflection problem is also not there. Therefore, it is 100% guaranteed that only one instance of the singleton is present within a JVM. 
 Thus, this method is recommended as the best method of making singletons in Java.

There are a few reasons why we can use an enum as a singleton in Java
- Guaranteed one instance (Cannot instantiate more than one enum even through reflection).
- Thread-safe.
- Serialization.

 One thing to remember here is, when serializing an enum, field variables are not getting serialized. 
 For example, if we serialize and deserialize the EnumSingleton class, we will lose the value of 
 the int value field (Refer to the Oracle docs for more details about enum serialization).

By default, enums do not support lazy loading.
Though it’s very very rare but if you changed your mind and now want to convert your singleton to multi-ton, enum would not allow this.
 ************************************************************************/
