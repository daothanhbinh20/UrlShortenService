package com.bookingsystem.accountservice.repository;

import com.bookingsystem.accountservice.entities.RedirectMapping;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class RedirectSqlRepository implements RedirectRepository {
  private final JdbcTemplate template;

  public RedirectSqlRepository(@Qualifier("mysqlDataSource") final DataSource dataSource) {
    this.template = new JdbcTemplate(dataSource);
  }

  @Override
  public RedirectMapping getRedirectMapping(String shortKey) {
    String getRedirectMappingSql =
        "SELECT ShortKey, LongUrl, CreatedTime " + "From Url_Mapping " + "WHERE ShortKey = ?";
    return template.query(
        getRedirectMappingSql,
        rs -> {
          rs.next();
          return new RedirectMapping(
              rs.getString("ShortKey"), rs.getString("LongUrl"), rs.getTimestamp("CreatedTime"));
        },
        shortKey);
  }

  @Override
  public void createRedirectMapping(String longUrl, String shortKey) {
    String insertRedirectMappingSql =
        "INSERT INTO Url_Mapping (ShortKey, LongUrl, CreatedTime) "
            + "VALUES (?, ?, UTC_TIMESTAMP())";
    template.update(insertRedirectMappingSql, shortKey, longUrl);
  }
}
