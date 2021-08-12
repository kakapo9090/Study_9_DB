package com.iu.s1.department;

import com.iu.s1.employee.EmployeeDTO;


//EMPLOYEES 테이블과 DEPARTMENTS 테이블을 조인한것을 표현한 클래스 
public class Emp_DepartDTO extends EmployeeDTO {

	//사원은 부서를 가지고 있다 1:1
	private DepartmentDTO departmentDTO;

	public Emp_DepartDTO() {
		departmentDTO = new DepartmentDTO();
	}
	
	//setter 호출을 해서 DepartmentDTO생성자를 매개변수로 넣으면
	//getter를 통해 DepartmentDTO 클래스의 인스턴스 변수들을 사용할 수 있다.
	
	
	public DepartmentDTO getDepartmentDTO() {
		return departmentDTO;
	}

	public void setDepartmentDTO(DepartmentDTO departmentDTO) {
		this.departmentDTO = departmentDTO;
	}
	
	
}
