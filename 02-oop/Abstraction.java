/*
 * Abstraction: exposing only essential behavior/details and hiding implementation complexity.
 * Achieved via abstract classes and interfaces - the caller knows WHAT it can do, not HOW.
 */
public class Abstraction {

    interface PaymentProcessor {
        void pay(double amount); // WHAT it does, not HOW
    }

    static class CreditCardProcessor implements PaymentProcessor {
        @Override
        public void pay(double amount) {
            // complex validation, network calls, etc. are hidden from the caller
            System.out.println("Processing $" + amount + " via credit card (details hidden).");
        }
    }

    static class PayPalProcessor implements PaymentProcessor {
        @Override
        public void pay(double amount) {
            System.out.println("Processing $" + amount + " via PayPal (details hidden).");
        }
    }

    static void checkout(PaymentProcessor processor, double amount) {
        // this method doesn't need to know HOW payment happens
        processor.pay(amount);
    }

    public static void main(String[] args) {
        checkout(new CreditCardProcessor(), 49.99);
        checkout(new PayPalProcessor(), 19.99);
    }
}
