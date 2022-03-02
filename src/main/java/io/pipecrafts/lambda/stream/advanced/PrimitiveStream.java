package io.pipecrafts.lambda.stream.advanced;

import io.pipecrafts.lambda.stream.basic.Account;
import io.pipecrafts.lambda.stream.basic.SampleUtil;

import java.util.List;
import java.util.stream.DoubleStream;

public class PrimitiveStream {

  public static void main(String[] args) {
    List<Account> accounts = SampleUtil.sampleData();

    DoubleStream balances = accounts.stream()
      .mapToDouble(account -> account.getBalance().doubleValue());
    double total = balances.sum();
    System.out.println(total);

  }
}
