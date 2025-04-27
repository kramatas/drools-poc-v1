package com.kramatas.rules.controller;


import com.kramatas.rules.model.Customer;
import com.kramatas.rules.service.DiscountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final DiscountService discountService;

    public CustomerController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping("/{id}/discount")
    public Optional<Customer> applyDiscount(@PathVariable String id) {
        return discountService.applyDiscount(id);
    }
}
