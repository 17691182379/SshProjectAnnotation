<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.2.js"></script>
<style type="text/css">
	table {text-align: center; width: 800px;}
	tr {height: 35px;}
</style>
<script type="text/javascript">
	
	$(function(){
		//1. 点击 delete 时, 弹出 确定是要删除 xx 的信息吗 ? 若确定, 执行删除, 若不确定, 则取消
		$(".delete").click(function(){
			var lastName = $(this).next(":hidden").val();
			var flag = confirm("确定要删除 " + lastName + " 的信息吗？")
			if (flag) {
				var $tr = $(this).parent().parent();
				//删除, 使用 ajax 的方式
				var url = this.href;
				var args = {"time":new Date()};
				$.post(url, args, function(data){
					//若 data 的返回值为 1, 则提示 删除成功, 且把当前行删除
					if(data == "1"){
						alert("删除成功!");
						$tr.remove();
					}else{
						//若 data 的返回值不是 1, 提示删除失败. 
						alert("删除失败!");
					}
				});	
			}
			//取消超链接的默认行为
			return false;
		});
	})
	
</script>

</head>
<body>
	
	<center>
	<br/><br/>
	
	<h3>Employee List Page</h3>
	
	<table border="1" cellspacing="0">
		<tr>
			<td>ID</td>
			<td>LASTNAME</td>
			<td>EMAIL</td>
			<td>BIRTH</td>
			<td>CREATETIME</td>
			<td>DEPT</td>
			<td>DELETE</td>
			<td>EDIT</td>
		</tr>
		<s:if test="#employees==null || #employees.size()==0">
			<tr>
				<td colspan="8">没有任何员工信息</td>
			</tr>
		</s:if>
		<s:else>
			<s:iterator value="#employees">
			<tr>
				<td><s:property value="id"/></td>
				<td><s:property value="lastName"/></td>
				<td><s:property value="email"/></td>
				<td><s:date name="birth" format="yyyy-MM-dd"/></td>
				<td><s:date name="createTime" format="yyyy-MM-dd hh:mm:ss"/></td>
				<td><s:property value="department.departmentName"/></td>
				<td>
					<s:a action="emp!delete?eid=%{id}" class="delete">Delete</s:a>
					<input type="hidden" value="${lastName}"/>
				</td>
				<td><s:a action="emp!updateUI?id=%{id}">Edit</s:a></td>
			</tr>
			</s:iterator>
		</s:else>
	</table>
	
	</center>
	
</body>
</html>