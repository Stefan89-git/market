package go4code.market_place.dto;

import go4code.market_place.model.Category;

public class CategoryDto {

	private Long id;
	
	private String name;

	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public CategoryDto(Category category) {
		this.id = category.getId();
		this.name = category.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
