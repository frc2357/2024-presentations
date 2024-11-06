package objectandclasses;

public class Dog {
    private int age;
    private int legs;
    private boolean pet;
    private int whiskers;
    private int timeToEat;

    public Dog(int age, int legs) {
        this.age = age;
        this.legs = legs;
    }

    public void bark() {
        System.out.println("Bark");
    }

    public boolean isPuppy() {
        return age <= 1 && age > -1;
    }

    public int numLegs() {
        return legs;
    }
}
