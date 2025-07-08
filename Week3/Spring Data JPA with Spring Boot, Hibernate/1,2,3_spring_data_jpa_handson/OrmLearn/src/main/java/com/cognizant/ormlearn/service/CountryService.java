package com.cognizant.ormlearn.service;

import java.util.List;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

public interface CountryService {
    List<Country> getAllCountries();
    Country findCountryByCode(String code) throws CountryNotFoundException;
    void addCountry(Country country);
    void updateCountry(Country country) throws CountryNotFoundException;
    void deleteCountry(String code);
    List<Country> findCountriesByPartialName(String partialName);
}
