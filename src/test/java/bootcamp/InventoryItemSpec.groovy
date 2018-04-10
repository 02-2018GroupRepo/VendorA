package bootcamp

import bootcamp.model.inventory.Inventory
import bootcamp.model.inventory.InventoryItem
import spock.lang.Specification

class InventoryItemSpec extends Specification {
	def "Proper instantiation"() {
		given: "An inventory item"
		InventoryItem inventoryItem = new InventoryItem();
		
		when: "Properties are set"
		inventoryItem.setId(1);
		inventoryItem.setPrice(1.00);
		inventoryItem.setQuantity(5);
		
		then: "Should return same values"
		inventoryItem.getId() == 1;
		inventoryItem.getPrice() == 1.00;
		inventoryItem.getQuantity() == 5;
	}
	
	def "Add inventory item to inventory list"() {
		given: "An inventory"
		Inventory inventory = new Inventory();
		and: "A inventory item"
		InventoryItem inventoryItem = new InventoryItem();
		inventoryItem.setId(1);
		inventoryItem.setPrice(1.00);
		inventoryItem.setQuantity(5);
		when: "Inventory item is added to list"
		inventory.addToList(inventoryItem);
		then: "Item should have been added"
		inventory.getList().empty == false;
	}
}
