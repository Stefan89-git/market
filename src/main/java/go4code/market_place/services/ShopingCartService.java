package go4code.market_place.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import go4code.market_place.model.Product;
import go4code.market_place.model.ShopingCart;
import go4code.market_place.repositories.ProductRepository;
import go4code.market_place.repositories.ShopingCartRepository;

@Component
public class ShopingCartService {

	@Autowired
	private ShopingCartRepository shopingCartRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<ShopingCart> getAll(){
		return shopingCartRepository.findAll();
	}
	
	public ShopingCart findOne(Long id) {
		Optional<ShopingCart> optionalShopingCart = shopingCartRepository.findById(id);
		if(!optionalShopingCart.isPresent()) {
			return null;
		}
		ShopingCart shopingCart = optionalShopingCart.get();
		return shopingCart;
	}
	
	public ShopingCart deleteShopingCart(Long id) {
		Optional<ShopingCart> optionalShopingCart = shopingCartRepository.findById(id);
		if(!optionalShopingCart.isPresent()) {
			return null;
		}
		ShopingCart shopingCart = optionalShopingCart.get();
		shopingCartRepository.delete(shopingCart);
		return shopingCart;
	}
	
	public ShopingCart createShopingCart(ShopingCart shopingCart) {
		
		if(productRepository.findById(shopingCart.getProduct().getId())== null) {
			return null;
		}
		if(shopingCart.getQuantity() > shopingCart.getProduct().getAvailableQuantity()) {
			return null;
		}
		Product product = productRepository.findById(shopingCart.getProduct().getId()).get();
		product.setAvailableQuantity(product.getAvailableQuantity() - shopingCart.getQuantity());
		return shopingCartRepository.save(shopingCart);
	}
}
