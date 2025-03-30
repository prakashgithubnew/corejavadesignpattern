package AbstractFactoryDesignPattern.AbstractFactoryImplementation;

public class SUV implements Car{

    @Override
    public void assemble() {
        System.out.println("Assembling SUV");
    }
}
