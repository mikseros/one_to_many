package com.mikseros.onetomany.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mikseros.onetomany.model.Cart;
import com.mikseros.onetomany.model.dto.CartDto;
import com.mikseros.onetomany.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

	private final CartService cartService;
	
	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}
	
	@PostMapping
	public ResponseEntity<CartDto> addCart(@RequestBody final CartDto cartDto) {
		Cart cart = cartService.addCart(Cart.from(cartDto));
		return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<CartDto>> getCarts() {
		List<Cart> carts = cartService.getCarts();
		List<CartDto> cartsDto = carts.stream().map(CartDto::from).collect(Collectors.toList());
		return new ResponseEntity<>(cartsDto, HttpStatus.OK);
	}
}
