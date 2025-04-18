package CreationalDesignPattern.AbstractFactoryDesignPattern.AbstractFactoryImplementation;

public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        // Get a Sedan Factory and create a Sedan car
        CarFactory sedanFactory = FactoryProducer.getFactory("Sedan");
        Car sedan = sedanFactory.createCar();
        sedan.assemble();

        // Get an SUV Factory and create an SUV car
        CarFactory suvFactory = FactoryProducer.getFactory("SUV");
        Car suv = suvFactory.createCar();
        suv.assemble();
    }
}