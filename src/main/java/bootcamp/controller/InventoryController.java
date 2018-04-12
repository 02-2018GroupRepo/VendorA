package bootcamp.controller;

import bootcamp.model.inventory.InventoryItem;

import bootcamp.service.InventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
public class InventoryController {
	@Autowired
	private InventoryService inventoryService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("inventory/all")
	public List<InventoryItem> showInventory(){
		log.info("Retreiving inventory");
		return inventoryService.getInventory();
	}

	@RequestMapping("inventory/{id}")
    public InventoryItem showInventoryById(@PathVariable Integer id){
        log.info("Retreiving inventory by " + id);
        return inventoryService.getInventoryItemById(id);
    }
}
