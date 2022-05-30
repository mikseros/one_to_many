package com.mikseros.onetomany.exception;

import java.text.MessageFormat;

public class CartNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 7801547146787854767L;

	public CartNotFoundException(final Long id) {
		super(MessageFormat.format("Could not find cart with id {0}", id));
	}
}
