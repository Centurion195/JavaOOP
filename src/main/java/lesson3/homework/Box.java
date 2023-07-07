package lesson3.homework;

import lombok.Getter;

public class Box implements Comparable<Box>{
    @Getter
    private double weight;

    public Box(double weight) {
        this.weight = Math.round(weight * 100) / 100.0;
    }

    @Override
    public String toString() {
        return "Box{" +
                "Вес = " + weight +
                '}';
    }

    @Override
    public int compareTo(Box o) {
        return Double.compare(weight, o.weight);
    }
}
