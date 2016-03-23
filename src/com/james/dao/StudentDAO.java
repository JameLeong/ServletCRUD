package com.james.dao;

import java.util.List;

import com.james.entity.Student;

public interface StudentDAO {
	public List<Student> getStudentsList();
	/**
	 * 根据id获取学生
	 * @param parseInt
	 * @return
	 */
	public Student getStudentById(int id);
	/**
	 * 更新
	 * @param stu
	 */
	public void update(Student stu);
	/**
	 * 新增
	 * @param stu
	 */
	public void addStudent(Student stu);
	/**
	 * 根据id删除学生
	 * @param id
	 */
	public void deleteId(int id);
	/**
	 * 查询：根据姓名
	 * @param name
	 * @return
	 */
	public List<Student> getStudentsByName(String name);


}
