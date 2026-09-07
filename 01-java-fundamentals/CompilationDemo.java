/*
 * Compilation pipeline: .java -> .class -> JVM execution
 *
 * Step 1: You write source code in a .java file (human-readable).
 * Step 2: `javac CompilationDemo.java` invokes the Java compiler, which performs
 *         syntax/type checking and produces CompilationDemo.class (JVM bytecode,
 *         a platform-independent binary format).
 * Step 3: `java CompilationDemo` starts the JVM, which loads the .class file,
 *         verifies the bytecode, and interprets/JIT-compiles it into native
 *         machine code for your CPU, then runs main().
 *
 * Try it yourself in a terminal:
 *   javac 02_CompilationDemo.java   -> creates CompilationDemo.class
 *   ls                              -> you will see the new .class file
 *   java CompilationDemo            -> JVM loads & runs the bytecode
 */
public class CompilationDemo {
    public static void main(String[] args) {
        System.out.println("If you can read this, the JVM successfully loaded");
        System.out.println("and executed the bytecode compiled from this .java file.");
    }
}
