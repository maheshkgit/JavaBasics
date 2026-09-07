/*
 * Abstract classes: cannot be instantiated directly, may mix implemented and
 * unimplemented (abstract) methods. Use when subclasses share common state/behavior
 * but must implement some specifics themselves.
 */
public class AbstractClasses {

    abstract static class Employee {
        String name;
        Employee(String name) { this.name = name; }

        // concrete method shared by all subclasses
        void clockIn() {
            System.out.println(name + " clocked in.");
        }

        // abstract method - each subclass must define its own pay calculation
        abstract double calculatePay();
    }

    static class SalariedEmployee extends Employee {
        double monthlySalary;
        SalariedEmployee(String name, double monthlySalary) {
            super(name);
            this.monthlySalary = monthlySalary;
        }
        @Override double calculatePay() { return monthlySalary; }
    }

    static class HourlyEmployee extends Employee {
        double hourlyRate;
        int hoursWorked;
        HourlyEmployee(String name, double hourlyRate, int hoursWorked) {
            super(name);
            this.hourlyRate = hourlyRate;
            this.hoursWorked = hoursWorked;
        }
        @Override double calculatePay() { return hourlyRate * hoursWorked; }
    }

    public static void main(String[] args) {
        // Employee e = new Employee("X"); // ERROR: cannot instantiate abstract class

        Employee[] employees = {
            new SalariedEmployee("Alice", 5000),
            new HourlyEmployee("Bob", 25, 160)
        };

        for (Employee e : employees) {
            e.clockIn();
            System.out.println(e.name + " pay = " + e.calculatePay());
        }
    }
}
