package io.pipecrafts.lambda.toolbox;

import java.util.ArrayList;
import java.util.List;

public class PredicateDemo {

  public static void main(String[] args) {
    List<String> names = new ArrayList<>(List.of("John", "Jane", "Brandon", "Kim", "Nicole"));
    names.removeIf(s -> !s.startsWith("J"));
    names.forEach(System.out::println);
  }

}
