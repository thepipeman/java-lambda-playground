package io.pipecrafts.lambda.stream.advanced;

import io.pipecrafts.lambda.stream.basic.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class CollectingStream {

  public static void main(String[] args) {
    List<Account> accounts = SampleUtil.sampleData();

    // reduce
//    accounts.stream()
//      .reduce(
//        new ArrayList<>(),
//        (list, account) -> {
//          List<String> nameList = new ArrayList<>(list);
//          nameList.add(account.getName());
//          return nameList;
//        },
//        (list1, list2) -> {
//          List<String> newList = new ArrayList<>(list1);
//          newList.addAll(list2);
//          return newList;
//        }
//      );

    List<String> accountNames = accounts.stream()
      .collect(ArrayList::new, (list, account) -> list.add(account.getName()), ArrayList::addAll);
    System.out.println(accountNames);


    Map<AccountType, BigDecimal> totalPerType = accounts.stream()
      .collect(Collectors.toMap(
        Account::getType,
        Account::getBalance,
        BigDecimal::add
      ));
    System.out.println(totalPerType);
  }
}
