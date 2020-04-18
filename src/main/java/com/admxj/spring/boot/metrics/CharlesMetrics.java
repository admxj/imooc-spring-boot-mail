package com.admxj.spring.boot.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admxj
 */
@Component
public class CharlesMetrics implements MeterBinder {

    public Counter counter1;
    public Counter counter2;
    public Counter counter3;

    public Map<String, Double> map;

    public CharlesMetrics() {
        this.map = new HashMap<>();
    }

    @Override
    public void bindTo(MeterRegistry meterRegistry) {

        this.counter1 = Counter.builder("charles.demo.counter").tags(new String[]{"name", "counter1"}).description("first counter").register(meterRegistry);
        this.counter2 = Counter.builder("charles.demo.counter").tags(new String[]{"name", "counter2"}).description("first counter").register(meterRegistry);
        this.counter3 = Counter.builder("charles.demo.counter").tags(new String[]{"name", "counter3"}).description("second counter").register(meterRegistry);

        Gauge.builder("charles.demo.gauge", map, x -> x.get("x")).tag("name", "gauge1").description("This is Guage").register(meterRegistry);
    }
}
