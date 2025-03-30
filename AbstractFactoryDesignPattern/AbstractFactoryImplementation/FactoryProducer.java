package AbstractFactoryDesignPattern.AbstractFactoryImplementation;

class FactoryProducer {
    public static CarFactory getFactory(String type) {
        if (type.equalsIgnoreCase("Sedan")) {
            return new SedanFactory();
        } else if (type.equalsIgnoreCase("SUV")) {
            return new SUVFactory();
        }
        return null;
    }
}
