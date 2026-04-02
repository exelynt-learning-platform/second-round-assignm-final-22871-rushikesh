package com.backend.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
	private String token;

	public AuthResponse(String token) {
		this.token = token;
	}
}
