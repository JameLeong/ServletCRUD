<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.james.entity.Student" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/Css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/res/Js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/Js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/Js/ckform.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/Js/common.js"></script>
<style type="text/css">
body {
	padding-bottom: 40px;
}
.sidebar-nav {
	padding: 9px 0;
}
@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
</head>
<body>
	<form class="form-inline definewidth m20" >
		学生名称： 
		<input type="text" name="name" class="input-default" id="find_name" />&nbsp;&nbsp;
		<div class="btn btn-primary" onclick="find()" >查询</div>&nbsp;&nbsp;
		<button type="button" class="btn btn-success" id="addnew">新增学生</button>
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>id</th>
				<th>姓名</th>
				<th>密码</th>
				<th>学校</th>
				<th>操作</th>
				<th>删除</th>
			</tr>
		</thead>
		<tbody>
		<%
		  List<Student> stus = (List<Student>)request.getAttribute("students");
		  for(Student stu:stus){
			  out.print("<tr>");
			  out.print("<td>"+stu.getId()+"</td>");
			  out.print("<td>"+stu.getName()+"</td>");
			  out.print("<td>"+stu.getPassword()+"</td>");
			  out.print("<td>"+stu.getSchool()+"</td>");
			  out.print("<td><a href='"+request.getContextPath()+"/student/editStudent.action?id="+stu.getId()+"'>编辑</a></td>");
			  out.print("<td><a href='#' onclick='del("+stu.getId()+")')>删除</a></td>");
			  out.print("</tr>");
		  }
		%>
		</tbody>
	</table>
	<!-- 信息删除确认 -->
<div class="modal fade" id="delcfmModel">
  <div class="modal-dialog">
    <div class="modal-content message_align">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
        <h4 class="modal-title">提示信息</h4>
      </div>
      <div class="modal-body">
        <p>您确认要删除吗？</p>
      </div>
      <div class="modal-footer">
      	 <input type="hidden" id="url"/>
      	 <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
      	 <a  onclick="delStu()" class="btn btn-success" data-dismiss="modal">确定</a>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
	
</body>
</html>

<script>
	$(function() {
		$('#addnew').click(function() {
			window.location.href = "${pageContext.request.contextPath}/student/addStudentPage.action";
		});
		$('#find_name').keydown(function(e){
			if(e.keyCode==13){
				find();
			}
		});
	});
	//查找
	function find(){
		var name = $("#find_name").val();
		 $.ajax({
             type: "POST",
             url: "${pageContext.request.contextPath}/student/findStudent.action",
             dataType:"text",
             async: false,
             data: 'name=' + name,
             success: function(result) {
            	//var json = JSON.stringify(result);
            	$("tbody").html("");
            	var json = jQuery.parseJSON(result);
            	$.each(json, function(index, content){ 
            		$.each(content, function(index, data){ 
            		  var name = data.name;
            		  var id = data.id;
            		  var password = data.password;
            		  var school = data.school;
            		  var s= "<tr>";
           			  s += "<td>"+id+"</td>";
           			  s += "<td>"+name+"</td>";
            		  s += "<td>"+password+"</td>";
            		  s += "<td>"+school+"</td>";
            	      s +="<td><a href='<%=request.getContextPath()%>/student/editStudent.action?id="+id+"'>编辑</a></td>";
		 			  s +="<td><a href='#' onclick='del("+id+")')>删除</a></td>";
		 			  s +="</tr>";
		 			  $("tbody").append(s); 
              		  //alert(name+" "+id+" "+password+" "+school); 
            		});
            	}); 
             },error: function(result) { 
			    /* alert("ERROR");  */
			 } 
         });
	}
	//将要删除的id
	var del_id;
	//删除
	function delStu(){
		window.location.href = "${pageContext.request.contextPath}/student/deleteStudent.action?id="+del_id;
	}
	//删除确认
	function del(id) {
		del_id = id;
		$('#delcfmModel').modal();  
	}
</script>