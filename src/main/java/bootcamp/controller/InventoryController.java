package bootcamp.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.model.inventory.InventoryItem;
import bootcamp.model.products.Product;
import bootcamp.service.InventoryService;

@RestController
public class InventoryController {
	@Autowired
	private InventoryService inventoryService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("inventory/all")
	public List<InventoryItem> showInventory(){
		return inventoryService.getInventory();
		
	}
//	
//	@RequestMapping(name = "inventory/receive", method=RequestMethod.POST)
//    public void getProduct(@RequestBody List<Product> products) {
//		log.debug("Receiving products");
//    	inventoryService.receiveInventory(products); 
//    }
	
}
