package com.ze.api.dto;

import org.geojson.MultiPolygon;
import org.geojson.Point;

import lombok.Data;

@Data
public class PartnerModel {
	
	private Long id;
	private String tradingName;	
	private MultiPolygon coverageArea;
	private Point address;

}
