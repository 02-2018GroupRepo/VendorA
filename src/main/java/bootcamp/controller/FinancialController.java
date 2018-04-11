package bootcamp.controller;

import bootcamp.model.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class FinancialController {
    @Autowired
    Company company;

    @GetMapping("/company")
    public Double[] company() {
        Double[] companyList = {company.getCash(), company.getInventoryValue()};
        return companyList;
    }
}
