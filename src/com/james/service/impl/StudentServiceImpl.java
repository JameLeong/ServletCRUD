package com.james.service.impl;

import java.util.List;

import com.james.dao.StudentDAO;
import com.james.dao.impl.StudentDAOImpl;
import com.james.entity.Student;
import com.james.service.StudentService;

public class StudentServiceImpl implements StudentService{
	/**
	 * 数据库操作
	 */
	
	private StudentDAO studentDao = new StudentDAOImpl();
	@Override
	public List<Student> getStudentsList() {
		return this.studentDao.getStudentsList();
	}
	@Override
	public Student getStudentById(int id) {
		return this.studentDao.getStudentById(id);
	}
	@Override
	public void update(Student stu) {
		this.studentDao.update(stu);
		
	}
	@Override
	public void addStudent(Student stu) {
		this.studentDao.addStudent(stu);
		
	}
	@Override
	public void deleteId(int id) {
		this.studentDao.deleteId(id);
		
	}
	@Override
	public List<Student> getStudentsByName(String name) {
		return this.studentDao.getStudentsByName(name);
	}

}
