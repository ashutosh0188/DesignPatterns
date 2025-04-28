package org.example.creationaldesignpattern;

import java.util.Objects;

//Factory design pattern, which allows to keep object creation logic inside the factory.
//1. Here factory provides abstraction that hides the complexity
//2. encapsulate the object creation logic.
//3. It also provides the loose coupling where client depends on factory interface
// instead of concrete implementation promoting flexibility in the code design.
public class FactoryDesignPattern {
    public static void main(String[] args) {
        PaymentFactory.getPayment(PaymentType.UPI).display();
        PaymentFactory.getPayment(PaymentType.DEBIT_CARD).display();
        PaymentFactory.getPayment(null).display();
    }
}

class PaymentFactory {
    public static Payment getPayment(PaymentType paymentType) {
        if (Objects.isNull(paymentType)) { //handle this scenario according to business need.
            throw new RuntimeException("Null value supplied");
        }
        return switch (paymentType) {
            case UPI -> new UPI();
            case DEBIT_CARD -> new DebitCard();
            default -> throw new IllegalArgumentException("Please provide correct payment mode.");
        };
    }
}

enum PaymentType {
    UPI, DEBIT_CARD;
}

interface Payment {
    void display();
}

class UPI implements Payment {

    @Override
    public void display() {
        System.out.println(" UPI mode selected ");
    }
}

class DebitCard implements Payment {

    @Override
    public void display() {
        System.out.println(" DebitCard mode selected ");
    }
}
