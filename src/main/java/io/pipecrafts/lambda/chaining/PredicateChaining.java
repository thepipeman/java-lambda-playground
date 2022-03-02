package io.pipecrafts.lambda.chaining;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateChaining {

  public static void main(String[] args) {
    Predicate<String> startsWithJ = s -> s.toLowerCase().startsWith("j");
    Predicate<String> endsWithN = s -> s.toLowerCase().endsWith("n");

    List<String> names = Arrays.asList("Jane", "Jim", "Jam", "Jem", "Jom", "Moria", "Sauron", "Aragorn", "Arwen");
    List<String> filteredNames = names.stream()
      .filter(startsWithJ.and(endsWithN))
      .collect(Collectors.toList());
    System.out.println(filteredNames);
    ;
  }
}
