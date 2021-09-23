package go4code.market_place.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import go4code.market_place.model.ShopingCart;

public interface ShopingCartRepository extends JpaRepository<ShopingCart, Long> {

}
