package com.example;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

import java.util.Optional;

@MicronautTest
class MicronautMongodbIdTest {

    @Inject
    EmbeddedApplication<?> application;

    @Inject
    SampleRepository sampleRepository;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void testAutopopulateId() {
        Sample sample = new Sample();
        sample.setName("Sample1");
        sampleRepository.save(sample);
        Assertions.assertNotNull(sample.getId());
        Optional<Sample> optSample = sampleRepository.findById(sample.getId());
        Assertions.assertTrue(optSample.isPresent());
        Sample loadedSample = optSample.get();
        Assertions.assertEquals(sample.getName(), loadedSample.getName());
        Assertions.assertEquals(sample.getId(), loadedSample.getId());
    }
}
