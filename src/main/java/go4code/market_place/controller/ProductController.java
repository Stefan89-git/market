package go4code.market_place.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import go4code.market_place.dto.ProductDTO;
import go4code.market_place.model.Product;
import go4code.market_place.services.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/products/")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> getAllProducts(){
		List<Product> products = productService.findAll();
		List<ProductDTO> productsDto = new ArrayList<>();
		for(Product p : products) {
			productsDto.add(new ProductDTO(p));
		}
		return new ResponseEntity<List<ProductDTO>>(productsDto, HttpStatus.OK);
	}
	
	@GetMapping(path = "{id}")
	public ResponseEntity<ProductDTO> findOne(@PathVariable Long id) {
		if(productService.findOne(id) == null) {
			return new ResponseEntity<ProductDTO>(HttpStatus.NOT_FOUND);
		}
		Product product = productService.findOne(id);
		ProductDTO productDto = new ProductDTO(product);
		return new ResponseEntity<ProductDTO>(productDto, HttpStatus.FOUND);
	}
	
	@GetMapping(params="categoryName")
	public ResponseEntity<List<ProductDTO>> findByCategoryName(@RequestParam String categoryName){
		List<Product> products = productService.findByCategoryName(categoryName);
		List<ProductDTO> productsDtos=new ArrayList<>();
		for(Product p:products) {
			productsDtos.add(new ProductDTO(p));
		}
		return new ResponseEntity<List<ProductDTO>>(productsDtos,HttpStatus.OK);
	}
	
	@GetMapping(path = "newest")
	public ResponseEntity<List<Product>> getNewestProducts(){
		return new ResponseEntity<List<Product>>(productService.newestProducts(), HttpStatus.OK);
	}
}
