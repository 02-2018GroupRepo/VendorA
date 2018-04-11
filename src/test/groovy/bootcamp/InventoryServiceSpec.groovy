package bootcamp

import bootcamp.dao.InventoryDao
import bootcamp.model.inventory.InventoryItem
import bootcamp.service.InventoryService
import bootcamp.service.OrderService
import spock.lang.Specification

class InventoryServiceSpec extends Specification {
//	def "Check for restock"() {
//		given: "An inventory service"
//		InventoryService inventoryService = new InventoryService();
//
//		and: "An inventory dao"
//		InventoryDao inventoryDao = Stub(InventoryDao.class);
//
//		and: "An order service"
//		OrderService orderService = Mock(OrderService.class)
//		inventoryService.orderService = orderService;
//
//		and: "Low inventory is returned"
//		InventoryItem inventoryItem = new InventoryItem();
//		inventoryItem.setId(1);
//		inventoryItem.setRetail_price(1.00);
//		inventoryItem.setNumber_available(5);
//		List<InventoryItem> lowInventoryList = new ArrayList<InventoryItem>();
//		lowInventoryList.add(inventoryItem);
//		inventoryDao.getLowInventory() >> lowInventoryList;
//		inventoryService.inventoryDao = inventoryDao;
//
//		when: "Check for restock is called"
//		inventoryService.checkInventoryForRestock();
//
//		then: "Order service makes order"
//		1 * orderService.createOrder(lowInventoryList);
//	}
}
