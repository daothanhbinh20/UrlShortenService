package com.bookingsystem.accountservice.service;

import com.bookingsystem.accountservice.entities.CustomerDetail;
import com.bookingsystem.accountservice.repository.CustomerDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {
  private CustomerDetailRepository customerDetailRepository;

  @Autowired
  public CustomerService(CustomerDetailRepository customerDetailRepository) {
    this.customerDetailRepository = customerDetailRepository;
  }

  public CustomerDetail getCustomerDetail(final int customerId) {
    return this.customerDetailRepository.getCustomerDetail(customerId);
  }
}
