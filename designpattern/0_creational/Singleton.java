package designpattern.creational;

public class Singleton {
    private static Singleton instance;

    private Singleton() {
        // Private constructor to prevent instantiation
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized(Singleton.class){
                if (instance == null) {
                     instance = new Singleton();

        }     }}
        return instance;
    }

}
