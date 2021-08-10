package com.iu.s1;

import java.sql.Connection;
import java.sql.SQLException;

import com.iu.s1.employee.EmployeeController;
import com.iu.s1.location.LocationController;
import com.iu.s1.location.LocationDAO;
import com.iu.s1.util.DBConnect;

public class Study_9Main {

	public static void main(String[] args) {
//		LocationController lc = new LocationController();
//		lc.start();
		
		EmployeeController ec = new EmployeeController();
		ec.start();

	}

}
