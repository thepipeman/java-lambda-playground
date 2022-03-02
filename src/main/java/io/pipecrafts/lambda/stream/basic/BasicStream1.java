package io.pipecrafts.lambda.stream.basic;

import java.util.List;

public class BasicStream1 {

  public static void main(String[] args) {
    final List<Account> accounts = SampleUtil.sampleData();
    accounts.stream().map(a -> {
      System.out.println(a);
      return a;
    });
  }
}
