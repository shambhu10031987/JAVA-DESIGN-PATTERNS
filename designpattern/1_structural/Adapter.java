package designpattern.structural;

// Adapter Design Pattern Example
// This example demonstrates the Adapter pattern by adapting a ToyDuck to work as a Duck.

// Duck interface (Target interface)
interface Duck {
    void fly();
}

// NormalDuck class (Adaptee)
class NormalDuck implements Duck {
    @Override
    public void fly() {
        System.out.println("NormalDuck is flying high in the sky!");
    }
}

// ToyDuck class (Incompatible interface)
class ToyDuck {
    public void squeak() {
        System.out.println("ToyDuck is squeaking!");
    }
}

// ToyDuckAdapter class (Adapter)
class ToyDuckAdapter implements Duck {
    private ToyDuck toyDuck;

    public ToyDuckAdapter(ToyDuck toyDuck) {
        this.toyDuck = toyDuck;
    }

    @Override
    public void fly() {
        // Adapts the squeak method to the fly method
        System.out.println("Adapting ToyDuck to behave like a Duck:");
        toyDuck.squeak();
    }
}

// Client code
public class Adapter {
    public static void main(String[] args) {
        Duck normalDuck = new NormalDuck();
        normalDuck.fly();

        ToyDuck toyDuck = new ToyDuck();
        Duck toyDuckAdapter = new ToyDuckAdapter(toyDuck);
        toyDuckAdapter.fly();
    }
}