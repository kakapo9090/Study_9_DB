package com.iu.s1.location;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iu.s1.employee.EmployeeDTO;
import com.iu.s1.util.DBConnect;

public class LocationDAO {

	private DBConnect dbConnect;
	
	public LocationDAO() {
		dbConnect = new DBConnect();
	}
	
	
	
	
	
	
	//사원의 번호가 100인 사원이 근무하는 부서가 있는 지역의 주소는?
	public LocationDTO getLocation(int employee_id) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		LocationDTO locationDTO = new LocationDTO();
		try {
			con = dbConnect.getConnect();
			String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = "
					+ "(SELECT LOCATION_ID FROM DEPARTMENTS WHERE DEPARTMENT_ID = "
					+ "(SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE EMPLOYEE_ID = ?))";
			
					
			st= con.prepareStatement(sql);
			st.setInt(1, employee_id);
			rs= st.executeQuery();
			if(rs.next()) {
				
				locationDTO.setLocation_id(rs.getInt("location_id"));
				locationDTO.setStreet_address(rs.getString("street_address"));
				locationDTO.setPostal_code(rs.getString("postal_code"));
				locationDTO.setCity(rs.getString("city"));
				locationDTO.setState_province(rs.getString("state_province"));
				locationDTO.setCountry_id(rs.getString("country_id"));
			}
			
		} catch (Exception e) {
					// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
		
		return locationDTO;
	}
	
	
	//getCount
	//location의 주소 갯수를 리턴하고 출력
	public int getCount() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		int count = 0;
		try {
			con = dbConnect.getConnect();
			String sql = "SELECT COUNT(LOCATION_ID) FROM LOCATIONS";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			rs.next();
			count = rs.getInt("COUNT(LOCATION_ID)");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}//getCount 메서드 종료

	
	
	//getSearch
	//주소의 일부를 받아서 검색
	public ArrayList<LocationDTO> getSearch(String str) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		
		try {
			con = dbConnect.getConnect();
			
			//String sql = "SELECT * FROM LOCATIONS WHERE STREET_ADDRESS LIKE '%' || ? || '%' ";
			String sql = "SELECT * FROM LOCATIONS WHERE STREET_ADDRESS LIKE ? ";
			st = con.prepareStatement(sql);
			
			st.setString(1, "%"+str+"%");
			
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
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ar;
	}
	
	
//====================================================
	
	
	//Location Table에서 id와 일치하는 정보를 조회
	public LocationDTO getOne(int location_id) {
		
		//ADD-DTO Brannch
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		LocationDTO locationDTO = null;
		
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID=?";
			
			st = con.prepareStatement(sql);
			
			st.setInt(1, location_id);
			
			rs = st.executeQuery();
		
			if(rs.next()) {
				locationDTO = new LocationDTO();
				locationDTO.setLocation_id(rs.getInt("location_id"));
				locationDTO.setStreet_address(rs.getString("street_address"));
				locationDTO.setPostal_code(rs.getString("postal_code"));
				locationDTO.setCity(rs.getString("city"));
				locationDTO.setState_province(rs.getString("state_province"));
				locationDTO.setCountry_id(rs.getString("country_id"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return locationDTO;	
	}
	
	
//====================================================	

	
	public ArrayList<LocationDTO> getList() {
		System.out.println("getList 시   작");

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		
		try {		
			con = dbConnect.getConnect();
			System.out.println("접속 성공");
			System.out.println(con); // SQL 접속 과정
			
			//4. SQL문 생성
			String sql = ("SELECT * FROM LOCATIONS");
			
			//5. SQL 미리 보내기
			st = con.prepareStatement(sql);
			
			//6. 최종 전송 후 결과 처리
			rs = st.executeQuery();
			
			//결과 출력
			while(rs.next()) {
				LocationDTO	locationDTO = new LocationDTO();
				locationDTO.setLocation_id(rs.getInt("location_id"));
				locationDTO.setStreet_address(rs.getString("street_address"));
				locationDTO.setPostal_code(rs.getString("postal_code"));
				locationDTO.setCity(rs.getString("city"));
				locationDTO.setState_province(rs.getString("state_province"));
				locationDTO.setCountry_id(rs.getString("country_id"));
				ar.add(locationDTO);
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try { //다음 사람이 접속할 수 있게 자원을 역순으로 해제해야 한다.
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ar;
	}
}
