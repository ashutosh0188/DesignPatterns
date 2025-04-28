package org.example.structuraldesignpattern;

import java.util.Scanner;

//Decorator pattern is used when we have a base object and there are several multiple attributes associated with it.
// These associated attributes finally is-A same object of type base.
public class DecoratorDesignPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Car car = null;
            System.out.println("Please choose car you want to buy:\n 1. Maruti800\n 2. Dezire");
            int option = scanner.nextInt();
            switch (option) {
                case 1 ->  car = new Maruti800();
                case 2 -> car = new Dezire();
                default -> {
                    System.out.println("Please enter correct option");
                    continue;
                }
            }
            System.out.println("Please enter 1 to choose Mats:");
            int decoratorOption = scanner.nextInt();
            if (decoratorOption==1) {
                car = new Mats(car);
            }
            System.out.println("Please enter 1 to choose Seat Covers:");
            decoratorOption = scanner.nextInt();
            if (decoratorOption==1) {
                car = new SeatCovers(car);
            }

            System.out.println("Final price: " + car.cost());
        }
    }
}

abstract class Car {
    public abstract double cost();
}

class Maruti800 extends Car {

    @Override
    public double cost() {
        return 100000.00;
    }
}

class Dezire extends Car {

    @Override
    public double cost() {
        return 200000.00;
    }
}

//here decorator will always be a car type.
//explaining is-A relationship.
abstract class Decorator extends Car {
    protected Car car;
    public Decorator(Car car) {
        this.car = car;
    }
}

class Mats extends Decorator {

    public Mats(Car car) {
        super(car);
    }

    @Override
    public double cost() {
        return car.cost() + 10000.00;
    }
}

class SeatCovers extends Decorator {
    public SeatCovers(Car car) {
        super(car);
    }

    @Override
    public double cost() {
        return car.cost() + 20000;
    }
}