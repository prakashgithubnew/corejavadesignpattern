package SOLID.LiskovPrinciple;

public class LiskovPrincipleMain {
    public static void main(String[] args){
        IInterface i = new Rectangle();
        System.out.println(i.area(3,5));
    }
}
