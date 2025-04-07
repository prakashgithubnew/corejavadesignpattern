package Misc;

public class Main {
    public static void main(String[] args) {
        Showable obj = new Parent() {
            @Override
            public void show() {
                System.out.println("Anonymous class show()");
            }
        };

        obj.show(); // Only 'show()' is accessible
         //obj.hiddenMethod(); // ERROR: hiddenMethod() is not accessible
    }
}
