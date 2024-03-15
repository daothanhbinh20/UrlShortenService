package com.bookingsystem.accountservice.entities;

import java.sql.Timestamp;
import java.util.Objects;

public class RedirectMapping {
  final String shortKey;
  final String longUrl;
  final Timestamp CreatedTime;

  public RedirectMapping(final String shortKey, final String longUrl, final Timestamp createdTime) {
    this.shortKey = shortKey;
    this.longUrl = longUrl;
    CreatedTime = createdTime;
  }

  public String getShortKey() {
    return shortKey;
  }

  public String getLongUrl() {
    return longUrl;
  }

  public Timestamp getCreatedTime() {
    return CreatedTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RedirectMapping that = (RedirectMapping) o;
    return Objects.equals(shortKey, that.shortKey)
        && Objects.equals(longUrl, that.longUrl)
        && Objects.equals(CreatedTime, that.CreatedTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shortKey, longUrl, CreatedTime);
  }

  @Override
  public String toString() {
    return "RedirectMapping{"
        + "shortKey='"
        + shortKey
        + '\''
        + ", longUrl='"
        + longUrl
        + '\''
        + ", CreatedTime="
        + CreatedTime
        + '}';
  }
}
