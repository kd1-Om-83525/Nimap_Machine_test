package com.nimap.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
	private Long categoryId;
	private String name;
	private double price;

}
