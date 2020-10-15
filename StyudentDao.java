package com.web;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StyudentDao {
private Connection conn= null;
private ResultSet rs=null;
private PreparedStatement ps=null;

public boolean addStudent(StudentDto dto,InputStream photo) {
boolean flag =false;
if(conn == null) {
	conn=StudentDb.getStudentDb();
	}try {
	String query= "insert into std_master(name,email,pwd,mno,dob,city,gender,photo,hobby )values(?,?,?,?,?,?,?,?,?,?)";
			 
	ps=conn.prepareStatement(query)	;
	ps.setString(1, dto.getName());
	ps.setString(2,dto.getEmail());
	ps.setString(3, dto.getPwd());
	ps.setString(4, dto.getMno());
	ps.setString(5, dto.getDob());
	ps.setString(6, dto.getCity());
	ps.setString(7, dto.getGebnder());
	ps.setBlob(8, photo);
	ps.setString(9,dto.getHobby());

	if(ps.executeUpdate()>0)
		flag=true;
	}
catch(Exception e){
	System.out.println("Exception at addStudent():"+e);
}finally {
	ps=null;
	conn=null;
	return flag;
}
}
}