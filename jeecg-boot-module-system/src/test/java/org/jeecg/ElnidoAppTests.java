package org.jeecg;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  MaterialTest.class,
  BankTest.class,
  CompanyTest.class,
  VendorTest.class,
  ProjectTest.class,
  CustomerTest.class,
  PurchaseContractTest.class,
  ElnidoUtilTest.class
})
public class ElnidoAppTests {
}
