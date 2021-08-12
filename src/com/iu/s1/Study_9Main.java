package com.iu.s1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iu.s1.location.LocationController;
import com.iu.s1.location.LocationDAO;
import com.iu.s1.location.LocationDTO;
import com.iu.s1.location.LocationView;
import com.iu.s1.util.DBConnect;

public class Study_9Main {

	public static void main(String[] args) {
		LocationController lc = new LocationController();
		lc.start();
		
//		LocationDAO locationDAO = new LocationDAO();
//		LocationDTO locationDTO = new LocationDTO();
//		locationDTO.setLocation_id(1000);
//		locationDTO = locationDAO.getOne(locationDTO);
//		
//		if(locationDTO != null) {
//		
//		System.out.println(locationDTO.getLocation_id());
//		System.out.println(locationDTO.getStreet_address());
//		System.out.println(locationDTO.getCity());
//		}else {
//			System.out.println("조회 실패");
//		}

		
//		LocationDAO locationDAO = new LocationDAO();
//		ArrayList<LocationDTO> ar =locationDAO.getList();
//		LocationView locationView = new LocationView();
//		locationView.view(ar);
//		
		
//		for(int i=0; i<ar.size();i++) {
//			System.out.print(ar.get(i).getLocation_id()+"\t");
//			System.out.print(ar.get(i).getStreet_address()+"\t");
//			System.out.print(ar.get(i).getPostal_code()+"\t");
//			System.out.print(ar.get(i).getCity()+"\t");
//			System.out.print(ar.get(i).getState_province()+"\t");
//			System.out.println(ar.get(i).getCountry_id());
//			System.out.println("-----------------------------------------------------------------------------");
//		}
		
	}

}
