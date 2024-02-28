package com.ze.api.model;

import java.io.Serializable;

import org.geojson.MultiPolygon;
import org.geojson.Point;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="tb_partner")
public class Partner implements Serializable{
	
	private static final long serialVersionUID = 2996162169438188257L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tradingName;	
	private String ownerName;
	private String document;
	
	@Lob
	private MultiPolygon coverageArea;
	
	@Lob
	private Point address;
	
}
