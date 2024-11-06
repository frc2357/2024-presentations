public class Car {
    
    public Car() {

    }

    // With abstraction, we hide the complex workings of the mechanism
    // A car driver only needs to know how to accelerate, they do not need to know
    // how acceleration happens.
    public void accelerate() {
        // Super fancy code to control the code
        throttleEngine();
        controlAirflow();
        spark();
        fuelInject();
        movePiston();
        moveCrankshaft();
        System.out.println("Car accelerating");
    }

    private void throttleEngine() {
        // Fancy code
    }

    private void controlAirflow() {
        // Fancy code
    }

    
    private void spark() {
        // Fancy code
    }

    private void fuelInject() {
        // Fancy code
    }

    private void movePiston() {
        // Fancy code
    }

    private void moveCrankshaft() {
        // Fancy code
    }
}
