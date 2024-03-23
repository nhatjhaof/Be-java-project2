package com.javaweb.API;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.DTO.BuildingDTO;
import com.javaweb.Service.BuildingService;

@RestController
public class BuildingAPI {
	
	
	@Autowired
	private BuildingService buildingService;
	@GetMapping("/api/building")
	public List<BuildingDTO> findBuilding(@RequestParam Map<Object, Object> params ,
											@RequestParam(value = "TypeCode" , required = false) List<String> TypeCode){
		System.out.println(params);
//		if(params.containsKey("name")) {	
//		String name = (String) params.get("name");
//		List<BuildingDTO> result = buildingService.findName(name);
//		return result;
//		}
//		if(params.containsKey("floorArea")) {
//			Integer floorArea = Integer.valueOf((String) params.get("floorArea"));
//		List<BuildingDTO> result = buildingService.findFloorArea(floorArea);
//		return result;
//		}
//		if(params.containsKey("districtId")) {
//			Integer districtId = Integer.valueOf((String) params.get("districtId"));
//			List<BuildingDTO> result = buildingService.findDistrictId(districtId);
//			return result;
//		}
//		if(params.containsKey("ward")) {
//			String ward = String.valueOf(params.get("ward"));
//			List<BuildingDTO> result = buildingService.findWard(ward);
//			return result;
//		}
//		if(params.containsKey("street")) {
//			String street = String.valueOf(params.get("street"));
//			List<BuildingDTO> result = buildingService.findStreet(street);
//			return result;
//		}
//		if(params.containsKey("numberOfBasement")) {
//			Integer numberOfBasement = Integer.valueOf((String)params.get("numberOfBasement"));
//			List<BuildingDTO> result = buildingService.findNumberOfBasement(numberOfBasement);
//			return result;
//		}
//		if(params.containsKey("direction")) {
//			String direction = String.valueOf(params.get("direction"));
//			List<BuildingDTO> result = buildingService.findDirection(direction);
//			return result;
//		}
//		if(params.containsKey("level")) {
//			String level = String.valueOf(params.get("level"));
//			List<BuildingDTO> result = buildingService.findLevel(level);
//			return result;
//		}
//		if(params.containsKey("areaFrom")) {
//			Integer areaFrom = Integer.valueOf((String)params.get("areaFrom"));
//			List<BuildingDTO> result = buildingService.findAreaFrom(areaFrom);
//			return result;
//		}
//		if(params.containsKey("areaEnd")) {
//			Integer areaEnd = Integer.valueOf((String)params.get("areaEnd"));
//			List<BuildingDTO> result = buildingService.findAreaEnd(areaEnd);
//			return result;
//		}
//		if(params.containsKey("rentPriceFrom")) {
//			Integer rentPriceFrom = Integer.valueOf((String)params.get("rentPriceFrom"));
//			List<BuildingDTO> result = buildingService.findRentPriceFrom(rentPriceFrom);
//			return result;
//		}
//		if(params.containsKey("rentPriceEnd")) {
//			Integer rentPriceEnd = Integer.valueOf((String)params.get("rentPriceEnd"));
//			List<BuildingDTO> result = buildingService.findRentPriceEnd(rentPriceEnd);
//			return result;
//		}
//		if(params.containsKey("managerName")) {
//			String managerName = String.valueOf(params.get("managerName"));
//			List<BuildingDTO> result = buildingService.findManagerName(managerName);
//			return result;
//		}
//		if(params.containsKey("managerPhoneNumber")) {
//			String managerPhoneNumber = String.valueOf(params.get("managerPhoneNumber"));
//			List<BuildingDTO> result = buildingService.findManagerPhoneNumber(managerPhoneNumber);
//			return result;
//		}
//		return null;
//	}
		List<BuildingDTO> result = buildingService.findBuilding(params);
		List<BuildingDTO> result1 = buildingService.findBuildingTypeCode(params, TypeCode);
		return result;
}
}
