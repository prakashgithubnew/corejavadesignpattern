package CreationalDesignPattern.AbstractFactoryDesignPattern.AbstractFactoryImplementation;

public class SedanFactory implements CarFactory{
    @Override
    public Car createCar() {
        return new Sedan();
    }
}
