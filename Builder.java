package designpattern.creational;

// Product class
class House {
    private String foundation;
    private String structure;
    private String roof;

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    @Override
    public String toString() {
        return "House built with foundation: " + foundation + ", structure: " + structure + ", roof: " + roof;
    }
}

// Builder interface
interface HouseBuilder {
    House build();
}

// Concrete Builder
class ConcreteHouseBuilder implements HouseBuilder {
    private final House house;

    public ConcreteHouseBuilder() {
        this.house = new House();
    }

    public ConcreteHouseBuilder buildFoundation() {
        house.setFoundation("Concrete Foundation");
        return this;
    }

    public ConcreteHouseBuilder buildStructure() {
        house.setStructure("Concrete Structure");
        return this;
    }

    public ConcreteHouseBuilder buildRoof() {
        house.setRoof("Concrete Roof");
        return this;
    }

    @Override
    public House build() {
        return house;
    }
}

public class Builder {
    public static void main(String[] args) {
        House house = new ConcreteHouseBuilder()
                .buildFoundation()
                .buildStructure()
                .buildRoof()
                .build();

        System.out.println(house);
    }
}
