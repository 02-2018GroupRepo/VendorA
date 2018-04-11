package bootcamp.model.company;

import bootcamp.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Company {
    @Autowired
    InventoryService inventoryService;

    private double cash = 5000.00;

    public double getCash() {
        return cash;
    }

    public void addCash(double cash) {
        this.cash += cash;
    }

    public void subtractCash(double cash) {
        this.cash -= cash;
    }

    public double getInventoryValue() {
        return inventoryService.getInventoryWholeSaleValue();
    }

}
