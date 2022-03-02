package io.pipecrafts.lambda.stream.advanced;

import io.pipecrafts.lambda.stream.basic.Account;
import io.pipecrafts.lambda.stream.basic.SampleUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PartitioningStream {

  public static void main(String[] args) {
    List<Account> accounts = SampleUtil.sampleData();

    final Predicate<Account> partitionPredicate = account -> account.getBalance()
      .compareTo(BigDecimal.valueOf(10000)) < 0;
    Map<Boolean, List<Account>> partitionedAccounts = accounts.stream()
      // can also be implemented with a downstream collector
      .collect(Collectors.partitioningBy(partitionPredicate));
    System.out.println(partitionedAccounts);

    // with custom downstream collector
    Map<Boolean, List<String>> partAccounts2 = accounts.stream()
      .collect(Collectors.partitioningBy(
        partitionPredicate,
        Collectors.mapping(Account::getName, Collectors.toList())
      ));

    System.out.println(partAccounts2);
  }
}
