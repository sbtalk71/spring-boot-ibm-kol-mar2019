package com.demo.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Component;

//@Component
public class MyJdbcRunner1 implements CommandLineRunner {

	@Autowired
	JdbcTemplate jt;
	@Override
	public void run(String... args) throws Exception {
		
		String INSERT_SQL="insert into emp(empno,name,address,salary) values(?,?,?,?)";
		
		int count=jt.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst= con.prepareStatement(INSERT_SQL);
				pst.setInt(1, 105);
				pst.setString(2, "Kartik");
				pst.setString(3, "Kolkata");
				pst.setDouble(4, 56000);
				return pst;
			}
		});
		
		System.out.println("Rows Inserted : "+count);

	}

}
