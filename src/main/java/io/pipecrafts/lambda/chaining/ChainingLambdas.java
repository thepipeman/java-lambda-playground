package io.pipecrafts.lambda.chaining;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ChainingLambdas {

  public static void main(String[] args) {
    Consumer<String> c1 = s -> System.out.println("C1 consumes " + s);
    Consumer<String> c2 = s -> System.out.println("C2 consumes " + s);
    Consumer<String> c3 = s -> {
      c1.accept(s);
      c2.accept(s);
    };

    c3.accept("Hello");


    Consumer<String> c4 = c1.andThen(c2);
    c4.accept("Hello from C4");

    Predicate<String> isNull = Objects::isNull;
    Predicate<String> isEmpty = String::isEmpty;

    Predicate<String> isNotEmpty = isNull.negate().and(isEmpty.negate());
  }

}
