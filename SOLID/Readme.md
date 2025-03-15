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

in this if we need to introduce any other discount lets say LabourDiscount then we dont need to change
DiscountCalculator class , just add that new class and then pass that class reference to DiscountCalculator
and it will calculate the same for you.


**Liskov’s Substitution Principle (LSP)**
-----------------------------------------
This principle states that objects of a superclass should be able to be replaced with objects of a 
subclass without affecting the correctness of the program



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

Now in the implementation

we can write
FlyingBird fly = new Eagle(); when fly is the requirmnet

or 

NonFlyingBird nonFlyingBird = new Ostrich(); when non fly is the requirmeennt





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
Consider an example below

    public class DebitCard{
        public void doTransaction(int amount){
            System.out.println("tx done with DebitCard");
        }
    }

    public class CreditCard{
        public void doTransaction(int amount){
            System.out.println("tx done with CreditCard");
        }
    }


    public class ShoppingMall {
        private DebitCard debitCard;

        public ShoppingMall(DebitCard debitCard) {
        this.debitCard = debitCard;
        }

        public void doPayment(Object order, int amount){              
            debitCard.doTransaction(amount);
        }
    
    public static void main(String[] args) {
        DebitCard debitCard=new DebitCard();
        ShoppingMall shoppingMall=new ShoppingMall(debitCard);
        shoppingMall.doPayment("some order",5000);
      }
    }

if you observe this is wrong design of coding , now ShoppingMall class tightly coupled with DebitCard

Now there is some error in your debit card and user want to go with Credit card then this won’t be 
possible because ShoppingMall is tightly couple with Debit Card

Improved Solution would be

    public interface BankCard {
        public void doTransaction(int amount);
    }

    public class CreditCard implements BankCard{
        public void doTransaction(int amount){            
            System.out.println("tx done with CreditCard");
        }
    }

    public class DebitCard implements BankCard{
        public void doTransaction(int amount){
            System.out.println("tx done with DebitCard");
        }
    }

    public class ShoppingMall {
        private BankCard bankCard;
            public ShoppingMall(BankCard bankCard) {
                this.bankCard = bankCard;
            }
            public void doPayment(Object order, int amount){
                bankCard.doTransaction(amount);
            }
        public static void main(String[] args) {
            BankCard bankCard=new CreditCard();
            ShoppingMall shoppingMall1=new ShoppingMall(bankCard);
            shoppingMall1.doPayment("do some order", 10000);
        }
    }


Now if you observe shopping mall is loosely coupled with BankCard , any type of card process the payment 
without any impact . which proofs DIP

    **MCQs**

**Q 1** - Which of the following pattern is used where we need to treat a group of objects in similar way 
as a single object?

Composite Design Pattern

Q 2  - What is Observer Pattern?
This pattern is used when there is one-to-many relationship between objects such as if one object is 
modified, its dependent objects are to be notified automatically.

Q 3 - Integer.valueOf is an example of Factory pattern?

Yes

Q 4  - What is GoF design Pattern in Java?
The Gang of Four Design Patterns is a set of solutions to common problems we encounter in software design and development.
These patterns categorize into three main groups:

Creational Patterns
Structural Patterns
Behavioral Patterns

Q 5  - Builder Design Pattern
It's a Creational design Pattern.


Q 6  - What is chunky and chatty principle in design
"chunky" refers to a design where a single request returns a large amount of data, minimizing the 
number of network calls needed, while "chatty" describes a design that requires multiple small requests 
to retrieve the same amount of data, resulting in more network communication but potentially greater 
flexibility for the user; essentially, "chunky" means sending large data chunks in few requests, 
while "chatty" means sending smaller data pieces in many requests. 

which one to use or any preference - chunky or chatty
-----------------------------------------------------

A "chunky" design can be more efficient for applications with high bandwidth needs as it reduces network 
overhead, while a "chatty" design might be better for situations where only small amounts of data are 
required frequently. 

A "chunky" API might be less flexible as it returns more data than a user always needs, while a 
"chatty" API gives users more control over the data retrieved but requires more network calls. 


