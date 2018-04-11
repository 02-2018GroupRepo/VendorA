package bootcamp.controller;

import bootcamp.model.company.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class FinancialController {
    @Autowired
    Company company;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/company")
    public Double[] company() {
        log.info("Sending company values to financial analysts");
        Double[] companyList = {company.getCash(), company.getInventoryValue()};
        return companyList;
    }
}
