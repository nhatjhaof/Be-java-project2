package com.javaweb.Repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Collections;

import org.springframework.stereotype.Repository;

import com.javaweb.Repository.BuildingRepository;
import com.javaweb.Repository.Entity.BuildingEntity;
import com.javaweb.Utils.ConnectionUtils;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;
@Repository
public class BuildingRepositoryImpl implements BuildingRepository{
	
	
	//@Override
//	public List<BuildingEntity> findName(String name) {
//		String sql = "SELECT building.* ,GROUP_CONCAT(rentarea.value) AS rentarea_sum \n";
//		sql+="FROM building \n";
//		sql+="JOIN rentarea on building.id = rentarea.buildingid \n";
//		StringBuilder where = new StringBuilder();
//		if (name != null && !name.equals(""))
//			where.append("WHERE name LIKE '%" + name + "%'\n");
//		sql += where.toString();
//		sql += "GROUP BY building.id ;";
//		List<BuildingEntity> result = new ArrayList<BuildingEntity>();
//		try (Connection conn = ConnectionUtils.getConnection();
//				Statement stm = conn.createStatement();
//				ResultSet rs = stm.executeQuery(sql);) {
//			
//			
//			while (rs.next()) 
//			{
//				BuildingEntity building = new BuildingEntity();
//				building.setName(rs.getString("name"));
//				building.setDistrictId(rs.getInt("districtid"));
//				building.setStreet(rs.getString("street"));
//				building.setWard(rs.getString("ward"));
//				building.setNumberOfBasement(rs.getInt("numberofbasement"));
//				building.setManagerName(rs.getString("managername"));
//				building.setManagerPhoneNumber(rs.getString("managerPhoneNumber"));
//				building.setFloorArea(rs.getInt("floorarea"));
//				building.setBrokerageFee(rs.getInt("brokerageFee"));
//				building.setServiceFee(rs.getInt("serviceFee"));
//				building.setRentPrice(rs.getInt("rentPrice"));
//				String valueRentArea = rs.getString("rentarea_sum");
//				if(valueRentArea != null) {
//					String arr[] = valueRentArea.split("[\\s,]+");
//					List<Integer> valueRentAreaList = new ArrayList<Integer>();
//					for(String value :arr) {
//						valueRentAreaList.add(Integer.parseInt(value.trim()));
//						building.setValue(valueRentAreaList);
//					}
//				}
//				result.add(building);
//			}
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//			
//		}
//		return result;
//	}

