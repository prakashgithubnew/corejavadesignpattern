
![img_1.png](img_1.png)



![img_2.png](img_2.png)
Exception Hierarchy in Java
===========================

Exception Notes

Exception Can be divided in 2 forms

**Checked** -   Checked exceptions are checked at compile time.
                Derived from Exception
                Checked exception must be handled using try-catch 
                    block or must be declared using throw keyword
                Can be recovered
**Examples** - IOException, SQLException, FileNotFoundException.

**Unchecked** - Unchecked exceptions are checked at run time.
                Derived from RuntimeException
                Cannot be recovered
**Examples** - NullPointerException, ArrayIndexOutOfBoundsException, NullPointer Exception



Creating Custom Exceptions
===========================
Checked Exception-
Create Custom exception class extending from Exception
------------------------------------------------------
    public class WrongFileNameException extends Exception {
    
    public WrongFileNameException(String errorMessage) {
    
    super(errorMessage);
    
    }
    
    }

_Main Class to use Custom Exception_
------------------------------------
        public class ExceptionMainClass {

        public static void main(String[] args)  {
        int i=10;

        try {
            if (i == 10) {
                throw new WrongFileNameException("sing");
            }
        }
        catch(WrongFileNameException d){
           System.out.println("Invaid value");
        }
    }
}

UnChecked Exception-

    class InsufficientInventoryException extends RuntimeException {
        public InsufficientInventoryException(String message) {
        super(message);
        }
    }



    class InventoryService {
        private int availableQuantity = 100; // Initial available quantity

        public void processOrder(int quantity) {
            if (quantity > availableQuantity) {
                // Throw a custom InsufficientInventoryException if the requested quantity exceeds available quantity
                throw new InsufficientInventoryException("Insufficient inventory. Available quantity: " + availableQuantity);
            }
            // Actual order processing logic goes here
            // Update inventory, process payment, etc.
        }
}

Main Class

        public class EcommerceApp {
            public static void main(String[] args) {
            InventoryService inventoryService = new InventoryService();
    
            try {
                // Attempt to process an order
                inventoryService.processOrder(150); // This should throw an InsufficientInventoryException
            } catch (InsufficientInventoryException e) {
                // Handle the InsufficientInventoryException
                System.out.println("Order processing failed: " + e.getMessage());
                // Additional error handling logic can be added here
            }
        }
}

**Which Custom Exception to use and when**
* If a client can reasonably be expected to recover from an exception, make it a checked exception. 
* If a client cannot do anything to recover from the exception, make it an unchecked exception
  
**Scenario**

For example, before we open a file, we can first validate the input file name. If the user input file name is invalid, we can throw a custom checked exception:

    if (!isCorrectFileName(fileName)) {
    throw new IncorrectFileNameException("Incorrect filename : " + fileName );
    }
    In this way, we can recover the system by accepting another user input file name.

    However, if the input file name is a null pointer or it is an empty string, it means that we have some errors in the code. In this case, we should throw an unchecked exception:
    
    if (fileName == null || fileName.isEmpty())  {
    throw new NullOrEmptyException("The filename is null or empty.");
    }