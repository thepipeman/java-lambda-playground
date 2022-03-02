package io.pipecrafts.lambda.stream.basic;

import lombok.*;

import java.math.BigDecimal;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Account {
  @NonNull
  String number;
  @NonNull
  BigDecimal balance;
  @NonNull
  String name;
  @NonNull
  AccountType type;
}
