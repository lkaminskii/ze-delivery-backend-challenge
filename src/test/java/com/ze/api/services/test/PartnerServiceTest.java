package com.ze.api.services.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ze.api.model.Partner;
import com.ze.api.repository.PartnerRepository;
import com.ze.api.service.PartnerService;
import com.ze.api.service.SearchPartnerService;

public class PartnerServiceTest {

    @InjectMocks
    private PartnerService partnerService;

    @Mock
    private PartnerRepository partnerRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnAnPartnerById() {
        Partner partner = new Partner();
        partner.setId(1L);
        when(partnerRepository.findById(1L)).thenReturn(Optional.of(partner));

        Partner result = partnerService.getById(1L);

        assertEquals(1L, result.getId());
        verify(partnerRepository).findById(1L);
    }


}