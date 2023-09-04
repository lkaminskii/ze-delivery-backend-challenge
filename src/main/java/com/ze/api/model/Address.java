package com.ze.api.model;

import java.util.List;

import org.json.JSONArray;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class Address {
	
	private String type;
	private List<Coordinate> coordinates;
	
	public Address (String type, List<Coordinate> coordinates) {
		JSONArray jsonArray = new JSONArray(this.coordinates);
	}
	


	

}
