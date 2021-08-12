package com.iu.s1.location;

import java.util.ArrayList;
import java.util.Scanner;

public class LocationController {

	private LocationDAO locationDAO;
	private LocationView locationView;
	private Scanner sc;
	private LocationInput locationInput;
	
	public LocationController() {
		locationDAO = new LocationDAO();
		this.locationView = new LocationView();
		sc = new Scanner(System.in);
		locationInput = new LocationInput();
	}
	
	public void start() {
		
		boolean check = true;
		
		while(check) {
		System.out.println("1. 전체 정보 출력");
		System.out.println("2. 한개 정보 출력");
		System.out.println("3. 종   료");
		
		int select = sc.nextInt();
		
		if(select==1) {
			ArrayList<LocationDTO> ar = locationDAO.getList();
			if(ar.size()>0) {
				locationView.view(ar);
				
			}else {
				locationView.view("Data가 없어요");
			}
			
			
		}else if(select==2) {
			
			LocationDTO locationDTO = locationInput.inputId(sc);
			
			locationDTO = locationDAO.getOne(locationDTO);
			
			if(locationDTO != null) {
				locationView.view(locationDTO);
				
			}else {
				locationView.view("없는 ID 입니다");
			}
			
			
			
		}else {
			check=false;
			break;
		}
		
		
		}//while(check) 종료
		
	}//start() 메서드 종료
	
	
	
	
}//LocationController 클래스 종료
