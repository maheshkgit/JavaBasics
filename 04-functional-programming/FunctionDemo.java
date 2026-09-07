/*
 * Function<T, R>: R apply(T t)
 * Transforms an input of type T into an output of type R. Chain with andThen()/compose().
 */
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<String, Integer> length = String::length;
        Function<Integer, Integer> square = n -> n * n;

        System.out.println("length.apply('hello'): " + length.apply("hello"));

        // andThen: apply 'length' first, THEN 'square' on the result
        Function<String, Integer> lengthThenSquare = length.andThen(square);
        System.out.println("lengthThenSquare.apply('hello'): " + lengthThenSquare.apply("hello")); // 25

        // compose: apply 'square' first, THEN 'length' -- but length needs a String, so use a compatible example
        Function<Integer, String> toBinaryString = Integer::toBinaryString;
        Function<Integer, Integer> squareThenToBinaryLength = length.compose(toBinaryString);
        System.out.println("squareThenToBinaryLength.apply(5): " + squareThenToBinaryLength.apply(5)); // binary "101" -> length 3

        // identity() - returns input unchanged, useful as a default/no-op transform
        Function<String, String> identity = Function.identity();
        System.out.println("identity.apply('same'): " + identity.apply("same"));

        // BiFunction - two inputs
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        System.out.println("multiply.apply(3,4): " + multiply.apply(3, 4));

        // UnaryOperator - Function<T,T> specialization, input/output same type
        UnaryOperator<Integer> doubleIt = n -> n * 2;
        System.out.println("doubleIt.apply(21): " + doubleIt.apply(21));
    }
}
