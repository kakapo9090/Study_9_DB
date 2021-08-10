package com.iu.s1.employee;

import java.util.ArrayList;

public class EmployeeView {
	
	//view2() ArrayList 매개변수
	public void view2(ArrayList<EmployeeDTO> ar) {
		for(int i=0; i<ar.size(); i++) {
			this.view2(ar.get(i));
		}
	}
	
	//view2() EmployeeDTO 매개변수
	public void view2(EmployeeDTO employeeDTO) {
		System.out.print(employeeDTO.getSalaryAvg()+"\t");
		System.out.println("\t"+"\t"+employeeDTO.getDepartment_id());
		System.out.println("-------------------------------------------");
	}
	
	
	
	
	//view() avg 매개변수
	public void view(double avg) {
		System.out.println("전체 평균 급여 : "+avg);
	}
	
	
	//view() ArrayList 매개변수
	public void view(ArrayList<EmployeeDTO> ar) {
		for(int i=0; i<ar.size(); i++) {
			this.view(ar.get(i));
		}
	}
	
	
	//view() EmployeeDTO 매개변수
	public void view(EmployeeDTO employeeDTO) {
		System.out.print(employeeDTO.getEmployee_id()+"\t");
		System.out.print(employeeDTO.getFirst_name()+"\t");
		System.out.print(employeeDTO.getLast_name()+"\t");
		System.out.print(employeeDTO.getEmail()+"\t");
		System.out.print(employeeDTO.getPhone_number()+"\t");
		System.out.print(employeeDTO.getHire_date()+"\t");
		System.out.print(employeeDTO.getJob_id()+"\t");
		System.out.print(employeeDTO.getSalary()+"\t");
		System.out.print(employeeDTO.getCommission_pct()+"\t");
		System.out.print(employeeDTO.getManager_id()+"\t");
		System.out.println(employeeDTO.getDepartment_id());
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
	}
}
