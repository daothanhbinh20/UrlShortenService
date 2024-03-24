package com.bookingsystem.accountservice.repository;

import com.bookingsystem.accountservice.entities.RedirectMapping;

public interface RedirectRepository {
  public RedirectMapping getRedirectMapping(final String shortKey);

  public void createRedirectMapping(final String longUrl, final String shortKey);
}
