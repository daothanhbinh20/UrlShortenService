package com.bookingsystem.accountservice.entities;

import java.util.Objects;

public class CustomerDetail {
  private final int customerId;
  private final String email;
  private final String name;
  private final String phoneNumber;

  public CustomerDetail(int customerId, String email, String name, String phoneNumber) {
    this.customerId = customerId;
    this.email = email;
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public int getCustomerId() {
    return customerId;
  }

  public String getEmail() {
    return email;
  }

  public String getName() {
    return name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CustomerDetail customerDetail = (CustomerDetail) o;
    return customerId == customerDetail.customerId
        && phoneNumber == customerDetail.phoneNumber
        && Objects.equals(email, customerDetail.email)
        && Objects.equals(name, customerDetail.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, email, name, phoneNumber);
  }

  @Override
  public String toString() {
    return "Customer{"
        + "customerId="
        + customerId
        + ", email='"
        + email
        + '\''
        + ", name='"
        + name
        + '\''
        + ", phoneNumber="
        + phoneNumber
        + '}';
  }
}
