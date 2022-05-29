package com.mikseros.onetomany.exception;

import java.text.MessageFormat;

public class ItemNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4781433546590377375L;

	public ItemNotFoundException(Long id) {
		super(MessageFormat.format("Could not find the Item with id: {0}", id));
	}
}
