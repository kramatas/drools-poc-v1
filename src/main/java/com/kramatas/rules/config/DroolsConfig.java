package com.kramatas.rules.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig {

    @Bean
    public KieContainer kieContainer() {
        // Obtain KieServices instance
        KieServices kieServices = KieServices.Factory.get();

        // Create KieFileSystem for writing DRL files
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();

        // Load the DRL file from the classpath as a Resource
        Resource phoneDiscountResource = kieServices.getResources().newClassPathResource("rules/phone-discount-rules.drl");
        Resource customerDiscountResource = kieServices.getResources().newClassPathResource("rules/customer-discount-rules.drl");

        // Write the DRL file to the KieFileSystem
        kieFileSystem.write(phoneDiscountResource);
        kieFileSystem.write(customerDiscountResource);

        // Build the KieModule from the written files
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();

        // Create and return the KieContainer with the built module
        return kieServices.newKieContainer(kieBuilder.getKieModule().getReleaseId());
    }

    @Bean
    public KieSession kieSession() {
        return kieContainer().newKieSession();
    }
}
