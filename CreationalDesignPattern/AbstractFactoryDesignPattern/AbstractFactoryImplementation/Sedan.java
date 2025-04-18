package CreationalDesignPattern.AbstractFactoryDesignPattern.AbstractFactoryImplementation;

public class Sedan implements Car {

    @Override
    public void assemble() {
        System.out.println("Assembling Sedan");
    }
}
