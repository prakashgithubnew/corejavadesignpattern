![img.png](img.png)

**What is Singleton Design Pattern(Creational Design Pattern)?**
=====================================
Singleton Pattern is a creational design pattern that guarantees a class has only one 
instance and provides a global point of access to it.

It involves only one class which is responsible for instantiating itself, 
making sure it creates not more than one instance.


**How to Identify 2 instances are different to each Other**
------------------------------------------------------------

Hashcode for each instances will be different.

Singleton pattern is used for logging, drivers objects, caching, and thread pool.
Singleton design pattern is used in core Java classes also (for example, java.lang.Runtime, java.awt.Desktop

**Singleton Design Pattern Example Below**
-------------------------------------------

1. Don't use eager initialization using static or like below

    package com.journaldev.singleton;

    public class EagerInitializedSingleton {
    
        private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
    
        // private constructor to avoid client applications using the constructor
        private EagerInitializedSingleton(){}
    
        public static EagerInitializedSingleton getInstance() {
            return instance;
        }
    }
2. use synchronized block instead of synchronized method to avoid any performance issues.
3. use enum to avoid multiple instance creation by reflection APIs.
4. If needed to serialize the singleton pattern then deserialize will create 2 instances, to avoid this override readResolve method.

singleton design Pattern example


class Singleton {
private static volatile Singleton obj = null;
private Singleton() {}

    public static Singleton getInstance()
    {
        if (obj == null) {
            // To make thread safe
            synchronized (Singleton.class)
            {
                // check again as multiple threads
                // can reach above step
                if (obj == null)
                    obj = new Singleton();
            }
        }
        return obj;
    }
}



**why double check is needed in case of singleton designPattern**
------------------------------------------------------------------

      Refer the program below

      public class SingletonDoubleChecked {
      private static volatile SingletonDoubleChecked instance;
      
          private SingletonDoubleChecked() { }
      
          public static SingletonDoubleChecked getInstance() {
              if (instance == null) {  // First Check
                  synchronized (SingletonDoubleChecked.class) {
                      if (instance == null) {  // Second Check
                          instance = new SingletonDoubleChecked();
                      }
                  }
              }
              return instance;
          }
      }


      First Check (if (instance == null))
      
         Prevents unnecessary synchronization after the instance is initialized.
      
      Synchronized Block (synchronized (SingletonDoubleChecked.class))
      
         Ensures only one thread creates the instance.
      
      Second Check (if (instance == null))
      
         Ensures that no other thread has created an instance while waiting for synchronization.


**Where to use singleton design Pattern**
-----------------------------------------

Database connection pooling where unnecessary connections are created and it 
leads to lot of memory and impact performance as well. 