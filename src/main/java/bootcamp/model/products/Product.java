package bootcamp.model.products;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

public class Product {
	
	private int id;
	private String name;
	private String description;
	private BigDecimal wholesale_price;
	private BigDecimal retail_price;
	
    
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private Map<String, Object> properties;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public BigDecimal getWholesale_price() {
		return wholesale_price;
	}
	public void setWholesale_price(BigDecimal wholesale_price) {
		this.wholesale_price = wholesale_price;
	}
	public BigDecimal getRetail_price() {
		return retail_price;
	}
	public void setRetail_price(BigDecimal retail_price) {
		this.retail_price = retail_price;
	}
	
	@JsonAnySetter
	public void setValue(String name, Object value) {
	    if (this.properties == null) {
	        this.properties = new HashMap<>();
	    }
	    this.properties.put(name, value);
	}

}
