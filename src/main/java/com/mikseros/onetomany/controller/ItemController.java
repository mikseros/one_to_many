package com.mikseros.onetomany.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping(value = "{id}")
	public ResponseEntity<ItemDto> getItem(@PathVariable final Long id) {
		Item item = itemService.getItem(id);
		return new ResponseEntity<>(ItemDto.from(item), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<ItemDto> deleteItem(@PathVariable final Long id) {
		Item item = itemService.deleteItem(id);
		return new ResponseEntity<>(ItemDto.from(item), HttpStatus.OK);
	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity<ItemDto> editItem(@PathVariable final Long id,
											@RequestBody final ItemDto itemDto) {
		Item editedItem = itemService.editItem(id, Item.from(itemDto));
		return new ResponseEntity<>(ItemDto.from(editedItem), HttpStatus.OK);
	}
}
