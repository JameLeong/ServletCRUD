package com.james.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.james.dao.StudentDAO;
import com.james.entity.Student;
import com.james.utils.DBHelper;
import com.mysql.jdbc.PreparedStatement;

public class StudentDAOImpl implements StudentDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	@Override
	public List<Student> getStudentsList() {
		List<Student> students = new ArrayList<Student>();
		try {
			this.conn = DBHelper.getConnection();
			String sql = "select * from t_student";
			this.pstmt = (PreparedStatement) this.conn.prepareStatement(sql);
			 // 执行SQL语句并将查询结果放入结果集中
			ResultSet rs=pstmt.executeQuery();
			// 将结果集中的数据取出放入User类的对象中
			while(rs.next())
		    {
		        int id = Integer.parseInt(rs.getString("id"));
		        String name = rs.getString("name");
		        String password = rs.getString("password");
		        String school = rs.getString("school");
		        Student s = new Student(id, name, password, school);
		        students.add(s);
			}
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return students;
	}

	@Override
	public Student getStudentById(int id) {
		Student stu = null;
		try {
			this.conn = DBHelper.getConnection();
			String sql = "select * from t_student where id=?";
			this.pstmt = (PreparedStatement) this.conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			 // 执行SQL语句并将查询结果放入结果集中
			ResultSet rs=pstmt.executeQuery();
			// 将结果集中的数据取出放入User类的对象中
			if(rs.next())
		    {
		        String name = rs.getString("name");
		        String password = rs.getString("password");
		        String school = rs.getString("school");
		        stu= new Student(id, name, password, school);
			}
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stu;
	}

	@Override
	public void update(Student stu) {
		try {
			this.conn = DBHelper.getConnection();
			 String sql="update t_student set name=?,password=?,school=? where id=?";
			 this.pstmt=(PreparedStatement) conn.prepareStatement(sql);
			 pstmt.setString(1, stu.getName());
			 pstmt.setString(2, stu.getPassword());
			 pstmt.setString(3, stu.getSchool());
			 pstmt.setInt(4, stu.getId());
			 pstmt.executeUpdate();
			 pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addStudent(Student stu) {
		try {
			this.conn = DBHelper.getConnection();
			 String sql= "insert into t_student (name,password,school) values(?,?,?)";  
			 this.pstmt=(PreparedStatement) conn.prepareStatement(sql);
			 pstmt.setString(1, stu.getName());
			 pstmt.setString(2, stu.getPassword());
			 pstmt.setString(3, stu.getSchool());
			 pstmt.executeUpdate();
			 pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteId(int id) {
		try {
			this.conn = DBHelper.getConnection();
			 String sql="delete from t_student where id=?";
			 this.pstmt=(PreparedStatement) conn.prepareStatement(sql);
			 pstmt.setInt(1, id);
			 pstmt.executeUpdate();
			 pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Student> getStudentsByName(String name) {
		List<Student> students = new ArrayList<Student>();
		try {
			this.conn = DBHelper.getConnection();
			String sql = "select * from t_student where name like ?";
			this.pstmt = (PreparedStatement) this.conn.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");
			 // 执行SQL语句并将查询结果放入结果集中
			ResultSet rs=pstmt.executeQuery();
			// 将结果集中的数据取出放入User类的对象中
			while(rs.next())
		    {
		        int id = Integer.parseInt(rs.getString("id"));
		        String studentName = rs.getString("name");
		        String password = rs.getString("password");
		        String school = rs.getString("school");
		        Student s = new Student(id, studentName, password, school);
		        students.add(s);
			}
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

}
