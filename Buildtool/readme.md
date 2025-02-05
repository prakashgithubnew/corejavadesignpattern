**Comparison between Maven and Gradle**
---------------------------------------

1. Both are open source
2. Both runs within JVM

**Why gradle to use/choose?**
-----------------------------
Maven vs. Gradle performance comparison


                            clean build (seconds)	        build (seconds)	            Code change then build (seconds)
            Maven	                43	                        17	                                18
            Gradle	                25	                        1	                                 4
            Gradle improvement	    42%	                        96%	                                77%


**Summary of performance results**
----------------------------------
We see that in every scenario Gradle has improved performance over Maven from 37% to 98%.

This remarkable difference is thanks to the following Gradle features:

    incremental build: avoids repeated class compilation or test runs
    
    Gradle daemon: continuously runs Gradle in the background ready to execute a build
    
    incremental compilation: Gradle analyses sources and classes, recompiling only if necessary
    
    Maven and Gradle support parallel build, which improves performance by doing work on multiple threads at the same time. 
    These features are by default disabled, so were not used in the above performance testing.


**Maven vs. Gradle usability comparison**
-----------------------------------------

    To build applications with Maven a local Maven installation is required, which Gradle avoids through its wrapper script. 
    The **Gradle wrapper** means that engineers can clone a repository and 
    immediately build the project without installing Gradle. This also makes Gradle easier to use on CI servers.

    Maven creates build artifacts within a target directory, whereas Gradle uses a build directory.



**Choosing between Maven & Gradle**
Now you know the differences between Maven and Gradle, maybe you already have a preference?

If not, here are some further recommendations based on your situation.

Using Gradle on a brand new project
For a brand new project use Gradle instead of Maven, because it’s:

* faster
* 
* more concise
* 
* easier to customise
* 
* promotes build code reuse
* 
* improves the developer experience

In summary, Gradle increases developer productivity allowing businesses to more effectively add value to their customers.