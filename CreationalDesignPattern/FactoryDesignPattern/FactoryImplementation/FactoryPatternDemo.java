package CreationalDesignPattern.FactoryDesignPattern.FactoryImplementation;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        // Create a Circle
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        System.out.println(shape1.drawShape());

        // Create a Rectangle
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        System.out.println(shape2.drawShape());

        // Create a Square
        Shape shape3 = shapeFactory.getShape("SQUARE");
        System.out.println(shape3.drawShape());
    }
}