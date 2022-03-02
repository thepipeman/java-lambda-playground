package io.pipecrafts.lambda.stream.advanced;

import io.pipecrafts.lambda.stream.basic.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingStream {

  public static void main(String[] args) {
    List<Account> accounts = SampleUtil.sampleData();

    Map<AccountType, List<String>> accountNamesByType = accounts.stream()
      .collect(Collectors.groupingBy(Account::getType, Collectors.mapping(Account::getName, Collectors.toList())));
    System.out.println(accountNamesByType);

    Map<AccountType, BigDecimal> totalPerType = accounts.stream()
      .collect(Collectors.groupingBy(
        Account::getType,
        // maps the balance first
        // then reduces it to sum up
        Collectors.mapping(Account::getBalance, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
      ));
    System.out.println(totalPerType);
  }
}
