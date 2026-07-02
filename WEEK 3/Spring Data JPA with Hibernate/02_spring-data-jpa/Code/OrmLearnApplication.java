package com.cognizant.ormlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;
	private static StockRepository stockRepository;
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;

	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		stockRepository = context.getBean(StockRepository.class);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);

		// HO1
		testSearchCountries();
		testCountriesStartingWith();

		// HO2
		testFbStocksSep2019();
		testGoogleStocksAbove1250();
		testTop3ByVolume();
		testTop3NetflixLowest();

		// HO4
		testGetEmployee();
		testAddEmployee();
		testUpdateEmployee();

		// HO5
		testGetDepartment();

		// HO6
		testAddSkillToEmployee();
	}

	// HO1
	private static void testSearchCountries() {
		LOGGER.info("Start");
		List<Country> list = countryService.searchByName("ou");
		LOGGER.debug("countries={}", list);
		LOGGER.info("End");
	}

	private static void testCountriesStartingWith() {
		LOGGER.info("Start");
		List<Country> list = countryService.getCountriesStartingWith("Z");
		LOGGER.debug("countries={}", list);
		LOGGER.info("End");
	}

	// HO2
	private static void testFbStocksSep2019() throws ParseException {
		LOGGER.info("Start");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date start = sdf.parse("2019-09-01");
		Date end = sdf.parse("2019-09-30");
		List<Stock> list = stockRepository.findByCodeAndDateBetween("FB", start, end);
		LOGGER.debug("FB Sep 2019={}", list);
		LOGGER.info("End");
	}

	private static void testGoogleStocksAbove1250() {
		LOGGER.info("Start");
		List<Stock> list = stockRepository.findByCodeAndCloseGreaterThan("GOOGL", 1250);
		LOGGER.debug("GOOGL > 1250={}", list);
		LOGGER.info("End");
	}

	private static void testTop3ByVolume() {
		LOGGER.info("Start");
		List<Stock> list = stockRepository.findTop3ByOrderByVolumeDesc();
		LOGGER.debug("Top 3 volume={}", list);
		LOGGER.info("End");
	}

	private static void testTop3NetflixLowest() {
		LOGGER.info("Start");
		List<Stock> list = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
		LOGGER.debug("NFLX lowest 3={}", list);
		LOGGER.info("End");
	}

	// HO4
	private static void testGetEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList());
		LOGGER.info("End");
	}

	private static void testAddEmployee() {
		LOGGER.info("Start");
		Employee e = new Employee();
		e.setName("Asvathama S K");
		e.setSalary(50000);
		e.setPermanent(true);
		e.setDateOfBirth(new Date());
		Department dept = departmentService.get(1);
		e.setDepartment(dept);
		employeeService.save(e);
		LOGGER.debug("Employee:{}", e);
		LOGGER.info("End");
	}

	private static void testUpdateEmployee() {
		LOGGER.info("Start");
		Employee e = employeeService.get(1);
		Department dept = departmentService.get(2);
		e.setDepartment(dept);
		employeeService.save(e);
		LOGGER.debug("Updated Employee:{}", e);
		LOGGER.info("End");
	}

	// HO5
	private static void testGetDepartment() {
		LOGGER.info("Start");
		Department dept = departmentService.get(1);
		LOGGER.debug("Department:{}", dept);
		LOGGER.debug("Employees:{}", dept.getEmployeeList());
		LOGGER.info("End");
	}

	// HO6
	private static void testAddSkillToEmployee() {
		LOGGER.info("Start");
		Employee e = employeeService.get(1);
		Skill skill = skillService.get(3);
		e.getSkillList().add(skill);
		employeeService.save(e);
		LOGGER.debug("Skills after add:{}", e.getSkillList());
		LOGGER.info("End");
	}
}
