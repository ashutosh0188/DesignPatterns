package org.example.structuraldesignpattern;

public class AdapterDesignPattern {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentAdapter(new LegacyPaymentSystem());
        paymentProcessor.pay("12345", 5000.00);
    }
}

//This is old API from legacy code which still processes the payment behind the scene.
//Adaptee
class LegacyPaymentSystem {

    public void makePayment(int accountNo, float amount) {
        System.out.println("Processing payment of "+amount+" from accountNo:"+accountNo);
    }
}

interface PaymentProcessor {
    void pay(String accountNo, double amount);
}

//This is a new API for migrated services. This is called Adapter.
class PaymentAdapter implements PaymentProcessor {
    private LegacyPaymentSystem legacyPaymentSystem;

    // Adapter constructor accepts an instance of the old payment system
    public PaymentAdapter(LegacyPaymentSystem legacyPaymentSystem) {
        this.legacyPaymentSystem = new LegacyPaymentSystem();
    }

    @Override
    public void pay(String accountNo, double amount) {
        int accNo = Integer.parseInt(accountNo);
        float amt = (float) amount;
        legacyPaymentSystem.makePayment(accNo, amt);
    }
}
