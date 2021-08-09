package com.iu.s1.location;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iu.s1.util.DBConnect;

public class LocationDAO {

	private DBConnect dbConnect;
	
	public LocationDAO() {
		dbConnect = new DBConnect();
	}
	
	//Location Table에서 id와 일치하는 정보를 조회
	public void getOne(int location_id) {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID=?";
			
			st = con.prepareStatement(sql);
			
			st.setInt(1, location_id);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				//출력
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
	
//====================================================	
	
	
	
	
	
	
	public void getList() {
		System.out.println("시   작");

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
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
				System.out.print(rs.getInt("LOCATION_ID")+"\t");
				System.out.print(rs.getString("STREET_ADDRESS")+"\t");
				System.out.print(rs.getString("POSTAL_CODE")+"\t");
				System.out.print(rs.getString("CITY")+"\t");
				System.out.print(rs.getString("STATE_PROVINCE")+"\t");
				System.out.println(rs.getString("COUNTRY_ID"));
				System.out.println("----------------------------------------------------------------------------");
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
		
		
	}
}
