<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>校园文章管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="res/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="res/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="res/assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="header">
    <div class="dl-title">学生文章管理系统</div>
    <div class="dl-log">欢迎您，<span class="dl-log-user"><%=session.getAttribute("username")%></span><a href="logout.action" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">学生信息</div></li>		
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-order">管理员信息</div></li>
        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
</div>
<script type="text/javascript" src="res/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="res/assets/js/bui-min.js"></script>
<script type="text/javascript" src="res/assets/js/common/main-min.js"></script>
<script type="text/javascript" src="res/assets/js/config-min.js"></script>
<script>
    BUI.use('common/main',function(){
        var config = [
		{id:'1',homePage : '3',
		             menu:[{text:'学生信息',
				      items:[{id:'3',text:'学生列表',href:'${pageContext.request.contextPath}/student/studentList.action'},
							 {id:'4',text:'学生文章',href:'User/index.html'}]}]},
		{id:'7',homePage : '9',
		             menu:[{text:'管理员信息',
		             items:[{id:'9',text:'管理员列表',href:'Node/index.html'}]}]}];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>
<div style="text-align:center;">
</div>
</body>
</html>