package com.ze.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ze.api.model.Partner;
import com.ze.api.repository.PartnerRepository;

import jakarta.transaction.Transactional;

@Service
public class PartnerService {
	
	@Autowired
	private PartnerRepository partnerRepository;
	
	public List<Partner> getAll() {
		return partnerRepository.findAll();
	}
	
	public Partner getById (Long id) {
		return partnerRepository.findById(id).get();
	}
	
	public Partner insert (Partner partner) {
		return partnerRepository.save(partner);
	}

}