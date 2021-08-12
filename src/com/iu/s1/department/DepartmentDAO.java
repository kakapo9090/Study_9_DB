package com.iu.s1.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iu.s1.employee.EmployeeDTO;
import com.iu.s1.util.DBConnect;

public class DepartmentDAO {

	private DBConnect dbConnect;
	public DepartmentDAO() {
		dbConnect = new DBConnect();
	}
	
	//getJoin
	public Depart_EmpDTO getJoin(DepartmentDTO departmentDTO) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Depart_EmpDTO dto = null;
		
		try {
			con = dbConnect.getConnect();
			
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT E.LAST_NAME , E.SALARY, E.HIRE_DATE, D.DEPARTMENT_NAME");
			sb.append(" FROM EMPLOYEES E inner join DEPARTMENTS D");
			sb.append(" ON E.DEPARTMENT_ID = D.DEPARTMENT_ID");
			sb.append(" WHERE D.DEPARTMENT_ID=?");
			
			String sql = sb.toString();
			st = con.prepareStatement(sql);
			st.setInt(1, departmentDTO.getDepartment_id());
			
			rs = st.executeQuery();
			dto = new Depart_EmpDTO();
			dto.setAr(new ArrayList<EmployeeDTO>()); // dto에 setAr메서드 호출, 어레이리스트 담기
			
			while(rs.next()) {
				EmployeeDTO eDto = new EmployeeDTO();
				eDto.setLast_name(rs.getString("Last_Name"));
				eDto.setSalary(rs.getInt("SALARY"));
				eDto.setHire_date(rs.getString("hire_date"));
				dto.getAr().add(eDto); //dto 어레이리스트 불러와서 eDto에 담아뒀던 last_name, salary, hire_date넣음
				dto.setDepartment_name(rs.getString("department_name")); //다른테이블의 컬럼은 따로 붙여줘야함
			}// 1:1관계에선 그 클래스의 참조변수명에 세터게터 넣어서 리턴하면 되지만 1:N관계에선 어레이리스트를 
			//리턴해줘야 하기 때문에 add메서드 사용함
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
	return dto; //어레이리스트<DTO제네릭>타입의 변수 dto 리턴
		
	}//getJoin 종료
	
}


