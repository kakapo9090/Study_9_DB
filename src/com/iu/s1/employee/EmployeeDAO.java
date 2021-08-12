package com.iu.s1.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.iu.s1.department.DepartmentDTO;
import com.iu.s1.department.Emp_DepartDTO;
import com.iu.s1.location.LocationDTO;
import com.iu.s1.util.DBConnect;

public class EmployeeDAO {

	private DBConnect dbConnect;
	public EmployeeDAO() {
		dbConnect = new DBConnect();
	}
	
	//getJoin
	public Emp_DepartDTO getJoin(EmployeeDTO employeeDTO) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Emp_DepartDTO dto = null;
		try {
			con = dbConnect.getConnect();	
			
			StringBuffer sb = new StringBuffer();			
			sb.append("SELECT E.LAST_NAME, E.SALARY, E.HIRE_DATE, D.DEPARTMENT_NAME");
			sb.append(" FROM EMPLOYEES E inner join DEPARTMENTS D");
			sb.append(" ON (E.DEPARTMENT_ID = D.DEPARTMENT_ID)");		
			sb.append(" WHERE E.EMPLOYEE_ID=?");
					
			String sql = sb.toString();
			st = con.prepareStatement(sql);
			st.setInt(1, employeeDTO.getEmployee_id());
			
			rs = st.executeQuery();
			
			
			
			if(rs.next()) {
				dto = new Emp_DepartDTO();
				dto.setDepartmentDTO(new DepartmentDTO());
				
				dto.setLast_name(rs.getString("LAST_NAME"));
				dto.setSalary(rs.getInt("SALARY"));
				dto.setHire_date(rs.getString("HIRE_DATE"));
				dto.getDepartmentDTO().setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
		return dto;
	}
	
	
	
	
	//1. 전체 사원 출력
	public ArrayList<EmployeeDTO> getList() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		
		try {
			con = dbConnect.getConnect(); //접속정보 호출
			
			String sql = "SELECT * FROM EMPLOYEES";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				EmployeeDTO employeeDTO = new EmployeeDTO();
				employeeDTO.setEmployee_id(rs.getInt("employee_id"));
				employeeDTO.setFirst_name(rs.getString("first_name"));
				employeeDTO.setLast_name(rs.getString("last_name"));
				employeeDTO.setEmail(rs.getString("email"));
				employeeDTO.setPhone_number(rs.getString("phone_number"));
				employeeDTO.setHire_date(rs.getString("hire_date"));
				employeeDTO.setJob_id(rs.getString("job_id"));
				employeeDTO.setSalary(rs.getInt("salary"));
				employeeDTO.setCommission_pct(rs.getDouble("commission_pct"));
				employeeDTO.setManager_id(rs.getInt("manager_id"));
				employeeDTO.setDepartment_id(rs.getInt("department_id"));
				ar.add(employeeDTO);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
		
		return ar;
	}// getList() 종료
	
	
	
	
	
	//2. 사원번호를 입력해서 한 사원 정보 출력
	public EmployeeDTO getOne(int num) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmployeeDTO employeeDTO = null;
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, num);
			rs = st.executeQuery();
			
			if(rs.next()){
			employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("employee_id"));
			employeeDTO.setFirst_name(rs.getString("first_name"));
			employeeDTO.setLast_name(rs.getString("last_name"));
			employeeDTO.setEmail(rs.getString("email"));
			employeeDTO.setPhone_number(rs.getString("phone_number"));
			employeeDTO.setHire_date(rs.getString("hire_date"));
			employeeDTO.setJob_id(rs.getString("job_id"));
			employeeDTO.setSalary(rs.getInt("salary"));
			employeeDTO.setCommission_pct(rs.getDouble("commission_pct"));
			employeeDTO.setManager_id(rs.getInt("manager_id"));
			employeeDTO.setDepartment_id(rs.getInt("department_id"));
			
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
		
