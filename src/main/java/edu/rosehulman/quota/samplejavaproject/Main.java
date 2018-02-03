package edu.rosehulman.quota.samplejavaproject;

import edu.rosehulman.quota.javasdk.*;

public class Main {

  public static void main(String[] args) {
    QuotaService quotaService = QuotaService.getReference("");
    Product product = quotaService.getProductById("theProductId");
    product.addUser("thisIsAUserId");
    User user = product.getUser("thisIsAUserId");
    Quota quota = user.getQuota("theQuotaId");
    quota.setTier("theFreeTierId");

    System.out.println(quota.increment()); // SUCCESS
    System.out.println(quota.increment()); // SUCCESS
    System.out.println(quota.increment()); // SUCCESS
    System.out.println(quota.increment()); // SUCCESS
    System.out.println(quota.increment()); // SUCCESS

    IncrementQuotaStatus incrementQuotaStatusFailure = quota.increment();
    System.out.println(incrementQuotaStatusFailure); // LIMIT_REACHED_FAILURE

    quota.setTier("thePaidTierId");

    System.out.println(quota.increment()); // SUCCESS
    System.out.println(quota.increment()); // SUCCESS
    System.out.println(quota.increment()); // SUCCESS
    System.out.println(quota.increment()); // SUCCESS
    System.out.println(quota.increment()); // SUCCESS

    incrementQuotaStatusFailure = quota.increment();
    System.out.println(incrementQuotaStatusFailure); // LIMIT_REACHED_FAILURE
  }
}
