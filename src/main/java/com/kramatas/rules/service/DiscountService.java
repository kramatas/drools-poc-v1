package com.kramatas.rules.service;


import com.kramatas.rules.model.Customer;
import com.kramatas.rules.repository.CustomerRepository;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiscountService {

    private final CustomerRepository repo;
    private final KieSession kieSession;

    public DiscountService(CustomerRepository repo, KieSession kieSession) {
        this.repo = repo;
        this.kieSession = kieSession;
    }

    public Optional<Customer> applyDiscount(String id) {
        Optional<Customer> customer = repo.findById(id);
        customer.ifPresent(c -> {
            kieSession.insert(c);
            kieSession.fireAllRules();
            repo.save(c);
        });
        return customer;
    }
}
