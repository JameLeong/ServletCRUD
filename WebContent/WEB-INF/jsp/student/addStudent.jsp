<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.james.entity.Student"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/res/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/res/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/res/Css/style.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/res/Js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/res/Js/jquery.sorted.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/res/Js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/res/Js/ckform.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/res/Js/common.js"></script>
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
	<form action="${pageContext.request.contextPath}/student/addStudent.action" method="post" class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft">学生姓名</td>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td class="tableleft">密码</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td class="tableleft">学校</td>
				<td><input type="text" name="school" /></td>
			</tr>
			<tr>
				<td class="tableleft"></td>
				<td>
					<button type="submit" class="btn btn-primary" type="button">保存</button>
					&nbsp;&nbsp;
					<button type="button" class="btn btn-success" name="backid"
						id="backid">返回学生列表</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
<script>
	$(function() {
		$('#backid').click(function() {
			window.location.href = '${pageContext.request.contextPath}/student/studentList.action';
		});

	});
</script>