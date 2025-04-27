package com.kramatas.rules.repository;

import com.kramatas.rules.model.Customer;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CustomerRepository extends Neo4jRepository<Customer, String> {
}
