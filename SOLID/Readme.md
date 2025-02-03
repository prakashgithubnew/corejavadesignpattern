**SOLID Principles**
====================

* Single Responsibility Principle (SRP)
* Open/Closed Principle
* Liskov’s Substitution Principle (LSP)
* Interface Segregation Principle (ISP)
* Dependency Inversion Principle (DIP)


**Single Responsibility Principle (SRP)**
-----------------------------------------

A class should have only one reason to change

Example

Before SRP
----------

public class User {

    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Bad practice: Handling file storage within the User class
    public void saveToFile() {
        try (FileWriter fileWriter = new FileWriter(name + ".txt")) {
            fileWriter.write("Name: " + name + "\n");
            fileWriter.write("Email: " + email + "\n");
            System.out.println("User data saved to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        User user = new User("John Doe", "john.doe@example.com");
        user.saveToFile();
    }
}
**problem** - The User class has two responsibilities: managing user data and handling file storage. 
This violates the Single Responsibility Principle because a change in the file storage mechanism 
would require modifications to the User class.


After SRP
---------
// User.java
public class User {
private String name;
private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

// UserFileManager.java

    import java.io.FileWriter;
    import java.io.IOException;
    
    public class UserFileManager {
    public void saveToFile(User user) {
    try (FileWriter fileWriter = new FileWriter(user.getName() + ".txt")) {
    fileWriter.write("Name: " + user.getName() + "\n");
    fileWriter.write("Email: " + user.getEmail() + "\n");
    System.out.println("User data saved to file successfully.");
    } catch (IOException e) {
    e.printStackTrace();
    }
    }
    }
    
// Main.java

    public class Main {
    public static void main(String[] args) {
    User user = new User("John Doe", "john.doe@example.com");
    UserFileManager fileManager = new UserFileManager();
    fileManager.saveToFile(user);
    }
    }

Problem - if any changes in UserFileManager would not cause chnages in User


**Open/Closed Principle**
-------------------------
classes should be open for extension not for modification

Before

    public class DiscountCalculator {
    public double calculateDiscount(String customerType, double amount) {
    if (customerType.equals("Regular")) {
    return amount * 0.1;
    } else if (customerType.equals("Premium")) {
    return amount * 0.2;
    }
    return 0;
    }

    public static void main(String[] args) {
        DiscountCalculator calculator = new DiscountCalculator();
        double regularDiscount = calculator.calculateDiscount("Regular", 100);
        double premiumDiscount = calculator.calculateDiscount("Premium", 100);

        System.out.println("Regular Discount: " + regularDiscount);
        System.out.println("Premium Discount: " + premiumDiscount);
    }
}

if any new discount will come it will require changes to DiscountCalculator

**After OCP**

public abstract class Discount {

    public abstract double calculate(double amount);
}

// RegularDiscount.java
public class RegularDiscount extends Discount {

    public double calculate(double amount) {
    return amount * 0.1;
    }
}

// PremiumDiscount.java
public class PremiumDiscount extends Discount {

    public double calculate(double amount) {
    return amount * 0.2;
    }
}

// DiscountCalculator.java
public class DiscountCalculator {

    public double calculateDiscount(Discount discount, double amount) {
    return discount.calculate(amount);
    }
}

// Main.java
public class Main {

    public static void main(String[] args) {
    Discount regularDiscount = new RegularDiscount();
    Discount premiumDiscount = new PremiumDiscount();

        DiscountCalculator calculator = new DiscountCalculator();

        double regularDiscountAmount = calculator.calculateDiscount(regularDiscount, 100);
        double premiumDiscountAmount = calculator.calculateDiscount(premiumDiscount, 100);

        System.out.println("Regular Discount: " + regularDiscountAmount);
        System.out.println("Premium Discount: " + premiumDiscountAmount);
    }
}


**Liskov’s Substitution Principle (LSP)**
-----------------------------------------
It states that if code works with a given class, it must continue to work correctly with 
subclasses of that base class.

means for example
Class I
Class C1 extends I 
Class C2 extends I

if we do
I i = new C1();
then there should not be any impact using below(replacing C1 by C2)
I i = new C2();


Example ----

abstract class Bird{

    abstract void fly();
}

class Eagle extends Bird {

    @Override
    public void fly() { // some implementation }
}

class Ostrich extends Bird {

    @Override
    public void fly() { // dummy implementation }
}

In the above example, the Eagle class and the Ostrich class both extend the Bird class and 
override the fly() method. However, the Ostrich class is forced to provide a dummy 
implementation because it cannot fly, and therefore it does not behave the same way 
if we replace the Bird class object with it.

The correct Implementation would be
-----------------------------------

abstract class FlyingBird{
    abstract void fly();
}

abstract class NonFlyingBird{
    abstract void doSomething();
}

class Eagle extends FlyingBird {
    @Override
    public void fly() { // some implementation }
}

class Ostrich extends NonFlyingBird {
    @Override
    public void doSomething() { // some implementation }
}
Good Example
https://www.youtube.com/watch?v=129QkkXUHeQ

**Interface Segregation Principle**
-----------------------------------
According to the interface segregation principle, you should build small, 
focused interfaces that do not force the client to implement behavior they do not need.

A straightforward example would be to have an interface that calculates 
both the area and volume of a shape.

interface IShapeAreaCalculator(){

    double calculateArea();
    double calculateVolume();
}

class Square implements IShapeAreaCalculator{

        double calculateArea(){ // calculate the area }
        double calculateVolume(){ // dummy implementation }
}


The issue with this is that if a Square shape implements this, 
then it is forced to implement the calculateVolume() method, which it does not need.

**Dependency Inversion Principle**
----------------------------------
In the dependency inversion principle, high-level modules should not depend on low-level modules. 
In other words, you must follow abstraction and ensure loose coupling.

