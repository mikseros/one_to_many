package com.mikseros.onetomany.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mikseros.onetomany.exception.CartNotFoundException;
import com.mikseros.onetomany.model.Cart;
import com.mikseros.onetomany.repository.CartRepository;

@Service
public class CartService {
	
	private final CartRepository cartRepository;
	private final ItemService itemService;
	
	@Autowired
	public CartService(CartRepository cartRepository, ItemService itemService) {
		this.cartRepository = cartRepository;
		this.itemService = itemService;
	}
	
	public Cart addCart(Cart cart) {
		return cartRepository.save(cart);
	}
	
	public List<Cart> getCarts() {
		return StreamSupport.stream(cartRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	public Cart getCart(Long id) {
		return cartRepository.findById(id).orElseThrow(() -> 
				new CartNotFoundException(id));
	}
	
	public Cart deleteCart(Long id) {
		Cart cart = getCart(id);
		cartRepository.delete(cart);
		return cart;
	}
	
	public Cart editCart(Long id, Cart cart) {
		Cart cartToEdit = getCart(id);
		cartToEdit.setName(cart.getName());
		return cartToEdit;
	}
}