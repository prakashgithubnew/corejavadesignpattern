package SOLID.LiskovPrinciple;

public class Rectangle implements IInterface{
    @Override
    public int area(int w, int h) {
        return w*h;
    }
}
