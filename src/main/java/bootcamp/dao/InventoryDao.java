package bootcamp.dao;

import bootcamp.model.inventory.InventoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InventoryDao {
	@Autowired
	JdbcTemplate jdbctemplate;
	
	private final String GET_ALL_INVENTORY_SQL = "SELECT product.ID, inventory.number_available, retail_price FROM PRODUCT, INVENTORY WHERE product.id = inventory.id";
	private final String GET_LOW_INVENTORY_SQL = "SELECT id, number_available FROM inventory WHERE number_available < 10";
	private final String GET_ALL_INVENTORY_WHOLESALE_SQL = "SELECT product.ID, inventory.number_available, wholesale_price AS retail_price FROM PRODUCT, INVENTORY WHERE product.id = inventory.id";

	public List<InventoryItem> getInventory() {
		return jdbctemplate.query(GET_ALL_INVENTORY_SQL, new BeanPropertyRowMapper<>(InventoryItem.class));
	}

	public List<InventoryItem> getInventoryWholeSale() {
		return jdbctemplate.query(GET_ALL_INVENTORY_WHOLESALE_SQL, new BeanPropertyRowMapper<>(InventoryItem.class));
	}

	public List<InventoryItem> getInventoryItemById(int id){
		String sql = "SELECT product.ID, inventory.number_available, retail_price FROM PRODUCT, INVENTORY WHERE product.id = inventory.id AND product.id = " + id;
		return jdbctemplate.query(sql, new BeanPropertyRowMapper<>(InventoryItem.class));
	}

	public List<InventoryItem> getLowInventory(){
		return jdbctemplate.query(GET_LOW_INVENTORY_SQL, new BeanPropertyRowMapper<>(InventoryItem.class));
	}

	public void addToInventory(int productID, int quantityAdded, double wholeSalePrice){
		String sql1 = "UPDATE inventory SET number_available = number_available +" + quantityAdded + " WHERE id = " + productID;

		String sql2 = "UPDATE product SET wholesale_price = " + wholeSalePrice + ", retail_price = " + wholeSalePrice + " * 1.10 WHERE id = " + productID;

		jdbctemplate.update(sql1);
		jdbctemplate.update(sql2);
	}

	public void removeFromInventory(int productID, int quantityRemoved){
		String sql_reduce_item = "UPDATE Inventory SET number_available = number_available - " + quantityRemoved + " WHERE id = " + productID;
		jdbctemplate.update(sql_reduce_item);
	}

}
