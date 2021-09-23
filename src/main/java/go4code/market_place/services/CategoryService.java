package go4code.market_place.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import go4code.market_place.model.Category;
import go4code.market_place.repositories.CategoryRepository;

@Component
public class CategoryService {

	@Autowired
	private CategoryRepository catRepo;
	
	public List<Category> getAllCategories(){
		return catRepo.findAll();
	}
	public Category findByName(String name) {
		return catRepo.findByName(name);
	}
	
}
