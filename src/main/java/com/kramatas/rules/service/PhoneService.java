package com.kramatas.rules.service;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.kramatas.rules.dto.PhoneFilterRequest;
import com.kramatas.rules.model.Phone;
import com.kramatas.rules.repository.PhoneRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;
    private final KieContainer kieContainer;

    // Create a Caffeine cache instance to cache all phones
    private final Cache<String, List<Phone>> phoneCache;

    @Autowired
    public PhoneService(PhoneRepository phoneRepository, KieContainer kieContainer) {
        this.phoneRepository = phoneRepository;
        this.kieContainer = kieContainer;

        // Initialize the cache with a 10-minute expiration time for each entry
        this.phoneCache = Caffeine.newBuilder()
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .maximumSize(100)  // Adjust the cache size as needed
                .build();
    }

    public List<Phone> filterPhones(PhoneFilterRequest request) {
        // Generate a cache key based on the filter request attributes
        String cacheKey = "allPhones";

        // Check if the list of all phones is already cached
        List<Phone> allPhones = phoneCache.getIfPresent(cacheKey);
        if (allPhones == null) {
            // If not cached, fetch the phones from the repository and cache them
            allPhones = phoneRepository.findAll();
            phoneCache.put(cacheKey, allPhones);
        }

        // Create a new session for each request to ensure no state is carried over
        KieSession kieSession = kieContainer.newKieSession();

        // Clear the matchedPhones list before each request
        List<Phone> matchedPhones = new ArrayList<>();

        // Set the global variables for the request and matchedPhones list
        kieSession.setGlobal("request", request);
        kieSession.setGlobal("matchedPhones", matchedPhones);

        // Insert the request into the Drools session
        kieSession.insert(request);

        // Insert phones into the Drools session
        Set<Phone> processedPhones = new HashSet<>();  // To avoid duplicates

        for (Phone phone : allPhones) {
            // Insert only if phone is not already processed
            if (processedPhones.add(phone)) {
                kieSession.insert(phone);
            }
        }

        // Fire all Drools rules once
        kieSession.fireAllRules();

        // Clean up the session
        kieSession.dispose();

        // Return the matched phones
        return matchedPhones;
    }
}
