<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>SpringBoot首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
  <body>
    This is JSP page:/WEB-INF/view/list.jsp <br>
    
    <s:if test="${not empty list }">
    	<s:forEach items="${list}" varStatus="sta" var="str">
    		${sta.count}  --------->  ${str} <br/>
    	</s:forEach>
    
    </s:if>
    
    
    <s:if test="${empty msg}">
    	<h5>page,request,session,application四个对象属性中msg都为null空</h5>
    </s:if>
  </body>
</html>
