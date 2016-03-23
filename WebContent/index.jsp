<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>后台管理系统</title>
	<meta charset="UTF-8">
   <link rel="stylesheet" type="text/css" href="res/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="res/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="res/Css/style.css" />
    <script type="text/javascript" src="res/Js/jquery.js"></script>
    <script type="text/javascript" src="res/Js/bootstrap.js"></script>
    <script type="text/javascript" src="res/Js/ckform.js"></script>
    <script type="text/javascript" src="res/Js/common.js"></script>
    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-signin {
            max-width: 300px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }

    </style>  
</head>
<body>
<div class="container">
    <form class="form-signin" method="post" action="login.action">
        <h2 class="form-signin-heading">登录系统</h2>
        <input type="text" name="username" class="input-block-level" placeholder="账号">
        <input type="password" name="password" class="input-block-level" placeholder="密码">
        <label class="radio inline" >
        <input type="radio" name="who" value="stu" checked />学生
		</label>
		<label class="radio inline">
		<input type="radio" name="who" value="admin" checked />管理员
		</label>
		<br/><br/>
        <p><button class="btn btn-large btn-primary" type="submit">登录</button></p>
        <center>
        <div style="color:red">
        <%
   			request.setCharacterEncoding("UTF-8");
   			String info = (String)request.getAttribute("info");
   			if(info != null){
     			out.println(info);
   		   }
        %>
        </div>
        </center>
    </form>

</div>
</body>
</html>