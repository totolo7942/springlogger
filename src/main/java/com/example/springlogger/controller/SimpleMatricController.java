package com.example.springlogger.controller;

import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SimpleMatricController {

    //NOTE: https://www.baeldung.com/micrometer
    @GetMapping("/count/inc")
    public List<Tag> count() {
        List<Tag> tags = List.of(
                Tag.of("my_label_a", "A"),
                Tag.of("my_label_b", "B")
        );


        Metrics.counter("my.demo.count.total", tags).increment();
        return tags;
    }
}
