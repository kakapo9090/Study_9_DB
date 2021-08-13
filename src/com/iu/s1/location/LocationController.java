package com.iu.s1.location;

import java.util.ArrayList;
import java.util.Scanner;

public class LocationController {

	private LocationDAO locationDAO;
	private LocationView locationView;
	private Scanner sc;
	private LocationInput locationInput;
	
	
	//생성자
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
		//삭제시 오류 발생 -> 직접 추가한 지역을 삭제
		System.out.println("3. 지역 정보 추가"); //insert
		System.out.println("4. 지역 정보 삭제"); //delete
		System.out.println("5. 종   료");
		
		int select = sc.nextInt();
		
		//1. 전체 정보 출력
		if(select==1) {
			ArrayList<LocationDTO> ar = locationDAO.getList();
			if(ar.size()>0) {
				locationView.view(ar);
				
			}else {
				locationView.view("Data가 없어요");
			}
			
		//2. 한개 정보 출력	
		}else if(select==2) {
			
			LocationDTO locationDTO = locationInput.inputId(sc);
			
			locationDTO = locationDAO.getOne(locationDTO);
			
			if(locationDTO != null) {
				locationView.view(locationDTO);//출력
				
			}else {
				locationView.view("없는 ID 입니다");
			}
		
			
			
		//3. 지역 정보 추가
		}else if(select==3) {
			LocationDTO locationDTO = new LocationDTO();
			//입력담당 클래스의 메서드 호출 (setter)
			locationDTO = locationInput.inputId(sc);
			locationDTO = locationInput.inputAddress(sc);
			locationDTO = locationInput.inputPostal(sc);
			locationDTO = locationInput.inputCity(sc);
			locationDTO = locationInput.inputState(sc);
			locationDTO = locationInput.inputCountry_id(sc);
			
			int result = locationDAO.setInsert(locationDTO);
			if(result>0) {
				//출력담당 클래스의 메서드 호출 (getter)
				locationView.view("INSERT 완료");
				
			}else {
				locationView.view("INSERT 실패");
			}
			
			
			
			
		//4. 지역 정보 삭제	
		}else if(select==4) {
			
			
			
			
		//5. 종료	
		}else {
			check=false;
			break;
		}
		
		
		}//while(check) 종료
		
	}//start() 메서드 종료
	
	
	
	
}//LocationController 클래스 종료
