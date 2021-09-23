package go4code.market_place.dto;

import go4code.market_place.model.Product;
import go4code.market_place.model.ShopingCart;

public class ShopingCartDto {

	
	private Long id;
	
	private Product product;
	
	private int quantity;

	public ShopingCartDto() {
		super();
	}

	public ShopingCartDto(Long id, Product product, int quantity) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
	}
	
	public ShopingCartDto (ShopingCart shopingCart) {
		super();
		this.id = shopingCart.getId();
		this.product = shopingCart.getProduct();
		this.quantity = shopingCart.getQuantity();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
