package go4code.market_place.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Product {

	@Id
	@GeneratedValue
	@Column
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private double price;
	
	@Column
	private int availableQuantity;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "category")
	private Category category;
	
	@Column
	private String picture;
	
	@Column
	private LocalDate creationDate;
	
	@Column
	private LocalTime creationTime;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonBackReference
	private Set<ShopingCart> purchases;

	public Product(Long id, String name, String description, double price, int availableQuantity, Category category,
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

	public Product() {
		super();
		// TODO Auto-generated constructor stub
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

	public Set<ShopingCart> getPurchases() {
		return purchases;
	}

	public void setPurchases(Set<ShopingCart> purchases) {
		this.purchases = purchases;
	}
	
	
}
