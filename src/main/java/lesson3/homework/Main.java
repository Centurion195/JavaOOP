package lesson3.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int containerCount = 5;
        int maxWeightBox = 20;

        List<Container> containers = new ArrayList<>();

        for (int i = 0; i < containerCount; i++) {
            containers.add(new Container());
            containers.get(i).setId(i+1);
            for (int j = 0; j < random.nextInt(1,15); j++) {
                containers.get(i).addBox(random.nextDouble(maxWeightBox));
            }
            System.out.printf("Вес контейнера #%d: %.1f кг\n", i+1, containers.get(i).getWeight());
            System.out.println(containers.get(i).getBoxes());
            Collections.sort(containers.get(i).getBoxes());
            System.out.println(containers.get(i).getBoxes());
        }

        System.out.println("\nСортировка контейнеров по весу:");
        Collections.sort(containers);
        System.out.println(containers);

        System.out.println("\nСортировка контейнеров по количеству ящиков:");
        Collections.sort(containers, new ContainerCountComparator());
        System.out.println(containers);

        System.out.println("\nПеребор контейнеров:");
        for (int i = 0; i < containers.size(); i++) {
            System.out.printf("Контейнер №%d:\n", containers.get(i).getId());
            for (Box box : containers.get(i)) {
                System.out.println(box);
            }
            System.out.println();
        }
    }
}
