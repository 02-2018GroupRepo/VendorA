package bootcamp.service;

import java.util.List;

import org.springframework.stereotype.Component;

import bootcamp.model.inventory.InventoryItem;

@Component
public class OrderService {
	
	public void createOrder(List<InventoryItem> lowInventoryList) {
		System.out.println("Hi");
	}
}
