package com.softwareseni.wiraisy.dto;

import java.util.Optional;

import lombok.Data;

@Data
public class General_dto {
	
	private Double amount;
	
	private String type;
	
	private Optional<Long> parent_id;

	public General_dto(Double amount, String type, Optional<Long> parent_id) {
		super();
		this.amount = amount;
		this.type = type;
		this.parent_id = parent_id;
	}
	
	
	

}
