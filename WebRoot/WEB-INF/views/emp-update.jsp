<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	input {font-size: 15px; height: 25px;}
	select {font-size: 15px; height: 25px;}
	table {width: 320px; font-size: 20px; }
</style>

</head>
<body>
	
	<center>
	<br/><br/>
	<h3>Employee Update Page</h3>
	
	<s:form action="emp!update.action" method="post">
	<table>
		<s:iterator value="#employee">
		<s:hidden name="id"/>
		<s:hidden name="#departmentList.id"/>
		<tr>
			<td>
				LastName
			</td>
			<td><s:textfield name="lastName" label="lastName"/></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><s:textfield name="email" label="email"/></td>
		</tr>
		<tr>
			<td>Birth</td>
			<td><s:textfield name="birth" label="birth" /></td>
		</tr>
		<tr>
			<td>Department</td>
			<td>
				<s:select list="#departmentList" name="department.id"
					listKey="id" listValue="departmentName" label="departmentName"/>
			</td>
		</tr>
		</s:iterator>
	</table>
	<br/>
	<s:submit type="submit" value="修改"/>
	</s:form>
	</center>
</body>
</html>