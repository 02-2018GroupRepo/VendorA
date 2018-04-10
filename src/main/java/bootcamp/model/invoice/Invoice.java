package bootcamp.model.invoice;

import bootcamp.model.products.Product;

public class Invoice {

	private Product product;
	private int count;

	public Invoice() {}

	public Invoice(Product product, Integer count) {
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
