package com.example.emt_lab.service;

import com.example.emt_lab.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> findByName(String name);

    Country create(String name, String continent);
}
