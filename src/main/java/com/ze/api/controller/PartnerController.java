package com.ze.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ze.api.model.Partner;
import com.ze.api.repository.PartnerRepository;
import com.ze.api.service.PartnerService;

@RestController
@RequestMapping(value = "/partners")
public class PartnerController {
	
	@Autowired
	private PartnerService partnerService;
	
	@GetMapping
	public ResponseEntity<List<Partner>> getAll() {
		List<Partner> list = partnerService.getAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Partner> getById (@PathVariable Long id) {
		Partner entity = partnerService.getById(id);
		return ResponseEntity.ok(entity);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Partner insert (@RequestBody Partner partner) {
		return partnerService.insert(partner);
	}

}
