package bootcamp.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import bootcamp.dao.InventoryDao;
import bootcamp.model.inventory.Inventory;
import bootcamp.model.inventory.InventoryItem;
import bootcamp.model.products.Product;

@Component
public class InventoryService {
	@Autowired
	InventoryDao inventoryDao;
	
	@Autowired
//	private List<Product> inventoryList;
	private static final Logger log = LoggerFactory.getLogger(InventoryService.class);
	 
	 @Autowired
	 private SimpleDateFormat dateFormat;
	
//	public void receiveInventory(List<Product> products) {
//		inventoryList.addAll(products);
//	}

	public Inventory getInventory(){
		List<InventoryItem> inventoryList = inventoryDao.getInventory();
		Inventory inventory = new Inventory();
		inventory.setList(inventoryList);
		return inventory;
	}
	
	@Scheduled(cron = "${inventory.status.schedule}")
    public void inventoryStatus() {
        log.info("Checking on inventory status at {}", dateFormat.format(new Date()));
        log.debug("Debug goes here");
    }
}
