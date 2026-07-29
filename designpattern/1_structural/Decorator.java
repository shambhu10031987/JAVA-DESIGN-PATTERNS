// Placeholder file for the structural design pattern package.
package designpattern.structural;

// Component interface
// This defines the interface for objects that can have responsibilities added dynamically.
interface Pizza {
    void prepare();
}

// Concrete Component
// This is the core object that implements the Pizza interface. It is the object being decorated.
class PlainPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing plain pizza");
    }
}

// Decorator abstract class
// This abstract class implements the Pizza interface and contains a reference to a Pizza object.
// It serves as the base class for all decorators.
abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public void prepare() {
        // Delegates the preparation to the wrapped pizza.
        pizza.prepare();
    }
}

// Concrete Decorator
// This class extends the PizzaDecorator and adds additional toppings to the pizza.
class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public void prepare() {
        // Calls the base preparation and adds extra behavior.
        super.prepare();
        System.out.println("Adding cheese topping");
    }
}

// Client code
// Demonstrates the use of the Decorator pattern by dynamically adding toppings to a pizza.
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        // Create a PlainPizza instance.
        Pizza plainPizza = new PlainPizza();

        // Decorate the pizza with a CheeseDecorator.
        Pizza cheesePizza = new CheeseDecorator(plainPizza);

        // Execute the decorated pizza's preparation.
        System.out.println("Preparing decorated pizza:");
        cheesePizza.prepare();
    }
}
