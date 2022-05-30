package com.mikseros.onetomany.exception;

import java.text.MessageFormat;

public class ItemIsAlreadyAssignedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ItemIsAlreadyAssignedException(final Long itemId, final Long cartId) {
		super(MessageFormat.format("Item: {0} is already assigned to cart: {1}", itemId, cartId));
	}
}
