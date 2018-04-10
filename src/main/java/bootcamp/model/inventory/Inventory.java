package bootcamp.model.inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	private List<InventoryItem> inventoryList = new ArrayList<>();
	
	public List<InventoryItem> getList() {
		return inventoryList;
	}
	
	public void addToList(InventoryItem item) {
		inventoryList.add(item);
	}
}
