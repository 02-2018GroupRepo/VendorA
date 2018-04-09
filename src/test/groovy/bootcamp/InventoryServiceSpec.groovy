package bootcamp

import bootcamp.model.products.Product
import bootcamp.service.InventoryService
import spock.lang.Specification


class InventoryServiceSpec extends Specification {
	
	def "Adding a Product List to the Inventory List"(){
		
		given: "An InventoryService"
		InventoryService inventoryService = new InventoryService()
		
		and: "an empty inventory list"
		
		inventoryService.inventoryList = new ArrayList<Product>();
		
		and: "A list of 1 product"
		List<Product> productList = new ArrayList<>();
		Product p1 = new Product();
		productList.add(p1);
		
		when: "inventory is received"
		inventoryService.receiveInventory(productList);
		
		then: "The inventory list count should be 1"
		inventoryService.inventoryList.size() == 1;
		
		and: "The inventorylist should contain the product p1"
		inventoryService.inventoryList.contains(p1) == true;
		
		
	}
	
   

}
