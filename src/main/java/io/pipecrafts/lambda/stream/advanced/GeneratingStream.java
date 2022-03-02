package io.pipecrafts.lambda.stream.advanced;

import java.util.stream.Stream;

public class GeneratingStream {

  public static void main(String[] args) {
    Stream<Integer> fiboStream = Stream.iterate(1, i -> i + i);
    fiboStream.limit(10).forEach(System.out::println);


    Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
      .limit(10)
      .map(t -> t[0])
      .forEach(System.out::println);

    Stream<Character> alphabet = Stream.iterate('A', letter -> letter <= 'Z', letter -> (char) (letter + 1));
    alphabet.forEach(System.out::print);
  }
}
