package com.javaweb.Repository;

import java.util.List;
import java.util.Map;

import com.javaweb.Repository.Entity.BuildingEntity;



public interface BuildingRepository {
	List<BuildingEntity> findBuilding(Map<Object, Object> params);
	List<BuildingEntity> findBuildingTypeCode(Map<Object, Object> params,List<String> TypeCode);
	
}
