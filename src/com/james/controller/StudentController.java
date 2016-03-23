package com.james.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.james.entity.Student;
import com.james.service.StudentService;
import com.james.service.impl.StudentServiceImpl;

public class StudentController extends HttpServlet{

	/**
	 * UID
	 */
	private static final long serialVersionUID = 2041784938477390942L;
	
	/**
	 * 登陆业务
	 */
	private StudentService studentService = new StudentServiceImpl();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  response.setContentType("text/xml;character=utf-8");
		  String requestURI = request.getRequestURI();  
	      System.out.println("requestURI=" + requestURI);  
	      String path = requestURI.substring(requestURI.indexOf("/",1),requestURI.indexOf("."));  
	      System.out.println("path = " +path);  
	      if(path.equals("/student/studentList")){
	    	  List<Student> stus = this.studentService.getStudentsList();
	    	  request.setAttribute("students", stus);
	    	  request.getRequestDispatcher("/WEB-INF/jsp/student/listStudent.jsp").forward(request,response);
	      }else if(path.equals("/student/editStudent")){
	    	  //获取编辑的id
	    	  String id = request.getParameter("id");  
	    	  Student stu = this.studentService.getStudentById(Integer.parseInt(id));
	    	  request.setAttribute("student", stu);
	    	  request.getRequestDispatcher("/WEB-INF/jsp/student/editStudent.jsp").forward(request,response);
	      }else if(path.equals("/student/updateStudent")){
	    	  int id = Integer.parseInt(request.getParameter("id"));  
	    	  String name = request.getParameter("name");  
	    	  String password = request.getParameter("password");  
	    	  String school = request.getParameter("school");  
	    	  Student stu = new Student(id, name, password, school);
	    	  this.studentService.update(stu);
	    	  //显示列表
	    	  List<Student> stus = this.studentService.getStudentsList();
	    	  request.setAttribute("students", stus);
	    	  request.getRequestDispatcher("/WEB-INF/jsp/student/listStudent.jsp").forward(request,response);
	      }else if(path.equals("/student/addStudentPage")){
	    	  request.getRequestDispatcher("/WEB-INF/jsp/student/addStudent.jsp").forward(request,response);
	      }else if(path.equals("/student/addStudent")){
	    	  String name = request.getParameter("name");  
	    	  String password = request.getParameter("password");  
	    	  String school = request.getParameter("school");  
	    	  Student stu = new Student(name, password, school);
	    	  this.studentService.addStudent(stu);
	    	  //显示列表
	    	  List<Student> stus = this.studentService.getStudentsList();
	    	  request.setAttribute("students", stus);
	    	  request.getRequestDispatcher("/WEB-INF/jsp/student/listStudent.jsp").forward(request,response);
	      }else if(path.equals("/student/deleteStudent")){
	    	  int id = Integer.parseInt(request.getParameter("id"));  
	    	  this.studentService.deleteId(id);
	    	  //显示列表
	    	  List<Student> stus = this.studentService.getStudentsList();
	    	  request.setAttribute("students", stus);
	    	  request.getRequestDispatcher("/WEB-INF/jsp/student/listStudent.jsp").forward(request,response);
	      }else if(path.equals("/student/findStudent")){
	    	  String name = request.getParameter("name");  
	    	  List<Student> students = this.studentService.getStudentsByName(name);
	    	  if(students==null || students.size()==0){
	    		  System.out.println(name); 
	    	  }else{
	 	    	  JSONObject jsonObject = new JSONObject();  
	 	          jsonObject.put("students", students);  
	 	        /*JSONArray jsonArray = new JSONArray();  
	 	          jsonArray.add(jsonObject);  */
	 	          System.out.println(jsonObject);  
	 	          response.getWriter().write(jsonObject.toString()); 
	    	  }
	      }else{  
	            System.out.println("未知请求");
	      }  
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("get");
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("post");
		super.doPost(req, resp);
	}
}