	@Override
	public List<BuildingEntity> findBuilding(Map<Object, Object> params) {
		String sql = "SELECT building.* ,GROUP_CONCAT(rentarea.value) AS rentarea_sum \n";
		sql+="FROM building \n";
		sql+="JOIN rentarea on building.id = rentarea.buildingid \n";
		sql+="WHERE 1=1";
		if(params.containsKey("nameBuilding")) {
			String name = (String) params.get("nameBuilding");
			if(name != null && !name.equals("")) {
				sql+="AND building.name LIKE '%"+name+"%' \n";
			}
		}
		if(params.containsKey("floorArea")) {
			Integer floorArea = Integer.valueOf((String) params.get("floorArea"));
			if(floorArea != null) {
				sql+=" AND building.floorarea = "+floorArea +"\n";
			}
		}
		if(params.containsKey("districtId")) {
			Integer districtId = Integer.valueOf((String) params.get("districtId"));
			if(districtId != null) {
				sql+=" AND building.districtId = "+districtId +"\n";
			}
		}
		if(params.containsKey("ward")) {
			String ward = (String) params.get("ward");
			if(ward != null && !ward.equals("")) {
				sql+=" AND building.ward LIKE '%"+ ward +"%'\n";
			}
		}
		if(params.containsKey("street")) {
			String street = (String) params.get("street");
			if(street != null && !street.equals("")) {
				sql+=" AND building.street LIKE '%"+ street +"%'\n";
			}
		}
		if(params.containsKey("numberOfBasement")) {
			Integer numberOfBasement = Integer.valueOf((String) params.get("numberOfBasement"));
			if(numberOfBasement != null) {
				sql+=" AND building.numberofbasement = "+ numberOfBasement +"\n";
			}
		}
		if(params.containsKey("areaFrom")) {
				Integer RentvalueFrom = Integer.valueOf((String) params.get("areaFrom"));
				if(RentvalueFrom != null) {
					sql+=" AND rentarea.value >= "+ RentvalueFrom +"\n";
				}
		}
		if(params.containsKey("areaEnd")) {
			Integer RentvalueEnd = Integer.valueOf((String) params.get("areaEnd"));
			if(RentvalueEnd != null) {
				sql+=" AND rentarea.value <= "+ RentvalueEnd +"\n";
			}
	}
		if(params.containsKey("rentPriceFrom")) {
			Integer rentPriceFrom = Integer.valueOf((String) params.get("rentPriceFrom"));
			if(rentPriceFrom != null) {
				sql+=" AND building.rentprice >= "+ rentPriceFrom +"\n";
			}
	}	
		if(params.containsKey("rentPriceEnd")) {
			Integer rentPriceEnd = Integer.valueOf((String) params.get("rentPriceEnd"));
			if(rentPriceEnd != null) {
				sql+=" AND building.rentprice <= "+ rentPriceEnd +"\n";
			}
		}		
			if(params.containsKey("direction")) { 
				String direction = (String) params.get("direction");
				if(direction == null && direction.equals("")) {
					return null;
				}
				else {
					
					sql+=" AND building.direction LIKE '%"+ direction +"%'\n";
				}
			}
			if(params.containsKey("level")) { 
				String level = (String) params.get("level");
				if(level == null && level.equals("")) {
					return null;
				}
				else {
					sql+=" AND building.direction LIKE '%"+ level +"%'\n";
				}
			}
			if(params.containsKey("managerName")) {
				String managerName = (String) params.get("managerName");
				if(managerName != null && !managerName.equals("")) {
					sql+=" AND building.managerName LIKE '%"+ managerName +"%'\n";
				}
			}	
			if(params.containsKey("managerPhoneNumber")) {
				String managerPhoneNumber = (String) params.get("managerPhoneNumber");
				if(managerPhoneNumber != null && !managerPhoneNumber.equals("")) {
					sql+=" AND building.managerPhoneNumber '%"+ managerPhoneNumber +"%'\n";
				}
			}
		sql+="GROUP BY building.id \n" ;
		List<BuildingEntity> result = new ArrayList<BuildingEntity>();
		try (Connection conn = ConnectionUtils.getConnection();
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(sql);) {
			
			while (rs.next()) 
			{
				BuildingEntity building = new BuildingEntity();
				building.setName(rs.getString("name"));
				building.setDistrictId(rs.getInt("districtid"));
				building.setStreet(rs.getString("street"));
				building.setWard(rs.getString("ward"));
				building.setNumberOfBasement(rs.getInt("numberofbasement"));
				building.setManagerName(rs.getString("managername"));
				building.setManagerPhoneNumber(rs.getString("managerPhoneNumber"));
				building.setFloorArea(rs.getInt("floorarea"));
				building.setBrokerageFee(rs.getInt("brokerageFee"));
				building.setServiceFee(rs.getInt("serviceFee"));
				building.setRentPrice(rs.getInt("rentPrice"));
				String valueRentArea = rs.getString("rentarea_sum");
				if(valueRentArea != null) {
					String arr[] = valueRentArea.split("[\\s,]+");
					List<Integer> valueRentAreaList = new ArrayList<Integer>();
					for(String value :arr) {
						valueRentAreaList.add(Integer.parseInt(value.trim()));
						building.setValue(valueRentAreaList);
					}
				}
				result.add(building);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return result;
	}

	@Override
	public List<BuildingEntity> findBuildingTypeCode(Map<Object, Object> params,List<String> TypeCode) {
		String sql = "SELECT building.* ,GROUP_CONCAT(rentarea.value) AS rentarea_sum \n";
		sql+="FROM building \n";
		sql+="JOIN rentarea on building.id = rentarea.buildingid \n";
	
		if(params.containsKey("TypeCode")) {
			String typecode = (String) params.get("TypeCode");
			if(TypeCode != null && !TypeCode.equals("")) {
				sql+="JOIN buildingrenttype ON building.id = buildingrenttype.buildingid\r\n"
					+ "JOIN renttype ON renttype.id = buildingrenttype.renttypeid \n";
				sql+=" WHERE 1=1 AND renttype.code IN ("+ TypeCode +")\n";
				
			}
	}
		sql+="GROUP BY building.id \n" ;
		List<BuildingEntity> result = new ArrayList<BuildingEntity>();
		try (Connection conn = ConnectionUtils.getConnection();
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(sql);) {
			
			while (rs.next()) 
			{
				BuildingEntity building = new BuildingEntity();
				building.setName(rs.getString("name"));
				building.setDistrictId(rs.getInt("districtid"));
				building.setStreet(rs.getString("street"));
				building.setWard(rs.getString("ward"));
				building.setNumberOfBasement(rs.getInt("numberofbasement"));
				building.setManagerName(rs.getString("managername"));
				building.setManagerPhoneNumber(rs.getString("managerPhoneNumber"));
				building.setFloorArea(rs.getInt("floorarea"));
				building.setBrokerageFee(rs.getInt("brokerageFee"));
				building.setServiceFee(rs.getInt("serviceFee"));
				building.setRentPrice(rs.getInt("rentPrice"));
				String valueRentArea = rs.getString("rentarea_sum");
				if(valueRentArea != null) {
					String arr[] = valueRentArea.split("[\\s,]+");
					List<Integer> valueRentAreaList = new ArrayList<Integer>();
					for(String value :arr) {
						valueRentAreaList.add(Integer.parseInt(value.trim()));
						building.setValue(valueRentAreaList);
					}
				}
				result.add(building);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return result;
		
	}
}





