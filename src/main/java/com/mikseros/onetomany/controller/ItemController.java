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

import com.mikseros.onetomany.model.Item;
import com.mikseros.onetomany.model.dto.ItemDto;
import com.mikseros.onetomany.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {

	private final ItemService itemService;
	
	@Autowired
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@PostMapping
	public ResponseEntity<ItemDto> addItem(@RequestBody final ItemDto itemDto) {
		Item item = itemService.addItem(Item.from(itemDto));
		return new ResponseEntity<>(ItemDto.from(item), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<ItemDto>> getItems() {
		List<Item> items = itemService.getItems();
		List<ItemDto> itemsDto = items.stream().map(ItemDto::from).collect(Collectors.toList());
		return new ResponseEntity<>(itemsDto, HttpStatus.OK);
	}
}
