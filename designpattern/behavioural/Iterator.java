package designpattern.behavioural;

// Iterator Design Pattern Example
// This example demonstrates a simple implementation of the Iterator pattern.

import java.util.ArrayList;
import java.util.List;

// Iterator interface
interface Iterator {
    boolean hasNext();
    Object next();
}

// Container interface
interface Container {
    Iterator getIterator();
}

// Concrete Container
class NameRepository implements Container {
    private List<String> names = new ArrayList<>();

    public NameRepository() {
        names.add("John");
        names.add("Jane");
        names.add("Jack");
        names.add("Jill");
    }

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    // Concrete Iterator
    private class NameIterator implements Iterator {
        private int index;

        @Override
        public boolean hasNext() {
            return index < names.size();
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names.get(index++);
            }
            return null;
        }
    }
}

// Client code
public class IteratorPatternDemo {
    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();

        Iterator iterator = nameRepository.getIterator();
        while (iterator.hasNext()) {
            System.out.println("Name: " + iterator.next());
        }
    }
}
