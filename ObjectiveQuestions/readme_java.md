Can be constructor be made final?

    No

Can constructor be inherited?

    Now suppose if constructors can be inherited then it will be impossible to achieving encapsulation. 
    Because by using a super class’s constructor we can access/initialize private members of a class.

Difference Between Instance Variable and Class Variable

    Instance variable defined outside method in class where as class variables are also defined 
    outside method but are declared as static

Can we define any static variable inside method?

    No

what is the default value of Local Variable

    Local Variable are having any default value.

Objects are stored in stack?

    No, its stored in Heap

**program 1**
What happens when the following program is compiled and run. Select the one correct answer. 	
public class example
{
int i[] = {0};
public static void main(String args[])
{
int i[] = {1};
change_i(i);
System.out.println(i[0]);
}
public static void change_i(int i[])
{
int j[] = {2};
i = j;
}
}

Answer 1

------------------------
The number of characters in an object of a class String is given by 
length() method

-------------------------

Which of the following are true. Select the three correct answers.
a.	A static method may be invoked before even a single instance of the class is constructed.
b.	A static method cannot access non-static methods of the class.
c.	Abstract modifier can appear before a class or a method but not before  a variable.
d.	final modifier can appear before a class or a variable but not before a method.
E.	Synchronized modifier may appear before a method or a variable but not before a class. 

answer a,b,c

