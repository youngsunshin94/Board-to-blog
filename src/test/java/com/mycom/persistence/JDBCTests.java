package com.mycom.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	@Test
	public void setUp() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try(Connection con = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/board_ex?useSSL=false&serverTimezone=Asia/Seoul",		
	/* User */  "root",
/* password */  "root")){
			log.info(con);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

