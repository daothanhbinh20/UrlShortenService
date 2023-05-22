package com.bookingsystem.accountservice.repository;

import com.bookingsystem.accountservice.entities.CustomerDetail;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomerDetailSqlRepository implements CustomerDetailRepository {
  private final JdbcTemplate template;

  public CustomerDetailSqlRepository(@Qualifier("mysqlDataSource") final DataSource dataSource) {
    this.template = new JdbcTemplate(dataSource);
  }

  @Override
  public CustomerDetail getCustomerDetail(int customerId) {
    String getCustomerDetailSql = "SELECT * FROM Customer WHERE CustomerId = ?;";
    CustomerDetail customerDetail =
        template.query(
            getCustomerDetailSql,
            rs -> {
              rs.next();
              return new CustomerDetail(
                  rs.getInt("CustomerId"),
                  rs.getString("Email"),
                  rs.getString("Name"),
                  rs.getString("PhoneNumber"));
            },
            customerId);
    return customerDetail;
  }
}
