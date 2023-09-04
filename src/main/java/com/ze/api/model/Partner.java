package com.ze.api.model;


import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.beans.factory.annotation.Autowired;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="tb_partner")
public class Partner {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String tradingName;	
	private String ownerName;	
	private String document;
	
	@JdbcTypeCode(SqlTypes.JSON)
	private CoverageArea coverageArea;
	
	@JdbcTypeCode(SqlTypes.JSON)
	private Address address;
	
}
