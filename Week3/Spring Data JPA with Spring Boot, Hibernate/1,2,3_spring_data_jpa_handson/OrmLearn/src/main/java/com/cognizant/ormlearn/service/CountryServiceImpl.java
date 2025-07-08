package com.cognizant.ormlearn.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import com.cognizant.ormlearn.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country findCountryByCode(String code) throws CountryNotFoundException {
        return countryRepository.findById(code)
                .orElseThrow(() -> new CountryNotFoundException("Country not found with code: " + code));
    }

    @Override
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    @Override
    @Transactional
    public void updateCountry(Country country) throws CountryNotFoundException {
        Country existingCountry = countryRepository.findById(country.getCode())
                .orElseThrow(() -> new CountryNotFoundException("Country not found with code: " + country.getCode()));
        existingCountry.setName(country.getName());
        countryRepository.save(existingCountry);
    }

    @Override
    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    @Override
    public List<Country> findCountriesByPartialName(String partialName) {
        return countryRepository.findByNameContainingIgnoreCase(partialName);
    }
}
