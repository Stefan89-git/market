package go4code.market_place.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import go4code.market_place.model.Category;
import go4code.market_place.model.Product;

public class ProductDTO {
	private Long id;
	
	private String name;
	
	private String description;
	
	private double price;
	
	private int availableQuantity;
	
	private Category category;
	
	private String picture;
	
	private LocalDate creationDate;
	
	private LocalTime creationTime;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public LocalTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalTime creationTime) {
		this.creationTime = creationTime;
	}
	
	public ProductDTO() {
		super();	
	}

	public ProductDTO(Long id, String name, String description, double price, int availableQuantity, Category category,
			String picture, LocalDate creationDate, LocalTime creationTime) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.availableQuantity = availableQuantity;
		this.category = category;
		this.picture = picture;
		this.creationDate = creationDate;
		this.creationTime = creationTime;
	}
	public ProductDTO(Product product) {
		super();
		this.id=product.getId();
		this.availableQuantity=product.getAvailableQuantity();
		this.category=product.getCategory();
		this.description=product.getDescription();
		this.price=product.getPrice();
		this.name = product.getName();
		this.picture = product.getPicture();
		this.creationDate = product.getCreationDate();
		this.creationTime = product.getCreationTime();
	}
}
