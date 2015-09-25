<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.2.js"></script>
<script type="text/javascript">
	
	$(function(){
		$(":input[name=lastName]").change(function(){
			var val = $(this).val();
			val = $.trim(val);
			var $this = $(this);
			
			if(val != ""){
				//把当前节点后面的所有 font 兄弟节点删除
				$this.nextAll("font").remove();
				var url = "emp!validateLastName";
				var args = {"ygName":val, "time":new Date()};
				
				$.post(url, args, function(data){
					//表示可用
					if (data == "1") {
						$this.after("<font color='green'>LastName可用!</font>");
					} else if (data == "0") {
						// 不可用
						$this.after("<font color='red'>LastName不可用!</font>");						
					} else {
						// 服务器错误
						alert("服务器错误!");
					}
				});
			} else {
				alert("lastName 不能为空");
				$(this).val("");
				$this.focus();
			}
		});
	})
	
</script>

</head>
<body>
	
		<center>
	<br/><br/>
	<h3>Employee Add Page</h3>
	
	<s:form action="emp!insert.action" method="post" id="myForm">
	<table>
		<tr>
			<td>LastName</td>
			<td><s:textfield type="text" name="lastName" /></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><s:textfield type="text" name="email" /></td>
		</tr>
		<tr>
			<td>Birth</td>
			<td><s:textfield type="text" name="birth" /></td>
		</tr>
		<tr>
			<td>Department</td>
			<td>
				<s:select list="#departmentList" name="did"
					listKey="id" listValue="departmentName" headerKey="" headerValue="-请选择部门-"/>
			</td>
		</tr>
	</table>
	<br/>
	<s:submit type="submit" value="添加"/>
	</s:form>
	</center>
	
</body>
</html>