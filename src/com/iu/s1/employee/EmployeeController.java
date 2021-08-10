package com.iu.s1.employee;

import java.util.ArrayList;

public class EmployeeController {
	
	private EmployeeDAO employeeDAO;
	private EmployeeView employeeView;//출력
	
	public EmployeeController() {
		employeeDAO = new EmployeeDAO();
		employeeView = new EmployeeView();
	}
	
	public void start() {
		//1. 전체 사원 출력
//		ArrayList<EmployeeDTO> ar = employeeDAO.getList();
//		employeeView.view(ar);
		
		//2. 한 사원 번호 출력	
//		ArrayList<EmployeeDTO> ar = employeeDAO.getOne(150);
//		employeeView.view(ar);
		
		//3. Last_name 검색
//		ArrayList<EmployeeDTO> ar = employeeDAO.getLastName("st");
//		employeeView.view(ar);
		
		//4. FIrst_name 검색
//		ArrayList<EmployeeDTO> ar = employeeDAO.getFirstName("Do");
//		employeeView.view(ar);		
		
		//5. 전체 평균 급여 정보 출력
//		double avg = employeeDAO.getSalaryAvg();
//		employeeView.view(avg);
		
		//6. 부서별 평균 급여의 정보 출력
		ArrayList<EmployeeDTO> ar = employeeDAO.getSalaryAvgDepartment();
		System.out.println("AVG(SALARY)"+"\t"+"\t"+"DEPARTMENT_ID");
		employeeView.view2(ar);
		
	}// start() 종료
	
}// 클래스 종료