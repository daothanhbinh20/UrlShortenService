package com.bookingsystem.accountservice;

import java.util.Objects;

public record ShortenUrlRequestEntity(String longUrl) {

  @Override
  public String toString() {
    return "ShortenUrlRequestEntity{" +
        "longUrl='" + longUrl + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShortenUrlRequestEntity that = (ShortenUrlRequestEntity) o;
    return Objects.equals(longUrl, that.longUrl);
  }

}
