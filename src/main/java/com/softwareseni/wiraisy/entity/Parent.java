package com.softwareseni.wiraisy.entity;

import java.util.Optional;

public class Parent{

	private Optional<Long> parent_id;
	
	public Parent() {
	}

	public Parent(Optional<Long> parent_id) {
		this.parent_id = parent_id;
	}

	public Optional<Long> getParent_id() {
		return parent_id;
	}

	public void setParent_id(Optional<Long> parent_id) {
		this.parent_id = parent_id;
	}
	
	

	
	
	
}
