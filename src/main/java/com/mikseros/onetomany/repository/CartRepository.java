package com.mikseros.onetomany.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.mikseros.onetomany.model.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long>{

}
