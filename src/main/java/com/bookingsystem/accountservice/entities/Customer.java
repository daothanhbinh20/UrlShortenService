package com.bookingsystem.accountservice.entities;

import java.util.Objects;

public class Customer {
  private final int customerId;
  private final String email;
  private final String name;
  private final int phoneNumber;

  public Customer(int customerId, String email, String name, int phoneNumber) {
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

  public int getPhoneNumber() {
    return phoneNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Customer customer = (Customer) o;
    return customerId == customer.customerId
        && phoneNumber == customer.phoneNumber
        && Objects.equals(email, customer.email)
        && Objects.equals(name, customer.name);
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
