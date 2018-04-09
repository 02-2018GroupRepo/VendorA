package bootcamp.model.invoice;

import bootcamp.model.products.Product;

public class InvoiceItem {
	
	private Product product;
	private int count;
	
	public InvoiceItem() {}
	
	public InvoiceItem(Product product, Integer count) {
		this.product = product;
		this.count = count;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	

}
