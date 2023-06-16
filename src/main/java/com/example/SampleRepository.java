package com.example;

import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;

import java.util.UUID;

@MongoRepository
public interface SampleRepository extends CrudRepository<Sample, UUID> {
}
