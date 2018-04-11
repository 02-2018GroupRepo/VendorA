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
	
//	public void receiveInventory(List<Product> products) {
//		inventoryList.addAll(products);
//	}

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

	public void addToInventory(int productID, int quantityAdded, double wholeSalePrice){
		inventoryDao.addToInventory(productID, quantityAdded, wholeSalePrice);
	}
	
	@Scheduled(cron = "${inventory.status.schedule}")
    public void inventoryStatus() {
        log.info("Checking on inventory status at {}", dateFormat.format(new Date()));
        log.debug("Debug goes here");
    }
}
