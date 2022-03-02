package io.pipecrafts.lambda.toolbox;

import java.util.function.DoubleToIntFunction;
import java.util.function.IntSupplier;

public class PrimitiveLambdas {


  public static void main(String[] args) {
    IntSupplier supplier = () -> 10;
    int i = supplier.getAsInt();
    System.out.println("i = " + i);


    DoubleToIntFunction dFunction = v -> (int) Math.floor(v);
    double d = dFunction.applyAsInt(Math.PI);
    System.out.println("d = " + d);

  }
}
