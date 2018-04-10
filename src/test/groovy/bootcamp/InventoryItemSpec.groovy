package bootcamp

import bootcamp.model.inventory.InventoryItem
import spock.lang.Specification

class InventoryItemSpec extends Specification {
	def "Proper instantiation"() {
		given: "An inventory item"
		InventoryItem inventoryItem = new InventoryItem();
		
		when: "Properties are set"
		inventoryItem.setId(1);
		inventoryItem.setRetail_price(1.00);
		inventoryItem.setNumber_available(5);
		
		then: "Should return same values"
		inventoryItem.getId() == 1;
		inventoryItem.getRetail_price() == 1.00;
		inventoryItem.getNumber_available() == 5;
	}
}
