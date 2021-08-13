package com.iu.s1.location;

import java.util.Scanner;

public class LocationInput {
	
	//ID입력
	public LocationDTO inputId(Scanner sc) {
		LocationDTO locationDTO = new LocationDTO();
		System.out.println("Location ID를 입력하세요");
		int location_id = sc.nextInt();
		locationDTO.setLocation_id(location_id);
		return locationDTO;
	}//inputId() 종료
	
	
	//주소입력
	public LocationDTO inputAddress(Scanner sc) {
		LocationDTO locationDTO = new LocationDTO();
		System.out.println("Street Address를 입력하세요");
		String street_address = sc.next();
		locationDTO.setStreet_address(street_address);
		return locationDTO;
	}
	
	
	//우편번호입력
	public LocationDTO inputPostal(Scanner sc) {
		LocationDTO locationDTO = new LocationDTO();
		System.out.println("Postal Code를 입력하세요");
		String postal_code = sc.next();
		locationDTO.setPostal_code(postal_code);
		return locationDTO;
	}
	
	//도시 입력
	public LocationDTO inputCity(Scanner sc) {
		LocationDTO locationDTO = new LocationDTO();
		System.out.println("City 입력하세요");
		String city = sc.next();
		locationDTO.setCity(city);
		return locationDTO;
	}
	
	//주 입력
	public LocationDTO inputState(Scanner sc) {
		LocationDTO locationDTO = new LocationDTO();
		System.out.println("State Province 입력하세요");
		String state_province = sc.next();
		locationDTO.setState_province(state_province);
		return locationDTO;
	}
	
	//국가 입력
	public LocationDTO inputCountry_id(Scanner sc) {
		LocationDTO locationDTO = new LocationDTO();
		System.out.println("Country ID 입력하세요");
		String country_id = sc.next();
		locationDTO.setCountry_id(country_id);
		return locationDTO;
	}
}
