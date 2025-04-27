package com.kramatas.rules.repository;

import com.kramatas.rules.model.Phone;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PhoneRepository extends Neo4jRepository<Phone, Long> {
    Phone findByModel(String model);
}
