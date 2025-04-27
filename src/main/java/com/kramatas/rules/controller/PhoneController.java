package com.kramatas.rules.controller;

import com.kramatas.rules.dto.PhoneFilterRequest;
import com.kramatas.rules.model.Phone;
import com.kramatas.rules.service.PhoneService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/phones")
public class PhoneController {

    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @PostMapping("/filter")
    public List<Phone> filterPhones(@RequestBody PhoneFilterRequest request) {
        return phoneService.filterPhones(request);
    }
}
