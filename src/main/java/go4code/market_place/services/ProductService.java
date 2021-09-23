package go4code.market_place.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import go4code.market_place.model.Category;
import go4code.market_place.model.Product;
import go4code.market_place.repositories.CategoryRepository;
import go4code.market_place.repositories.ProductRepository;

@Component
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Product> findAll(){
		List<Product> products = productRepository.findAll();
		Collections.sort(products, new Comparator<Product>() {
			  public int compare(Product o1, Product o2) {
			      return o1.getCreationDate().compareTo(o2.getCreationDate());
			  }
			});
		List<Product> reverseList = new ArrayList<>();
		for(int i = products.size() -1; i >= 0; i--) {
			reverseList.add(products.get(i));
		}
		return reverseList;
	}
	
	public Product findOne(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(!optionalProduct.isPresent()) {
			return null;
		}
		return optionalProduct.get();
	}
	
	public Product deleteProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(!optionalProduct.isPresent()) {
			return null;
		}
		Product product = optionalProduct.get();
		productRepository.delete(product);
		return product;
	}
	
	public Product createProduct(Product newProduct) {
		return productRepository.save(newProduct);
	}
	
	public List<Product> newestProducts(){
		List<Product> allProducts = productRepository.findAll();
		Collections.sort(allProducts, new Comparator<Product>() {
			  public int compare(Product o1, Product o2) {
			      return o1.getCreationDate().compareTo(o2.getCreationDate());
			  }
			});
		List<Product> reverseList = new ArrayList<>();
		for(int i = allProducts.size() -1; i >= 0; i--) {
			reverseList.add(allProducts.get(i));
		}
		return reverseList;
	}
	
	
	public List<Product> findByCategoryName(String categoryName){
		Category category=categoryRepository.findByName(categoryName);
		List<Product> products=productRepository.findByCategory(category);
		return products;
	}
	
}
