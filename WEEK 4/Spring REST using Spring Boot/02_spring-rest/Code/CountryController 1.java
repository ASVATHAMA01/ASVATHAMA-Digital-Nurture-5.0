package com.cognizant.springlearn.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;
import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

	@Autowired
	CountryService countryService;

	public CountryController() {
		LOGGER.debug("Inside CountryController constructor");
	}

	@RequestMapping("/country")
	public Country getCountryIndia() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("country", Country.class);
		LOGGER.debug("country={}", country);
		LOGGER.info("END");
		return country;
	}

	@GetMapping("/countries")
	public List<Country> getAllCountries() {
		LOGGER.info("START");
		List<Country> list = countryService.getAllCountries();
		LOGGER.debug("countries={}", list);
		LOGGER.info("END");
		return list;
	}

	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
		LOGGER.info("START");
		Country country = countryService.getCountry(code);
		LOGGER.info("END");
		return country;
	}
}
