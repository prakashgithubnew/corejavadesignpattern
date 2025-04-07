package Inheritencevscomposition.inheritence;

class Dog extends Animal {

    @Override
    void speak() {
        System.out.println("Dog barks");
    }

    public static void main(String []args){
        Dog dog = new Dog();
        dog.speak2();
    }
}