package com.bookingsystem.accountservice.facade;

import com.bookingsystem.accountservice.entities.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "customer")
public class CustomerResource {

  @GetMapping("/{customerId}")
  public ResponseEntity<Customer> getCustomerSummaryDetail(
      @PathVariable("customerId") final int customerId) {
    return ResponseEntity.status(HttpStatus.OK).body(new Customer(0, "x", "y", 2));
  }
}
