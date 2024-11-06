package objectandclasses;

public class ObjectExample {
    public static void main(String[] args) {
        Dog puppy = new Dog(1, 4);
        puppy.bark();
        System.out.println("Am I a puppy: " + puppy.isPuppy());
        System.out.println("How many legs?: " + puppy.numLegs());

        Dog adult = new Dog(5, 3);
        adult.bark();
        System.out.println("Am I a puppy: " + adult.isPuppy());
        System.out.println("How many legs?: " + adult.numLegs());

        // Make a new dog with age -1 and check if it's a puppy
        Dog unborn = new Dog(-1, 8);
        unborn.bark();
        System.out.println("Am I a puppy: " + unborn.isPuppy());
        System.out.println("How many legs?: " + unborn.numLegs());

        Cat kitten = new Cat(1, 2);
        kitten.meow();
        System.out.println("Am I a kitten: " + kitten.isKitten());
        System.out.println("How many ears?:" + kitten.numEars());
    }

}