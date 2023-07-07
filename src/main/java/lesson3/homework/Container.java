package lesson3.homework;

import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

@Data
public class Container implements Comparable<Container>, Iterable<Box>{
    public int id;
    private List<Box> boxes;

    public Container() {
        boxes = new ArrayList<>();
    }

    public void addBox(double weight) {
        boxes.add(new Box(weight));
    }
    public List<Box> getBoxes() {
        return boxes;
    }
    public double getWeight() {
        double weight = 0;
        for (Box box : boxes) {
            weight += box.getWeight();
        }
        return weight;
    }

    @Override
    public String toString() {
        return String.format("Контейнер №%d: %.1f", id, getWeight());
    }

    @Override
    public int compareTo(Container o) {
        return Double.compare(getWeight(), o.getWeight());
    }

    @Override
    public Iterator<Box> iterator() {
        return new ContainerIterator(boxes);
    }
}
class ContainerIterator implements Iterator<Box>{

    private final List<Box> boxes;
    private int position;
    private int lastReturn;

    public ContainerIterator(List<Box> boxes) {
        this.boxes = boxes;
    }

    @Override
    public boolean hasNext() {
        return position < boxes.size();
    }

    @Override
    public Box next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        lastReturn = position + 1;
        return boxes.get(position++);
    }
}