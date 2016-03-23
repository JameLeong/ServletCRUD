package com.james.entity;
/**
 * 学生
 * @author James
 *
 */
public class Student {
	private int id;
	private String name;
	private String password;
	private String school;
	
	public Student() {
		super();
	}
	public Student( String name, String password, String school) {
		this.name = name;
		this.password = password;
		this.school = school;
	}
	public Student(int id, String name, String password, String school) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.school = school;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	
	

}
