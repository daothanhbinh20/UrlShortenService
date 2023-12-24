package com.bookingsystem.accountservice.facade;

import com.bookingsystem.accountservice.entities.CustomerDetail;
import com.bookingsystem.accountservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "customer")
public class CustomerResource {

  private CustomerService customerService;

  @Autowired
  public CustomerResource(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/{customerId}")
  public ResponseEntity<CustomerDetail> getCustomerSummaryDetail(
      @PathVariable("customerId") final int customerId) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(this.customerService.getCustomerDetail(customerId));
  }
}
