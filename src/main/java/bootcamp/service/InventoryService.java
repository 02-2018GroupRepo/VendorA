package bootcamp.service;

import bootcamp.dao.InventoryDao;
import bootcamp.model.inventory.InventoryItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class InventoryService {
	@Autowired
	InventoryDao inventoryDao;
	
	@Autowired
	OrderService orderService;
	
	private static final Logger log = LoggerFactory.getLogger(InventoryService.class);
	 
	 @Autowired
	 private SimpleDateFormat dateFormat;

	public List<InventoryItem> getInventory(){
		return inventoryDao.getInventory();
	}

	public InventoryItem getInventoryItemById(int id){
		InventoryItem item = new InventoryItem();
		item = inventoryDao.getInventoryItemById(id).get(0);
		return item;
	}

	public void checkInventoryForRestock() {
		List<InventoryItem> lowInventoryList = inventoryDao.getLowInventory();
		if (lowInventoryList.isEmpty() == false) {
			orderService.createOrderList(lowInventoryList);
		}
	}

	public void removeFromInventory(int productID, int quantityRemoved){
		inventoryDao.removeFromInventory(productID, quantityRemoved);
	}

	public void addToInventory(int productID, int quantityAdded, double wholeSalePrice){
		inventoryDao.addToInventory(productID, quantityAdded, wholeSalePrice);
	}

	public double getInventoryWholeSaleValue() {
		List<InventoryItem> inventoryItems = inventoryDao.getInventoryWholeSale();
		double value = 0;
		for (InventoryItem item: inventoryItems) {
			value += (double)item.getNumber_available() * item.getRetail_price().doubleValue();
			// Retail price is actually the wholesale price due to the DAO query
		}
		return value;
	}
	
	@Scheduled(cron = "${inventory.status.schedule}")
    public void inventoryStatus() {
        log.info("Checking on inventory status at {}", dateFormat.format(new Date()));
        log.debug("Debug goes here");
    }
}
