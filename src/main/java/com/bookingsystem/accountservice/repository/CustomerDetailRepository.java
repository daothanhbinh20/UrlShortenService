package com.bookingsystem.accountservice.repository;

import com.bookingsystem.accountservice.entities.CustomerDetail;

public interface CustomerDetailRepository {

  CustomerDetail getCustomerDetail(final int customerId);
}
