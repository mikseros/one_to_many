package com.mikseros.onetomany.model.dto;

import com.mikseros.onetomany.model.Item;

import lombok.Data;

@Data
public class ItemDto {

	private Long id;
	private String serialNumber;
	
	public static ItemDto from(Item item) {
		ItemDto itemDto = new ItemDto();
		itemDto.setId(item.getId());
		itemDto.setSerialNumber(item.getSerialNumber());
		return itemDto;
	}
}
