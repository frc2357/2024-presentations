package polymorphism;

public class PolymorphismExample {
    public static void main(String[] args) {
        Animal[] animals = new Animal[] { new Dog(), new Cat() };

        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}
