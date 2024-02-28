package com.ze.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.ze.api.dto.PartnerModel;
import com.ze.api.model.Partner;

@Component
public class PartnerMapper {
	
	private ModelMapper modelMapper;
	
	public PartnerMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	public PartnerModel toModel(Partner Partner) {
		return modelMapper.map(Partner, PartnerModel.class);
	}

	public List<PartnerModel> toCollectionModel(List<Partner> partners) {
		return partners.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
}
