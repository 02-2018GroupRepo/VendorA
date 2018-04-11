package bootcamp.controller;

import bootcamp.model.inventory.InventoryItem;
import bootcamp.model.invoice.Invoice;
import bootcamp.model.payment.Payment;
import bootcamp.model.products.Product;
import bootcamp.service.InventoryService;
import bootcamp.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

	@RequestMapping("inventory/{id}")
    public InventoryItem showInventoryById(@PathVariable Integer id){
        log.debug("Retreiving product " + id);
        return inventoryService.getInventoryItemById(id);

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
		Product invoicedProduct = new Product();
		invoicedProduct.setId(1);
		invoicedProduct.setName("Cola");
		invoicedProduct.setDescription("");
		invoicedProduct.setRetail_price(BigDecimal.valueOf(2.00));
		invoicedProduct.setWholesale_price(BigDecimal.valueOf(1.90));
		Invoice invoice = new Invoice(invoicedProduct, 5);
		return invoice;
	}

	@PostMapping("/payment")
	public Boolean payment(@RequestBody Payment payment) {
		return true;
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
