package com.iu.s1.location;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iu.s1.util.DBConnect;

public class LocationDAO {
	
	private DBConnect dbConnect;
	
	public LocationDAO() {
		dbConnect = new DBConnect();
	}
	
	//Insert 
	public int setInsert(LocationDTO locationDTO) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		
		try {
			con = dbConnect.getConnect();
			
			String sql = "INSERT INTO LOCATIONS VALUES (?, ?, ?, ?, ?, ?)";
			st=con.prepareStatement(sql);
			
			
			st.setInt(1, locationDTO.getLocation_id());
			st.setString(2, locationDTO.getStreet_address());
			st.setString(3, locationDTO.getPostal_code());
			st.setString(4, locationDTO.getCity());
			st.setString(5, locationDTO.getState_province());
			st.setString(6, locationDTO.getCountry_id());
			
			System.out.println(st.executeUpdate());
			result = st.executeUpdate();
			//NULL을 ("USER02"."LOCATIONS"."CITY") 안에 삽입할 수 없습니다
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}// setInsert() 종료
	
	
	
	//List 전체
	public ArrayList<LocationDTO> getList() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT * FROM LOCATIONS ORDER BY LOCATION_ID ASC";
			
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				LocationDTO locationDTO = new LocationDTO();
				locationDTO.setLocation_id(rs.getInt("location_id"));
				locationDTO.setStreet_address(rs.getString("street_address"));
				locationDTO.setPostal_code(rs.getString("postal_code"));
				locationDTO.setCity(rs.getString("city"));
				locationDTO.setState_province(rs.getString("state_province"));
				locationDTO.setCountry_id(rs.getString("country_id"));
				
				ar.add(locationDTO);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
		
		return ar;
	}
	
	
	//One 하나
	public LocationDTO getOne(LocationDTO locationDTO) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		LocationDTO result = null;
		try {
			con = dbConnect.getConnect();
			
			
			String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID=?";
			
			st = con.prepareStatement(sql);
			st.setInt(1, locationDTO.getLocation_id());
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				result = new LocationDTO();
				result.setLocation_id(rs.getInt("location_id"));
				result.setStreet_address(rs.getString("street_address"));
				result.setPostal_code(rs.getString("postal_code"));
				result.setCity(rs.getString("city"));
				result.setState_province(rs.getString("state_province"));
				result.setCountry_id(rs.getString("country_id"));
				//locationDTO.setLocation_id는 이미 매개변수로 받아서 따로 만들지 않아도 됨
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
		
		return result;
	}
	
}

