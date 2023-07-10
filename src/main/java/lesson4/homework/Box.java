package lesson4.homework;

import lesson4.homework.fruits.Apple;
import lesson4.homework.fruits.Fruit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T extends Fruit> {
private List<T> box;

    public Box() {
        this.box = new ArrayList<>();
    }
    public void add(T fruit) {
        this.box.add(fruit);
    }
    public int getWeight() {
        int sum = 0;
        for (Fruit fruit : box) {
            sum += fruit.getWeight();
        }
        return sum;
    }
    public void moveTo(Box<? super T> newBox) {
        for (var fruit : box) {
            newBox.add(fruit);
        }
        box.clear();
    }
}
