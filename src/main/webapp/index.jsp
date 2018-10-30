<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>智慧药房后台管理中心</title>
</head>
<frameset rows="100,*" cols="*" scrolling="No" framespacing="0" frameborder="no" border="0">
    <frame src="adminPage/head.jsp" name="headmenu" id="mainFrame" title="mainFrame"><!-- 引用头部 -->
    <!-- 引用左边和主体部分 -->
    <frameset rows="100*" cols="220,*" scrolling="No" framespacing="0" frameborder="no" border="0">
        <frame src="adminPage/left.jsp" name="leftmenu" id="mainFrame" title="mainFrame">
        <frame src="adminPage/main.jsp" name="main" scrolling="yes" noresize="noresize" id="rightFrame" title="rightFrame"></frameset></frameset>
<noframes></noframes>
</html>