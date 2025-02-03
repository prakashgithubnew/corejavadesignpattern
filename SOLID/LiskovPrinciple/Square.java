package SOLID.LiskovPrinciple;

public class Square implements IInterface{

    @Override
    public int area(int w, int h) {
        return w*h;
    }
}
