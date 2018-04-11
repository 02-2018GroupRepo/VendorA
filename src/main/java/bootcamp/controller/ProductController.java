package bootcamp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.model.products.Product;
import bootcamp.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

//	@RequestMapping("/product/{id}")
//    public Product getProductById(@PathVariable Integer id) {
//		log.info("Retreiving product " + id);
//    	return productService.getProductById(id);
//    }
//
//	@RequestMapping("/product")
//	public List<Product> getProductList(){
//		log.info("Vendor A: Retreiving all products");
//		return productService.getProducts();
//	}
	
}
