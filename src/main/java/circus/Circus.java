package circus;

import circus.animal.*;
import circus.stuff.Cage;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;


import java.util.ArrayList;
import java.util.Arrays;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a : animalArrayList) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        System.out.println("Number of animals in the circus: " + animals.length);
//        animals[3] = new Elephant("Strong One");

        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));



        animalArrayList.add(new Duck("Goose"));
        animalArrayList.add(new Parrot("Dolly"));
        animalArrayList.add(new Tiger("Simba"));
        Duck louie = new Duck("Louie");
        animalArrayList.add(louie);
        animalArrayList.add(new Elephant("Elvis"));


        printAllAnimals(animalArrayList);

        System.out.println("Number of animals in the circus: " + animalArrayList.size());

        System.out.println("Before sorting:");
        printAllAnimals(animalArrayList);


        System.out.println("Index of Louie is: " + animalArrayList.indexOf(louie));

        System.out.println("After sorting:");
        animalArrayList.sort(Animal.AnimalNameComparator);
        printAllAnimals(animalArrayList);

        System.out.println("Index of Louie after sorting is: " + animalArrayList.indexOf(louie));


//        makeAnimalsTalk();
//        System.out.println("Total value of animals " + calculateAssetValue(animals));
//        System.out.println("Total value of equipments " + calculateAssetValue(equipments));



        Cage<Duck> duckCage = new Cage<>();
        Duck duck = new Duck("Scrooge");
        duckCage.lockUp(duck);
        Parrot parrot = new Parrot("Popper");
        Cage<Parrot> parrotCage = new Cage<>();
        parrotCage.lockUp(parrot);

        ArrayList<Cage> cages = new ArrayList<>();
        cages.add(duckCage);
        cages.add(parrotCage);

        for(Cage c: cages) {
            c.release();
        }
    }
}
