/*
 * JVM, JDK, JRE
 * --------------
 * JDK (Java Development Kit) = compiler (javac) + tools + JRE. Used to WRITE and BUILD Java programs.
 * JRE (Java Runtime Environment) = JVM + core libraries. Used to RUN Java programs (no compiler).
 * JVM (Java Virtual Machine) = the engine that actually executes bytecode (.class files),
 *                              handles memory management (garbage collection), and provides
 *                              platform independence ("write once, run anywhere").
 *
 * Relationship:  JDK  ⊇  JRE  ⊇  JVM
 *
 * Run this program with: javac 01_JvmJdkJre.java && java JvmJdkJre
 */
public class JvmJdkJre {
    public static void main(String[] args) {
        System.out.println("Java version (JRE running this): " + System.getProperty("java.version"));
        System.out.println("JVM name: " + System.getProperty("java.vm.name"));
        System.out.println("JVM vendor: " + System.getProperty("java.vm.vendor"));
        System.out.println("Java home (JRE/JDK install path): " + System.getProperty("java.home"));

        System.out.println("\nFlow: MyProgram.java --(javac, part of JDK)--> MyProgram.class");
        System.out.println("      MyProgram.class --(java launcher, uses JVM inside JRE)--> running program");
    }
}
