package com.kramatas;


import com.kramatas.rules.model.Customer;
import com.kramatas.rules.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataInitializer implements CommandLineRunner {

    private final CustomerRepository repo;

    public CustomerDataInitializer(CustomerRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        repo.save(new Customer("1", "Alice", 65, 10));
        repo.save(new Customer("2", "Bob", 45, 2));
        repo.save(new Customer("3", "Charlie", 30, 6));
    }
}
