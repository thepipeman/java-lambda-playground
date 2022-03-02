package io.pipecrafts.lambda.chaining;

import java.util.*;

public class CreatingComparators {

  public static void main(String[] args) {
    List<String> strings = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
    Comparator<String> cmp = String::compareTo;
    strings.sort(cmp);
    System.out.println(strings);

    // this returns a primitive
    Comparator<String> cmp2 = Comparator.comparingInt(String::length);
    strings.sort(cmp2);
    System.out.println(strings);


  }

}
