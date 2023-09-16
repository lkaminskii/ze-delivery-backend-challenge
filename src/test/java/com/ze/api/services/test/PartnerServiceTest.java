package com.ze.api.services.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.ze.api.model.Partner;
import com.ze.api.repository.PartnerRepository;
import com.ze.api.service.PartnerService;
import com.ze.api.service.SearchPartnerService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class PartnerServiceTest {

    @Autowired
    private PartnerService service;
    
    @Autowired
    private SearchPartnerService searchPartnerService;

    @MockBean
    private PartnerRepository repository;

    @Test
    public void testFindNearestPartner() {

        Partner p1 = new Partner();
        p1.setAddress(new GeometryFactory().createPoint(new Coordinate(-46.57421, -21.785741)));

        Partner p2 = new Partner();
        p2.setAddress(new GeometryFactory().createPoint(new Coordinate(-46.57422, -21.785742)));

        when(repository.findAll()).thenReturn(List.of(p1, p2));


        Optional<Partner> result = searchPartnerService.findNearestPartner(-46.57420, -21.785740);


        assertTrue(result.isPresent());
        assertEquals(p1, result.get());
    }
}