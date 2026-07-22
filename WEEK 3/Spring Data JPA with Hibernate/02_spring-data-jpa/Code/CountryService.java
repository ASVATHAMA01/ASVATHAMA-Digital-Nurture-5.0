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

	@Transactional
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	@Transactional
	public Country findCountryByCode(String code) throws CountryNotFoundException {
		Optional<Country> result = countryRepository.findById(code);
		if (!result.isPresent()) {
			throw new CountryNotFoundException("country not found: " + code);
		}
		return result.get();
	}

	@Transactional
	public void addCountry(Country country) {
		countryRepository.save(country);
	}

	@Transactional
	public void updateCountry(String code, String name) throws CountryNotFoundException {
		Country country = findCountryByCode(code);
		country.setName(name);
		countryRepository.save(country);
	}

	@Transactional
	public void deleteCountry(String code) {
		countryRepository.deleteById(code);
	}

	// HO1 - search by text, sorted by name
	@Transactional
	public List<Country> searchByName(String text) {
		return countryRepository.findByNameContainingOrderByName(text);
	}

	// HO1 - starts with letter
	@Transactional
	public List<Country> getCountriesStartingWith(String letter) {
		return countryRepository.findByNameStartingWith(letter);
	}
}
