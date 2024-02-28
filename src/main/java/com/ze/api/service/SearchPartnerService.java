package com.ze.api.service;

import java.util.List;

import org.geojson.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ze.api.model.Partner;
import com.ze.api.repository.PartnerRepository;

@Service
public class SearchPartnerService {
	
	private PartnerRepository partnerRepository;
	
	public SearchPartnerService(PartnerRepository partnerRepository) {
		this.partnerRepository = partnerRepository;
	}
	
	public Partner findNearestPartner(Double longitude, Double latitude) {
        List<Partner> partners = partnerRepository.findAll();
        Partner nearestPartner = null;
        double shortestDistance = Double.MAX_VALUE;

        for (Partner partner : partners) {
            if (((List<Partner>) partner.getCoverageArea()).contains(new Point(longitude, latitude))) {
                double distance = calculateDistance(partner.getAddress(), new Point(longitude, latitude));
                if (distance < shortestDistance) {
                    shortestDistance = distance;
                    nearestPartner = partner;
                }
            }
        }

        return nearestPartner;
    }

    private double calculateDistance(Point a, Point b) {
        double x = a.getCoordinates().getLongitude() - b.getCoordinates().getLongitude();
        double y = a.getCoordinates().getLatitude() - b.getCoordinates().getLatitude();
        return Math.sqrt(x * x + y * y);
    }

}
