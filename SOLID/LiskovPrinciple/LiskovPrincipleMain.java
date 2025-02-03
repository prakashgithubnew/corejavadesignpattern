package SOLID.LiskovPrinciple;

public class LiskovPrincipleMain {
    public static void main(String[] args){
        IInterface i = new Hen();
        //if we replace Pegion with Hen then Hen is forced to use the funcitnlaity of Fly but its incorrect as
        //hen cannot fly
    }
}
