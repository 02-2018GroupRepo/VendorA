package bootcamp.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import bootcamp.model.invoice.Invoice;
import bootcamp.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import bootcamp.model.inventory.InventoryItem;
import bootcamp.model.products.Product;
import bootcamp.service.InventoryService;

@RestController
public class InventoryController {
	@Autowired
	private InventoryService inventoryService;

	@Autowired
	private OrderService orderService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("inventory/all")
	public List<InventoryItem> showInventory(){
		return inventoryService.getInventory();
	}

	@RequestMapping("/testLowestPrice")
	public void testLowestPrice() {
		InventoryItem inventoryItem = new InventoryItem();
		inventoryItem.setId(1);
		inventoryItem.setRetail_price(BigDecimal.valueOf(1.00));
		inventoryItem.setNumber_available(5);
		List<InventoryItem> lowInventoryList = new ArrayList<InventoryItem>();
		lowInventoryList.add(inventoryItem);
		orderService.createOrderList(lowInventoryList);
	}

	@PostMapping("/order")
	public Invoice order() {
		return new Invoice();
	}

	@RequestMapping("makeApiCalls")
	public void pingStuff() {
		orderService.makeApiCalls();
	}

	@RequestMapping("inventory/A")
	public List<InventoryItem> showInventoryA(){
		return inventoryService.getInventory();
	}

	@RequestMapping("inventory/B")
	public List<InventoryItem> showInventoryB(){
		return inventoryService.getInventory();
	}

	@RequestMapping("inventory/C")
	public List<InventoryItem> showInventoryC(){
		return inventoryService.getInventory();
	}
//
//	@RequestMapping(name = "inventory/receive", method=RequestMethod.POST)
//    public void getProduct(@RequestBody List<Product> products) {
//		log.debug("Receiving products");
//    	inventoryService.receiveInventory(products); 
//    }
	
}
