package io.pipecrafts.lambda.chaining;

import lombok.*;

import java.util.*;

public class UserComparator {

  public static void main(String[] args) {

    List<User> users = Arrays.asList(
      User.of("Jane", 26),
      User.of("Jane", 30),
      User.of("Aaron", 28),
      User.of("Faye", 30),
      User.of("Clyde", 40)
    );

    Comparator<User> nameComparator = Comparator.comparing(User::getName);
    Comparator<User> ageComparator = Comparator.comparingInt(User::getAge);
    users.sort(nameComparator.thenComparing(ageComparator));
    users.forEach(System.out::println);

    users.sort(nameComparator.reversed().thenComparing(ageComparator.reversed()));
    users.forEach(System.out::println);

    users.stream()
      .filter(u -> u.getName().startsWith("J"))
      .map(User::getName)
      .forEach(System.out::println);
  }

  @Value
  @Builder
  static class User {
    @NonNull
    String name;
    @NonNull
    int age;

    static User of(String name, int age) {
      return User.builder()
        .name(name)
        .age(age)
        .build();
    }
  }
}
