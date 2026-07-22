package com.cognizant.ormlearn.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

	// HO1 - search by containing text, sorted by name
	List<Country> findByNameContainingOrderByName(String text);

	// HO1 - countries starting with a letter
	List<Country> findByNameStartingWith(String letter);
}
