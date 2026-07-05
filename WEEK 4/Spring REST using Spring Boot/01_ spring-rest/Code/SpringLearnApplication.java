package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringLearnApplication.class, args);
		LOGGER.info("START");

		SpringLearnApplication app = new SpringLearnApplication();
		app.displayDate();
		app.displayCountry();
		app.displayCountries();

		LOGGER.info("END");
	}

	// HO2 + HO3 - load date format from XML and parse a date
	public void displayDate() throws ParseException {
		LOGGER.info("START");

		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		Date date = format.parse("31/12/2018");
		LOGGER.debug("date={}", date);

		LOGGER.info("END");
	}

	// HO4 + HO5 - load single country from XML, demonstrate singleton
	public void displayCountry() {
		LOGGER.info("START");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country.toString());

		// HO5: get another reference - constructor only called once (singleton)
		Country anotherCountry = context.getBean("country", Country.class);
		LOGGER.debug("Same instance? {}", country == anotherCountry);

		LOGGER.info("END");
	}

	// HO6 - load list of 4 countries from XML
	public void displayCountries() {
		LOGGER.info("START");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = (List<Country>) context.getBean("countryList");
		LOGGER.debug("Countries : {}", countries);

		LOGGER.info("END");
	}
}
