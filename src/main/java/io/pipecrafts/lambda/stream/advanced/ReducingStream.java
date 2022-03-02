package io.pipecrafts.lambda.stream.advanced;

import io.pipecrafts.lambda.stream.basic.Account;
import io.pipecrafts.lambda.stream.basic.SampleUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class ReducingStream {

  public static void main(String[] args) {
    List<Account> accounts = SampleUtil.sampleData();

    Optional<BigDecimal> optionalTotalBalance = accounts.stream()
      .map(Account::getBalance)
      .reduce(BigDecimal::add);
    System.out.println(optionalTotalBalance.get());

    BigDecimal totalBalance = accounts.stream()
      .map(Account::getBalance)
      .reduce(BigDecimal.ZERO, BigDecimal::add);
    System.out.println(totalBalance);

    BigDecimal totalBal2 = accounts.stream()
      .reduce(BigDecimal.ZERO, (result, account) -> result.add(account.getBalance()), BigDecimal::add);
    System.out.println(totalBal2);
  }
}
