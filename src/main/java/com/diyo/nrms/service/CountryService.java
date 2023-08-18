package com.diyo.nrms.service;

import com.diyo.nrms.entity.Country;
import com.diyo.nrms.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

@Service
public class CountryService {
    private final CountryRepository countryRepository;


    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

/*    public void createentry(Country country){
        countryRepository.save(country);
    }*/

    public void createentry(Country country){
        long daysBetween = ChronoUnit.DAYS.between((Temporal) country.getFromDate(), (Temporal) country.getToDate());

    }
}
