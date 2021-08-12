package com.iu.s1.location;

import java.util.ArrayList;

public class LocationController {

	private LocationDAO locationDAO;
	private LocationView locationView;
	
	
	public LocationController() {
		locationDAO = new LocationDAO();
		locationView = new LocationView();
	}
	
	public void start() {

		LocationDTO locationDTO = locationDAO.getLocation(100);
		locationView.view(locationDTO);
		
//		int count = locationDAO.getCount();
//		locationView.view(count);
		
//		ArrayList<LocationDTO> ar = locationDAO.getSearch("Vi");
//		locationView.view(ar);
		
		//DB에서 Location Table의 모든 정보를 조회
//		ArrayList<LocationDTO> ar = locationDAO.getList();
//		locationView.view(ar);
//		LocationDTO locationDTO = locationDAO.getOne(1000);
//		locationView.view(locationDTO);
		
	}
	
}
