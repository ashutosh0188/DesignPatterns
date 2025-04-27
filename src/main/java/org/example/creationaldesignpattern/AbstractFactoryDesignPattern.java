package org.example.creationaldesignpattern;

//Abstract Factory creates multiple related types.
//The Abstract Factory Pattern is an advanced version of the Factory Pattern.
//It allows you to create families of related objects without specifying their concrete classes.
public class AbstractFactoryDesignPattern {
    public static void main(String[] args) {
        LoanFactory homeLoanFactory = new HomeLoanFactory();
        homeLoanFactory.getLoanProcessor().processLoan(5000000);
        homeLoanFactory.getLoanValidator().validateCustomer();
        homeLoanFactory.getLoanDisbursementHandler().disburseFunds(4500000);

        LoanFactory carLoanFactory = new HomeLoanFactory();
        carLoanFactory.getLoanProcessor().processLoan(500000);
        carLoanFactory.getLoanValidator().validateCustomer();
        carLoanFactory.getLoanDisbursementHandler().disburseFunds(470000);
    }
}

//Top level factory
interface LoanFactory {
    LoanProcessor getLoanProcessor();
    LoanValidator getLoanValidator();
    LoanDisbursalHandler getLoanDisbursementHandler();
}

//Concrete implementation of Top level factory
class HomeLoanFactory implements LoanFactory {

    @Override
    public LoanProcessor getLoanProcessor() {
        return new HomeLoanProcessor();
    }

    @Override
    public LoanValidator getLoanValidator() {
        return new HomeLoanValidator();
    }

    @Override
    public LoanDisbursalHandler getLoanDisbursementHandler() {
        return new HomeLoanDisbursement();
    }
}

class CarLoanFactory implements LoanFactory {

    @Override
    public LoanProcessor getLoanProcessor() {
        return new CarLoanProcessor();
    }

    @Override
    public LoanValidator getLoanValidator() {
        return new CarLoanValidator();
    }

    @Override
    public LoanDisbursalHandler getLoanDisbursementHandler() {
        return new CarLoanDisbursement();
    }
}


//1. Define Abstract Interfaces for Each Loan Component
interface LoanProcessor {
    void processLoan(double amount);
}

interface LoanValidator {
    void validateCustomer();
}

interface LoanDisbursalHandler {
    void disburseFunds(double amount);
}

//2. Implement Concrete Home Loan Processors
class HomeLoanProcessor implements LoanProcessor {
    @Override
    public void processLoan(double amount) {
        System.out.println("Processing Loan amount of ₹ " + amount + ".");
    }
}

class HomeLoanValidator implements LoanValidator {
    @Override
    public void validateCustomer() {
        System.out.println("Validating customer....");
    }
}

class HomeLoanDisbursement implements LoanDisbursalHandler {
    @Override
    public void disburseFunds(double amount) {
        System.out.println("Disbursing home loan of amount ₹" + amount);
    }
}

//3. Implement Concrete Car Loan Processors
class CarLoanProcessor implements LoanProcessor {
    @Override
    public void processLoan(double amount) {
        System.out.println("Processing Loan amount of ₹ " + amount + ".");
    }
}

class CarLoanValidator implements LoanValidator {
    @Override
    public void validateCustomer() {
        System.out.println("Validating customer....");
    }
}

class CarLoanDisbursement implements LoanDisbursalHandler {
    @Override
    public void disburseFunds(double amount) {
        System.out.println("Disbursing car loan of amount ₹" + amount);
    }
}
