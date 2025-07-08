package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.*;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.service.*;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    @Autowired
    private CountryService countryService;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private SkillService skillService;

    @Autowired
    private AttemptService attemptService;




    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args)
                .getBean(OrmLearnApplication.class)
                .runAll();
    }

    // kick off everything
    @Transactional
    public void runAll() {
        try {
            LOGGER.info("Running OrmLearn test cases...");

            testGetAllCountries();
            testFindCountryByCode();
            testAddCountry();
            testUpdateCountry();
            testDeleteCountry();
            testFindCountriesByPartialName();
            testGetCountryAfterDelete();

            testFacebookStocksInSep2019();
            testGoogleStockPriceGreaterThan1250();
            testTop3HighestVolume();
            testNetflixLowestPrices();

            testGetEmployee();
            testGetDepartment();
            testAddSkillToEmployee();
            testGetAllPermanentEmployees();

            testGetAttempt();
            testGetAverageSalary();
            testGetAllEmployeesNative();

        } catch (Exception e) {
            LOGGER.error("Error running tests: {}", e.getMessage(), e);
        }
    }

    private void testGetAllCountries() {
        LOGGER.info("Start testGetAllCountries");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("Countries: {}", countries);
        LOGGER.info("End testGetAllCountries");
    }

    private void testFindCountryByCode() {
        LOGGER.info("Start testFindCountryByCode");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found: {}", e.getMessage());
        }
        LOGGER.info("End testFindCountryByCode");
    }

    private void testAddCountry() {
        LOGGER.info("Start testAddCountry");
        Country newCountry = new Country();
        newCountry.setCode("ZZ");
        newCountry.setName("Zetaland");
        countryService.addCountry(newCountry);
        LOGGER.debug("Added country: {}", newCountry);
        LOGGER.info("End testAddCountry");
    }

    private void testUpdateCountry() {
        LOGGER.info("Start testUpdateCountry");
        try {
            Country country = countryService.findCountryByCode("ZZ");
            country.setName("Zetaland Updated");
            countryService.updateCountry(country);
            LOGGER.debug("Updated country: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found for update: {}", e.getMessage());
        }
        LOGGER.info("End testUpdateCountry");
    }

    private void testDeleteCountry() {
        LOGGER.info("Start testDeleteCountry");
        try {
            countryService.deleteCountry("ZZ");
            LOGGER.info("Deleted country with code ZZ");
        } catch (Exception e) {
            LOGGER.error("Error deleting country ZZ: {}", e.getMessage());
        }
        LOGGER.info("End testDeleteCountry");
    }

    private void testFindCountriesByPartialName() {
        LOGGER.info("Start testFindCountriesByPartialName");
        List<Country> countries = countryService.findCountriesByPartialName("uni");
        LOGGER.debug("Countries with partial name 'uni': {}", countries);
        LOGGER.info("End testFindCountriesByPartialName");
    }

    private void testGetCountryAfterDelete() {
        LOGGER.info("Start testGetCountryAfterDelete");
        try {
            countryService.findCountryByCode("ZZ");
            LOGGER.warn("Country ZZ still exists after delete (should not happen)");
        } catch (CountryNotFoundException e) {
            LOGGER.info("Country ZZ correctly not found after delete (as expected)");
        }
        LOGGER.info("End testGetCountryAfterDelete");
    }

    private void testFacebookStocksInSep2019() throws ParseException {
        LOGGER.info("Start testFacebookStocksInSep2019");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start = sdf.parse("2019-09-01");
        Date end = sdf.parse("2019-09-30");
        List<Stock> stocks = stockRepository.findByCodeAndDateBetween("FB", start, end);
        LOGGER.debug("Facebook stocks in Sept 2019: {}", stocks);
        LOGGER.info("End testFacebookStocksInSep2019");
    }

    private void testGoogleStockPriceGreaterThan1250() {
        LOGGER.info("Start testGoogleStockPriceGreaterThan1250");
        List<Stock> stocks = stockRepository.findByCodeAndCloseGreaterThan("GOOGL", 1250);
        LOGGER.debug("Google stocks > 1250: {}", stocks);
        LOGGER.info("End testGoogleStockPriceGreaterThan1250");
    }

    private void testTop3HighestVolume() {
        LOGGER.info("Start testTop3HighestVolume");
        List<Stock> stocks = stockRepository.findTop3ByOrderByVolumeDesc();
        LOGGER.debug("Top 3 volume stocks: {}", stocks);
        LOGGER.info("End testTop3HighestVolume");
    }

    private void testNetflixLowestPrices() {
        LOGGER.info("Start testNetflixLowestPrices");
        List<Stock> stocks = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
        LOGGER.debug("Lowest Netflix prices: {}", stocks);
        LOGGER.info("End testNetflixLowestPrices");
    }

    @Transactional
    private void testGetEmployee() {
        LOGGER.info("Start testGetEmployee");
        Employee emp = employeeService.get(1);
        LOGGER.debug("Employee: {}", emp);
        LOGGER.debug("Department: {}", emp.getDepartment());
        for (Skill skill : emp.getSkillList()) {
            LOGGER.debug("Skill: {}", skill.getName());
        }
        LOGGER.info("End testGetEmployee");
    }

    @Transactional
    private void testGetDepartment() {
        LOGGER.info("Start testGetDepartment");
        Department dept = departmentService.get(1);
        LOGGER.debug("Department: {}", dept);
        for (Employee e : dept.getEmployeeList()) {
            LOGGER.debug("Employee in dept: {}", e.getName());
        }
        LOGGER.info("End testGetDepartment");
    }

    @Transactional
    private void testAddSkillToEmployee() {
        LOGGER.info("Start testAddSkillToEmployee");
        Employee emp = employeeService.get(1);
        Skill skill = skillService.get(2);
        emp.getSkillList().add(skill);
        employeeService.save(emp);
        for (Skill s : emp.getSkillList()) {
            LOGGER.debug("Employee now has skill: {}", s.getName());
        }
        LOGGER.info("End testAddSkillToEmployee");
    }

    @Transactional
    private void testGetAllPermanentEmployees() {
        LOGGER.info("Start testGetAllPermanentEmployees");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent Employees: {}", employees);
        employees.forEach(e -> LOGGER.debug("Skills: {}", e.getSkillList()));
        LOGGER.info("End testGetAllPermanentEmployees");
    }
    private void testGetAttemptDetails() {
        LOGGER.info("Start testGetAttemptDetails");
        Attempt attempt = attemptService.getAttempt(1, 1);
        // print details
        LOGGER.debug("Attempt by user: {}", attempt.getUser().getUsername());
        LOGGER.debug("Date: {}", attempt.getAttemptDate());
        for (AttemptQuestion aq : attempt.getAttemptQuestions()) {
            LOGGER.debug("Question: {}", aq.getQuestion().getText());
            for (AttemptOption ao : aq.getAttemptOptions()) {
                LOGGER.debug("Option: {}  Score: {}  Selected: {}",
                        ao.getOption().getText(),
                        ao.getOption().getScore(),
                        ao.isSelected());
            }
        }
        LOGGER.info("End testGetAttemptDetails");
    }
    @Transactional
    public void testGetAttempt() {
        LOGGER.info("Start testGetAttempt");

        int userId = 1;
        int attemptId = 1;
        Attempt attempt = attemptService.getAttempt(userId, attemptId);
        LOGGER.debug("Attempt: {}", attempt);

        for (AttemptQuestion aq : attempt.getAttemptQuestions()) {
            LOGGER.debug("Question: {}", aq.getQuestion().getText());

            for (Option opt : aq.getQuestion().getOptions()) {
                LOGGER.debug("Option: {}", opt.getText());
            }

            for (AttemptOption ao : aq.getAttemptOptions()) {
                LOGGER.debug("Selected Option: {}", ao.getOption().getText());
            }
        }
        LOGGER.info("End testGetAttempt");
    }


    private void testGetAverageSalary() {
        LOGGER.info("Start testGetAverageSalary");

        double overallAvg = employeeService.getAverageSalary();
        LOGGER.info("Overall Average Salary: {}", overallAvg);

        double deptAvg = employeeService.getAverageSalary(1);  // department id 1
        LOGGER.info("Average Salary in Department 1: {}", deptAvg);

        LOGGER.info("End testGetAverageSalary");
    }

    private void testGetAllEmployeesNative() {
        LOGGER.info("Start testGetAllEmployeesNative");
        List<Employee> employees = employeeService.getAllEmployeesNative();
        employees.forEach(emp -> LOGGER.debug("Employee: {}", emp));
        LOGGER.info("End testGetAllEmployeesNative");
    }

}
