package go4code.market_place.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import go4code.market_place.dto.CategoryDto;
import go4code.market_place.model.Category;
import go4code.market_place.services.CategoryService;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/categories/")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<CategoryDto>> getAllCategories(){
		List<Category> categories = categoryService.getAllCategories();
		List<CategoryDto> categoriesDto = new ArrayList<>();
		for(Category c : categories) {
			categoriesDto.add(new CategoryDto(c));
		}
		return new ResponseEntity<List<CategoryDto>>(categoriesDto, HttpStatus.OK);
	}
}
