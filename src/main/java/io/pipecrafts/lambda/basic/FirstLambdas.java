package io.pipecrafts.lambda.basic;


import java.util.function.Consumer;
import java.util.function.Supplier;

public class FirstLambdas {

  public static void main(String[] args) {

    Supplier<String> supplier = () -> "Hello from supplier!";
    String suppliedString = supplier.get();
    System.out.println(suppliedString);

    Consumer<String> consumer = (String s) -> System.out.println(String.format("Via consumer %s", s));
    consumer.accept(suppliedString);
  }

}
