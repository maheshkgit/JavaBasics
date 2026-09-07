# Java Concept Samples

Each `.java` file is a standalone, runnable program (has its own `main` method)
demonstrating one specific concept. Compile and run any file individually:

```bash
javac 01_Encapsulation.java
java Encapsulation
```
(Class name = filename without the leading number/underscore, since Java's public
class name must match the filename.)

## 01-java-fundamentals/
- 01_JvmJdkJre.java — JVM vs JDK vs JRE
- 02_CompilationDemo.java — .java -> .class -> JVM pipeline
- 03_PrimitiveVsReference.java
- 04_VariablesScope.java
- 05_Operators.java
- 06_IfSwitch.java
- 07_Loops.java
- 08_Methods.java
- 09_PassByValue.java
- 11_AccessModifiers.java
- packagesdemo/ — real multi-package project (com.example.pkgdemo.*)
  Build/run with:
  ```bash
  cd packagesdemo
  find . -name "*.java" > sources.txt && javac -d out @sources.txt
  java -cp out com.example.pkgdemo.Main
  ```

## 02-oop/
- 01_Encapsulation.java
- 02_Abstraction.java
- 03_Inheritance.java
- 04_Polymorphism.java
- 05_CompositionVsInheritance.java
- 06_Interfaces.java
- 07_AbstractClasses.java
- 08_SolidPrinciples.java — S, O, L, I, D each illustrated
- 09_ImmutableObjects.java

## 03-collections/
- 01_ListDemo.java
- 02_ArrayListDemo.java
- 03_LinkedListDemo.java
- 04_SetDemo.java
- 05_HashSetDemo.java
- 06_TreeSetDemo.java
- 07_MapDemo.java
- 08_HashMapDemo.java
- 09_TreeMapDemo.java

## 04-functional-programming/
- LambdaExpressions.java
- FunctionalInterfaces.java
- PredicateDemo.java
- FunctionDemo.java
- ConsumerDemo.java
- SupplierDemo.java
- StreamsDemo.java
- OptionalDemo.java
- MethodReferences.java

All files in this folder are single, self-contained, package-free — copy-paste
into any online compiler / LeetCode Playground and run directly (rename the
public class to `Main` first if your judge requires that).
- 10_ConcurrentHashMapDemo.java
- 11_QueueDemo.java
- 12_DequeDemo.java
- 13_PriorityQueueDemo.java
