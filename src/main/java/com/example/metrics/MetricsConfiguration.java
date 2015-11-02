package com.example.metrics;

import com.codahale.metrics.MetricRegistry;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mcalavera81 on 01/11/15.
 */

@Configuration
@EnableMetrics
public class MetricsConfiguration {

    @Value("${service.name:unknown}")
    private String serviceName;

    @Value("${service.trimString:unknown}")
    private String trimString;

    @Autowired
    MetricRegistry metricsRegistry;

    /*@Bean
    public PublicMetrics publicMetrics() {
        MetricNamer metricNamer = new MetricNamer(serviceName, trimString);
        return new CodahaleMetricsAdapter(metricNamer, metricsRegistry);
    }*/




}
