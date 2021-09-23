package go4code.market_place.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import go4code.market_place.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	public Category findByName(String name);
}