		return employeeDTO;
	}// getOne() 종료
	
	
	
	
	
	//3. Last_name검색 정보 출력
	public ArrayList<EmployeeDTO> getLastName(String str) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
	
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT * FROM EMPLOYEES WHERE LAST_NAME LIKE ? ";
			st = con.prepareStatement(sql);
			st.setString(1, "%"+str+"%");
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				EmployeeDTO employeeDTO = new EmployeeDTO();
				employeeDTO.setEmployee_id(rs.getInt("employee_id"));
				employeeDTO.setFirst_name(rs.getString("first_name"));
				employeeDTO.setLast_name(rs.getString("last_name"));
				employeeDTO.setEmail(rs.getString("email"));
				employeeDTO.setPhone_number(rs.getString("phone_number"));
				employeeDTO.setHire_date(rs.getString("hire_date"));
				employeeDTO.setJob_id(rs.getString("job_id"));
				employeeDTO.setSalary(rs.getInt("salary"));
				employeeDTO.setCommission_pct(rs.getDouble("commission_pct"));
				employeeDTO.setManager_id(rs.getInt("manager_id"));
				employeeDTO.setDepartment_id(rs.getInt("department_id"));
				
				ar.add(employeeDTO);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
		
		return ar;
	} //getLastName() 종료
	
	
	
	
	
	//4. First_name검색 정보 출력
	public ArrayList<EmployeeDTO> getFirstName(String str) {
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		
			try {
				con = dbConnect.getConnect();
				
				String sql = "SELECT * FROM EMPLOYEES WHERE FIRST_NAME LIKE ? ";
				st = con.prepareStatement(sql);
				st.setString(1, "%"+str+"%");
				
				rs = st.executeQuery();
				
				while(rs.next()) {
					EmployeeDTO employeeDTO = new EmployeeDTO();
					employeeDTO.setEmployee_id(rs.getInt("employee_id"));
					employeeDTO.setFirst_name(rs.getString("first_name"));
					employeeDTO.setLast_name(rs.getString("last_name"));
					employeeDTO.setEmail(rs.getString("email"));
					employeeDTO.setPhone_number(rs.getString("phone_number"));
					employeeDTO.setHire_date(rs.getString("hire_date"));
					employeeDTO.setJob_id(rs.getString("job_id"));
					employeeDTO.setSalary(rs.getInt("salary"));
					employeeDTO.setCommission_pct(rs.getDouble("commission_pct"));
					employeeDTO.setManager_id(rs.getInt("manager_id"));
					employeeDTO.setDepartment_id(rs.getInt("department_id"));
					
					ar.add(employeeDTO);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				dbConnect.disConnect(rs, st, con);
			}
			
			return ar;
		} //getLastName() 종료
	
	
	
	
	
	
	//5. 전체 평균 급여의 정보를 출력
	public double getSalaryAvg() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		double avg = 0.0;
		
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT AVG(SALARY) FROM EMPLOYEES";
			
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			rs.next();
			avg = rs.getDouble("AVG(SALARY)");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
		return avg;
		
	}//getSalaryAvg() 종료
	
	
	
	
	
	
	//6. 부서별 평균 급여의 정보 출력
	public ArrayList<EmployeeDTO> getSalaryAvgDepartment() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
	
			try {
				con = dbConnect.getConnect();
				
				String sql = "SELECT AVG(SALARY), DEPARTMENT_ID FROM EMPLOYEES GROUP BY DEPARTMENT_ID";
				
				st = con.prepareStatement(sql);
				rs = st.executeQuery();
				
				while(rs.next()) {
					EmployeeDTO employeeDTO = new EmployeeDTO();
					employeeDTO.setSalaryAvg(rs.getDouble("avg(salary)"));
					employeeDTO.setDepartment_id(rs.getInt("department_id"));
					
					
					ar.add(employeeDTO);
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				dbConnect.disConnect(rs, st, con);
			}
			return ar;
	}//getSalaryAvgDepartment() 종료
	
	
	
	//6-1 Map활용
	public void getAvg2() {
		HashMap<String, Object> obj = new HashMap<>();
		obj.put("id", 20);
		obj.put("avg", 10000.12);
	}
}// 클래스 종료