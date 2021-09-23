package go4code.market_place.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import go4code.market_place.dto.ShopingCartDto;
import go4code.market_place.model.ShopingCart;
import go4code.market_place.services.ShopingCartService;

@RestController
@RequestMapping(path = "/api/shopingcart/")
public class ShopingCartController {

	@Autowired
	private ShopingCartService shopingCartService;
	
	@GetMapping
	public ResponseEntity<List<ShopingCartDto>> getAllShopingCarts(){
		List<ShopingCart> shopingCarts = shopingCartService.getAll();
		List<ShopingCartDto> shopingCartsDtos = new ArrayList<>();
		for(ShopingCart sc : shopingCarts) {
			shopingCartsDtos.add(new ShopingCartDto(sc));
		}
		return new ResponseEntity<List<ShopingCartDto>>(shopingCartsDtos, HttpStatus.OK);
	}
	
	@GetMapping(path = "{id}")
	public ResponseEntity<ShopingCartDto> findOne(@PathVariable Long id){
		ShopingCart shopingCart = shopingCartService.findOne(id);
		if(shopingCart == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		ShopingCartDto shopingCartDto = new ShopingCartDto(shopingCart);
		return new ResponseEntity<ShopingCartDto>(shopingCartDto, HttpStatus.FOUND);
	}
	
	@PostMapping
	public ResponseEntity<ShopingCartDto> createShopingCart(@RequestBody ShopingCartDto shopingCartDto){
		ShopingCart shopingCart = new ShopingCart(shopingCartDto.getId(), shopingCartDto.getProduct(), shopingCartDto.getQuantity());
		ShopingCart newShopingCart = shopingCartService.createShopingCart(shopingCart);
		if(newShopingCart == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		ShopingCartDto newShopingCartDto = new ShopingCartDto(newShopingCart);
		return new ResponseEntity<ShopingCartDto>(newShopingCartDto, HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "{id}")
	public ResponseEntity<ShopingCartDto> deleteShopingCart(@PathVariable Long id){
		ShopingCart shopingCart = shopingCartService.findOne(id);
		if(shopingCart == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		ShopingCart deletedShopingCart = shopingCartService.deleteShopingCart(id);
		ShopingCartDto shopingCartDto = new ShopingCartDto(deletedShopingCart);
		return new ResponseEntity<ShopingCartDto>(shopingCartDto, HttpStatus.ACCEPTED);
	}
}
