/*
 * SOLID Principles (one small illustrative example per letter)
 *
 * S - Single Responsibility: a class should have one reason to change.
 * O - Open/Closed: open for extension, closed for modification.
 * L - Liskov Substitution: subclasses must be substitutable for their base type.
 * I - Interface Segregation: prefer many small interfaces over one fat interface.
 * D - Dependency Inversion: depend on abstractions, not concrete implementations.
 */
public class SolidPrinciples {

    // --- S: Single Responsibility ---
    static class InvoiceCalculator {          // only responsible for calculating totals
        double calculateTotal(double price, int qty) { return price * qty; }
    }
    static class InvoicePrinter {             // only responsible for printing
        void print(double total) { System.out.println("Invoice total: $" + total); }
    }

    // --- O: Open/Closed ---
    interface Discount { double apply(double price); }
    static class NoDiscount implements Discount { public double apply(double p) { return p; } }
    static class TenPercentOff implements Discount { public double apply(double p) { return p * 0.9; } }
    // Adding a new discount type means adding a new class, not modifying existing ones.

    // --- L: Liskov Substitution ---
    static class Bird { void move() { System.out.println("Bird moves"); } }
    static class Sparrow extends Bird { void move() { System.out.println("Sparrow flies"); } }
    // Sparrow can be used anywhere a Bird is expected without breaking behavior.

    // --- I: Interface Segregation ---
    interface Printer { void print(); }
    interface Scanner { void scan(); }
    static class SimplePrinter implements Printer { // doesn't need to implement scan()
        public void print() { System.out.println("Printing..."); }
    }

    // --- D: Dependency Inversion ---
    interface MessageSender { void send(String msg); }
    static class EmailSender implements MessageSender {
        public void send(String msg) { System.out.println("Emailing: " + msg); }
    }
    static class Notifier {
        private final MessageSender sender; // depends on abstraction, not a concrete EmailSender
        Notifier(MessageSender sender) { this.sender = sender; }
        void notify(String msg) { sender.send(msg); }
    }

    public static void main(String[] args) {
        InvoiceCalculator calc = new InvoiceCalculator();
        double total = calc.calculateTotal(10.0, 3);
        new InvoicePrinter().print(total);

        Discount discount = new TenPercentOff();
        System.out.println("Discounted price: " + discount.apply(100));

        Bird b = new Sparrow();
        b.move();

        new SimplePrinter().print();

        Notifier notifier = new Notifier(new EmailSender());
        notifier.notify("Hello via DI!");
    }
}
