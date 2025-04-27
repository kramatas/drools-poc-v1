package com.kramatas;

import com.kramatas.rules.model.Phone;
import com.kramatas.rules.repository.PhoneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PhoneDiscountInitializer implements CommandLineRunner {

    private final PhoneRepository phoneRepository;

    public PhoneDiscountInitializer(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        initializeData();
    }

    private void initializeData() {
        // Create and Save Phones if they do not already exist
        createPhoneIfNotExist("iPhone 15", "Apple", "5G Trade", "5G", "iOS", "eSIM");
        createPhoneIfNotExist("Pixel 8", "Google", "Free", "5G", "Android", "Physical SIM");
        createPhoneIfNotExist("Motorola Edge", "Motorola", "Free", "4G", "Android", "Physical SIM");
        createPhoneIfNotExist("Nokia G50", "Nokia", "Free", "4G", "Android", "Physical SIM");
        createPhoneIfNotExist("Samsung Galaxy S21", "Samsung", "5G Trade", "5G", "Android", "eSIM");
        createPhoneIfNotExist("OnePlus 9", "OnePlus", "Free", "4G", "Android", "Physical SIM");
        createPhoneIfNotExist("Huawei P40", "Huawei", "5G Trade", "5G", "Android", "eSIM");
        createPhoneIfNotExist("Xiaomi Mi 11", "Xiaomi", "Free", "4G", "Android", "Physical SIM");

        System.out.println("✅ Sample data initialized successfully.");
    }

    private void createPhoneIfNotExist(String model, String brand, String deal, String network, String operatingSystem, String simType) {
        // Check if the phone already exists in the database
        Phone existingPhone = phoneRepository.findByModel(model);
        if (existingPhone == null) {
            Phone newPhone = new Phone(model, brand, deal, network, operatingSystem, simType);
            phoneRepository.save(newPhone);
            System.out.println("Created phone: " + model);
        } else {
            System.out.println("Phone already exists: " + model);
        }
    }
}
