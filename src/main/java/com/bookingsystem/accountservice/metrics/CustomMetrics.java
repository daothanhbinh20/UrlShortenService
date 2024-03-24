package com.bookingsystem.accountservice.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class CustomMetrics {
  private final MeterRegistry meterRegistry;

  public CustomMetrics(final MeterRegistry meterRegistry) {
    this.meterRegistry = meterRegistry;
  }
}
