package com.diyo.nrms.controller;

import com.diyo.nrms.entity.Country;
import com.diyo.nrms.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
public class CountryController {


    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }


    @PostMapping("/createEntry")
    public ResponseEntity<String> createentry(@RequestBody Country country){
        countryService.createentry(country);
        return ResponseEntity.ok("Entry has been added!");
    }


}
