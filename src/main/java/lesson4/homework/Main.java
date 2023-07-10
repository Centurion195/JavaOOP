package lesson4.homework;

import lesson4.homework.fruits.Apple;
import lesson4.homework.fruits.GoldenApple;
import lesson4.homework.fruits.Orange;

public class Main {
    public static void main(String[] args) {
        Box<Orange> orangeBox = new Box<>();
        orangeBox.add(new Orange(1));
        orangeBox.add(new Orange(2));

        System.out.println(orangeBox.getWeight()); // 3

        Box<Apple> appleBox = new Box<>();
        appleBox.add(new Apple(1));
        appleBox.add(new GoldenApple(2));
        System.out.println(appleBox.getWeight());

        Box<GoldenApple> goldenAppleBox = new Box<>();
        goldenAppleBox.add(new GoldenApple(5)); // допустимый вариант
        System.out.println(goldenAppleBox.getWeight()); // 5

        goldenAppleBox.moveTo(appleBox); // допустимый вариант

        Box<Orange> orangeBox2 = new Box<>();
        orangeBox.moveTo(orangeBox2);
        System.out.println(orangeBox.getWeight()); // 0
        System.out.println(orangeBox2.getWeight()); // 3
    }
}
