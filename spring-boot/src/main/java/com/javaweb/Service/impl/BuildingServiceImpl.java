package com.javaweb.Service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.DTO.BuildingDTO;
import com.javaweb.Repository.BuildingRepository;
import com.javaweb.Repository.Entity.BuildingEntity;
import com.javaweb.Service.BuildingService;
@Service
public class BuildingServiceImpl implements BuildingService{
	@Autowired
	private BuildingRepository buildingRepository;

	@Override
	public List<BuildingDTO> findBuilding(Map<Object, Object> params) {
		List<BuildingEntity> buildingEntities = buildingRepository.findBuilding(params );
		List<BuildingDTO> result = new ArrayList<BuildingDTO>();
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO buildingDTO = new BuildingDTO();
			buildingDTO.setName(item.getName());
			buildingDTO.setAddress(item.getStreet()+","+item.getWard()+","+item.getDistrictId());
			buildingDTO.setNumberOfBasement(item.getNumberOfBasement());
			buildingDTO.setManagerName(item.getManagerName());
			buildingDTO.setManagerPhoneNumber(item.getManagerPhoneNumber());
			buildingDTO.setFloorArea(item.getFloorArea());
			buildingDTO.setEmptyArea(null);
			buildingDTO.setBrokerageFee(item.getBrokerageFee());
			buildingDTO.setRentPrice(item.getRentPrice());
			buildingDTO.setServiceFee(item.getServiceFee());
			StringBuilder sb = new StringBuilder();
			for(Integer valueRentArea : item.getValue())
				sb.append(valueRentArea).append(", ");
			buildingDTO.setRentArea(sb.toString());
			result.add(buildingDTO);
		}
		return result;
	}

	@Override
	public List<BuildingDTO> findBuildingTypeCode(Map<Object, Object> params,List<String> TypeCode) {
		List<BuildingEntity> buildingEntities = buildingRepository.findBuildingTypeCode(params,TypeCode);
		List<BuildingDTO> result = new ArrayList<BuildingDTO>();
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO buildingDTO = new BuildingDTO();
			buildingDTO.setName(item.getName());
			buildingDTO.setAddress(item.getStreet()+","+item.getWard()+","+item.getDistrictId());
			buildingDTO.setNumberOfBasement(item.getNumberOfBasement());
			buildingDTO.setManagerName(item.getManagerName());
			buildingDTO.setManagerPhoneNumber(item.getManagerPhoneNumber());
			buildingDTO.setFloorArea(item.getFloorArea());
			buildingDTO.setEmptyArea(null);
			buildingDTO.setBrokerageFee(item.getBrokerageFee());
			buildingDTO.setRentPrice(item.getRentPrice());
			buildingDTO.setServiceFee(item.getServiceFee());
			StringBuilder sb = new StringBuilder();
			for(Integer valueRentArea : item.getValue())
				sb.append(valueRentArea).append(", ");
			buildingDTO.setRentArea(sb.toString());
			result.add(buildingDTO);
		}
		return result;
	}
}
