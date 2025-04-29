package org.example.structuraldesignpattern;

import java.util.Scanner;

//The Facade Design Pattern is a structural pattern used to provide a simplified interface to a complex system.
// It hides the underlying complexity of multiple subsystems and presents a single unified interface for clients
// to interact with.
public class FacadeDesignPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentFacade paymentFacade = new PaymentFacade();
        while (true) {
            System.out.println("---------------------------");
            System.out.println("Please enter:\n1 for UPI.\n2 for Credit Card.\n0 to exit.");
            int opt = scanner.nextInt();
            if (opt==1) {
                System.out.println("*******************************");
                paymentFacade.doPayment(5000.00, PaymentMode.UPI);
                System.out.println("*******************************");
            } else if (opt==2) {
                System.out.println("*******************************");
                paymentFacade.doPayment(5000.00, PaymentMode.CREDIT_CARD);
                System.out.println("*******************************");
            } else if (opt==0) {
                break;
            } else {
                System.out.println("*******************************");
                System.out.println("Invalid option.");
                System.out.println("*******************************");
            }
        }
        scanner.close();
    }
}

//different mode of payment service includes complex business logic
class UPIPaymentService {

    public void processPayment(double amount) {
        System.out.println("Processing payment of ₹"+amount + " via UPI.");
    }
}

class CreditCardPaymentService {

    public void processPayment(double amount) {
        System.out.println("Processing payment of ₹"+amount + " via CreditCard.");
    }
}

enum PaymentMode {
    UPI, CREDIT_CARD, DEBIT_CARD
}

//a simplified entry point to the different component of the system for the client.
//encapsulate business logic
//loose coupling
//OCP
class PaymentFacade {
    private UPIPaymentService upiPaymentService;
    private CreditCardPaymentService creditCardPaymentService;

    public PaymentFacade() {
        this.upiPaymentService = new UPIPaymentService();
        this.creditCardPaymentService = new CreditCardPaymentService();
    }

    public void doPayment(double amount, PaymentMode paymentMode) {
        switch (paymentMode) {
            case UPI -> upiPaymentService.processPayment(amount);
            case CREDIT_CARD -> creditCardPaymentService.processPayment(amount);
            default -> System.out.println("Invalid payment method!");
        }
    }
}
