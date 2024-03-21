package com.bookingsystem.accountservice;

import java.util.Objects;

public record ShortenUrlResponseEntity(String urlShortKey) {

  @Override
  public String toString() {
    return "ShortenUrlResponseEntity{" +
        "urlShortKey='" + urlShortKey + '\'' +
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
    ShortenUrlResponseEntity that = (ShortenUrlResponseEntity) o;
    return Objects.equals(urlShortKey, that.urlShortKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(urlShortKey);
  }
}
