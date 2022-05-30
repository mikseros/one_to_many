package com.mikseros.onetomany.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.mikseros.onetomany.model.Cart;
import com.mikseros.onetomany.model.Item;

import lombok.Data;

@Data
public class CartDto {
	private Long id;
	private String name;
	private List<Item> items = new ArrayList<>();
	
	public static CartDto from(Cart cart) {
		CartDto cartDto = new CartDto();
		cartDto.setId(cart.getId());
		cartDto.setName(cart.getName());
		cartDto.setItems(cart.getItems());
		return cartDto;
	}
}
