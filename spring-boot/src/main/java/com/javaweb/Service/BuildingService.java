package com.javaweb.Service;

import java.util.List;
import java.util.Map;

import com.javaweb.DTO.BuildingDTO;


public interface BuildingService {
	List<BuildingDTO> findBuilding (Map<Object, Object> params);
	List<BuildingDTO> findBuildingTypeCode(Map<Object, Object> params,List<String> TypeCode);
}
