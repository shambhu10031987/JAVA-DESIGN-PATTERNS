package designpattern.creational;

// Abstract Product A
interface ShapeInterface {
    void draw();
}

// Abstract Product B
interface ColorInterface {
    void fill();
}

// Concrete Product A1
class CircleShape implements ShapeInterface {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Concrete Product A2
class RectangleShape implements ShapeInterface {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

// Concrete Product B1
class RedColor implements ColorInterface {
    @Override
    public void fill() {
        System.out.println("Filling with Red color");
    }
}

// Concrete Product B2
class BlueColor implements ColorInterface {
    @Override
    public void fill() {
        System.out.println("Filling with Blue color");
    }
}

// Abstract Factory
interface AbstractFactory {
    ShapeInterface createShape();
    ColorInterface createColor();
}

// Concrete Factory 1
class CircleShapeFactory implements AbstractFactory {
    @Override
    public ShapeInterface createShape() {
        return new CircleShape();
    }

    @Override
    public ColorInterface createColor() {
        return new RedColor();
    }
}

// Concrete Factory 2
class RectangleShapeFactory implements AbstractFactory {
    @Override
    public ShapeInterface createShape() {
        return new RectangleShape();
    }

    @Override
    public ColorInterface createColor() {
        return new BlueColor();
    }
}

public class AbstractFactoryDesign {
    public static void main(String[] args) {
        // Create ShapeFactory
        AbstractFactory shapeFactory = new CircleShapeFactory();
        ShapeInterface shape1 = shapeFactory.createShape();
        ColorInterface color1 = shapeFactory.createColor();
        shape1.draw();
        color1.fill();

        // Create ColorFactory
        AbstractFactory colorFactory = new RectangleShapeFactory();
        ShapeInterface shape2 = colorFactory.createShape();
        ColorInterface color2 = colorFactory.createColor();
        shape2.draw();
        color2.fill();
    }
}
