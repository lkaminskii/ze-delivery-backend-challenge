package com.ze.api.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.ze.api.model.Partner;
import com.ze.api.repository.PartnerRepository;

@Service
public class SearchPartnerService {
	
	@Autowired
	private PartnerRepository partnerRepository;
	
	private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        Point location = new GeometryFactory().createPoint(new Coordinate(lat1, lon1));
        Point partnerLocation = new GeometryFactory().createPoint(new Coordinate(lat2, lon2));

        return location.distance(partnerLocation);
    }
    
	public Optional<Partner> findNearestPartner(double latitude, double longitude) {
        List<Partner> partners = partnerRepository.findAll();

        return partners.stream()
                .filter(partner -> partner.getCoverageArea().contains(partner.getAddress()))
                .min(Comparator.comparing(partner -> calculateDistance(
                        latitude,
                        longitude,
                        partner.getAddress().getX(),
                        partner.getAddress().getY()
                )));
    }

}
