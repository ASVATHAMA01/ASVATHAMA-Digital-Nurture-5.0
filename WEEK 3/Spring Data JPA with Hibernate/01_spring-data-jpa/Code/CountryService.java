package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // HO5 - get all countries
    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    // HO6 - find by code
    @Transactional
    public Country findCountryByCode(String code) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(code);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("country not found: " + code);
        }
        return result.get();
    }

    // HO7 - add country
	@Transactional
	public void addCountry(Country country) {
		countryRepository.save(country);
	}

    // HO8 - update country name
	@Transactional
	public void updateCountry(String code, String name) throws CountryNotFoundException {
		Country country = findCountryByCode(code);
		country.setName(name);
		countryRepository.save(country);
	}

    // HO9 - delete country
	@Transactional
	public void deleteCountry(String code) {
		countryRepository.deleteById(code);
	}
}
