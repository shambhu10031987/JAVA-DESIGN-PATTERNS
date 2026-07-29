package designpattern.creational;

// Prototype interface
interface PrototypeCloneable {
    PrototypeCloneable clone();
}

// Concrete Prototype class
class ConcretePrototype implements PrototypeCloneable {
    private String name;

    public ConcretePrototype(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public PrototypeCloneable clone() {
        return new ConcretePrototype(this.name);
    }
}

public class Prototype {
    public static void main(String[] args) {
        // Create an original object
        ConcretePrototype original = new ConcretePrototype("Original Prototype");

        // Clone the original object
        ConcretePrototype cloned = (ConcretePrototype) original.clone();

        // Modify the cloned object
        cloned = new ConcretePrototype("Modified Cloned Prototype");

        // Display the names of the original and cloned objects
        System.out.println("Original: " + original.getName());
        System.out.println("Cloned: " + cloned.getName());
    }
}
