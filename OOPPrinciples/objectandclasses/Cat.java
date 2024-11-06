package objectandclasses;

public class Cat {
  private int age;
  private int ears;
  private boolean pet;
  private int whiskers;
  private int timeToEat;

  public Cat(int age, int ears) {
    this.age = age;
    this.ears = ears;
  }

  public void meow() {
    System.out.println("Meow");
  }

  public boolean isKitten() {
    return age <= 1 && age > -1;
  }

  public int numEars() {
    return ears;
  }

}
