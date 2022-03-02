package io.pipecrafts.lambda.toolbox;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MappingDemo {


  public static void main(String[] args) {
    List<User> userList = new ArrayList<>();
    userList.add(User.of("John"));
    userList.add(User.of("Jane"));
    userList.add(User.of("Kim"));

    List<String> userNames = userList.stream()
      .map(User::getName)
      .collect(Collectors.toList());
    userNames.forEach(System.out::println);
  }

  @Value
  @Builder
  static class User {
    @NonNull
    String name;

    static User of(String name) {
      return User.builder()
        .name(name)
        .build();
    }
  }
}
