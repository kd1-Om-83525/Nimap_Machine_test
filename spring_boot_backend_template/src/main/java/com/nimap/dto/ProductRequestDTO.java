package com.nimap.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
	private Long categoryId;
	@NotBlank(message = "Product name can't be blank")
	@Size(min = 3, max = 100, message = "Name must be between 3 to 100 characters")
	private String name;
	@NotNull(message = "Price can't be empty")
	@Min(value = 1)
	private double price;

}
