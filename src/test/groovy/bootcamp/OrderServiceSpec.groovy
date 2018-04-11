package bootcamp

import bootcamp.model.inventory.InventoryItem
import bootcamp.model.order.Order
import bootcamp.service.OrderService
import spock.lang.Specification


class OrderServiceSpec extends Specification {
    def "Cheapest supplier"() {
        given: "order service"
            OrderService orderService = new OrderService();
        and: "Each supplier's inventory list"
            List<InventoryItem> list1 = new ArrayList<>();
            InventoryItem inventoryItem1 = new InventoryItem();
            inventoryItem1.setId(1);
            inventoryItem1.setRetail_price(1.00);
            inventoryItem1.setNumber_available(5);
            list1.add(inventoryItem1);

            List<InventoryItem> list2 = new ArrayList<>();
            InventoryItem inventoryItem2 = new InventoryItem();
            inventoryItem2.setId(1);
            inventoryItem2.setRetail_price(0.50);
            inventoryItem2.setNumber_available(5);
            list2.add(inventoryItem2);

            List<InventoryItem> list3 = new ArrayList<>();
            InventoryItem inventoryItem3 = new InventoryItem();
            inventoryItem3.setId(1);
            inventoryItem3.setRetail_price(2.00);
            inventoryItem3.setNumber_available(5);
            list3.add(inventoryItem3);

            orderService.supplier_A = list1;
            orderService.supplier_B = list2;
            orderService.supplier_C = list3;
        when: "Cheapest supplier is called"
            int result = orderService.cheapestSupplier(1);
        then: "Lowest price index should be returned"
            result == 1
    }

}