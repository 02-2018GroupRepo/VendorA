package bootcamp.service;

import java.util.ArrayList;
import java.util.List;

import bootcamp.model.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import bootcamp.model.inventory.InventoryItem;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class OrderService {

	@Value("${supplier-a.url}")
	String supplier_a_url;

	@Value("${supplier-b.url}")
	String supplier_b_url;

	@Value("${supplier-c.url}")
	String supplier_c_url;

	List<InventoryItem> supplier_A;
	List<InventoryItem> supplier_B;
	List<InventoryItem> supplier_C;

	@Autowired
	RestTemplate restTemplate;

	public void createOrderList(List<InventoryItem> lowInventoryList) {
		//check suppliers for lowest price
		//choose my supplier, and send them order
		makeApiCalls();
		List<Order> orderList = new ArrayList<>();
		for(InventoryItem i : lowInventoryList){
			Order order = new Order(i.getId(), i.getNumber_available());
			orderList.add(order);
		}
		//pass orderList to other function
	}

	public void

	public void makeApiCalls() {
		retrieveInventory(0);
		retrieveInventory(1);
		retrieveInventory(2);
	}

	@Async
	public void retrieveInventory(int i){
		UriComponentsBuilder builder;
		switch(i){
			case 0:
				builder = UriComponentsBuilder.fromUriString("http://" + supplier_a_url + "/inventory/all").port(8080)
				supplier_A = restTemplate.getForObject(builder.toUriString(),List.class );
				break;
			case 1:
				builder = UriComponentsBuilder.fromUriString("http://" + supplier_b_url + "/inventory/all").port(8080)
				supplier_B = restTemplate.getForObject(builder.toUriString(),List.class );
				break;
			case 2:
				builder = UriComponentsBuilder.fromUriString("http://" + supplier_c_url + "/inventory/all").port(8080)
				supplier_C = restTemplate.getForObject(builder.toUriString(),List.class );
				break;
				default:
					break;
		}
	}

//	UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("http://YOUR_IP/inventory/all").port(8080);
//	List<InventoryItem> our_inventory = restTemplate.getForObject(builder.toUriString(),List.class );
//				System.out.println(our_inventory);
}
