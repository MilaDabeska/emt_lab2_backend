package com.example.emt_lab.service.impl;

import com.example.emt_lab.model.Country;
import com.example.emt_lab.repository.CountryRepository;
import com.example.emt_lab.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findByName(String name) {
        return countryRepository.findByName(name);
    }

    @Override
    public Country create(String name, String continent) {
        return  countryRepository.save(new Country(name,continent));
    }
}