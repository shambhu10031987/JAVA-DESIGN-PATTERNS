package designpattern.structural;

// Adapter Design Pattern Example
// This example demonstrates the Adapter pattern by adapting a MarkerPen to work as a Pen.

// Pen interface (Target interface)
interface Pen {
    void write(String text);
}

// BallPen class (Adaptee)
class BallPen implements Pen {
    @Override
    public void write(String text) {
        System.out.println("Writing with BallPen: " + text);
    }
}

// MarkerPen class (Incompatible interface)
class MarkerPen {
    public void mark(String text) {
        System.out.println("Marking with MarkerPen: " + text);
    }
}

// MarkerPenAdapter class (Adapter)
class MarkerPenAdapter implements Pen {
    private MarkerPen markerPen;

    public MarkerPenAdapter(MarkerPen markerPen) {
        this.markerPen = markerPen;
    }

    @Override
    public void write(String text) {
        // Adapts the mark method to the write method
        markerPen.mark(text);
    }
}

// Client code
public class Adapter {
    public static void main(String[] args) {
        Pen ballPen = new BallPen();
        ballPen.write("Hello, World!");

        MarkerPen markerPen = new MarkerPen();
        Pen markerPenAdapter = new MarkerPenAdapter(markerPen);
        markerPenAdapter.write("Hello, Adapter Pattern!");
    }
}