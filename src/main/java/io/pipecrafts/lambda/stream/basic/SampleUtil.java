package io.pipecrafts.lambda.stream.basic;

import java.math.BigDecimal;
import java.util.*;

public class SampleUtil {

  public static List<Account> sampleData() {
    final List<Account> accounts = new ArrayList<>();
    accounts.add(buildSampleAccount(AccountType.SAVINGS, "John Doe", BigDecimal.valueOf(8000)));
    accounts.add(buildSampleAccount(AccountType.CHECKING, "Jane Doe", BigDecimal.valueOf(30000)));
    accounts.add(buildSampleAccount(AccountType.SAVINGS, "John Foo", BigDecimal.valueOf(20000)));
    accounts.add(buildSampleAccount(AccountType.SAVINGS, "Bruce Wayne", BigDecimal.valueOf(60000)));
    accounts.add(buildSampleAccount(AccountType.CHECKING, "Thorin Oakenshield", BigDecimal.valueOf(5000)));
    return accounts;
  }

  private static Account buildSampleAccount(AccountType type, String name, BigDecimal balance) {
    return Account.builder()
      .balance(balance)
      .number(UUID.randomUUID().toString().replace("-", ""))
      .type(type)
      .name(name)
      .build();
  }
}
