package com.edu.pos5ible.entity;

public class Page {

	private Integer number;
	private Integer pagination;
	private Integer type;
	
	public Page() {}

	public Page(Integer number, Integer pagination, Integer type) {
		super();
		this.number = number;
		this.pagination = pagination;
		this.type = type;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getPagination() {
		return pagination;
	}

	public void setPagination(Integer pagination) {
		this.pagination = pagination;
	}

	@Override
	public String toString() {
		return "Page [number=" + number + ", pagination=" + pagination + ", type" + type +"]";
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
