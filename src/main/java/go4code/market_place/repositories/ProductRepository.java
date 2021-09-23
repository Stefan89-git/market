package go4code.market_place.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import go4code.market_place.model.Category;
import go4code.market_place.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public List<Product> findByCategory(Category category);

}
