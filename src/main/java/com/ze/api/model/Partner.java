package com.ze.api.model;

import com.vividsolutions.jts.geom.MultiPolygon;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import com.vividsolutions.jts.geom.Point;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name="tb_partner")
public class Partner implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
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
