<%--
  Created by IntelliJ IDEA.
  User: 李嘉
  Date: 2018/8/22
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工信息</title>
</head>
<br>
    <table border="1">
        <tr>
            <td>id</td>
            <td>姓名</td>
            <td>邮箱</td>
            <td>性别</td>
        </tr>
        <c:forEach items="${allEmps}" var="emp">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.lastName}</td>
                <td>${emp.email}</td>
                <td>${emp.gender}</td>
            </tr>
        </c:forEach>
    </table>
    总共有${pageInfo.pages}页，当前是${pageInfo.pageNum}页</br>
    <c:if test="${pageInfo.hasPreviousPage == true}">
         <a href="${pageContext.request.contextPath}/emps?pn=1">首页</a>
         <a href="${pageContext.request.contextPath}/emps?pn=${pageInfo.pageNum-1}">上一页</a>
    </c:if>
    <c:forEach  items="${pageInfo.navigatepageNums}" var="index">
        <a href="${pageContext.request.contextPath}/emps?pn=${index}"
        <c:if test="${index == pageInfo.pageNum}">
           style="color:darkgreen;"
        </c:if>
        >${index}</a>
    </c:forEach>

    <c:if test="${pageInfo.hasNextPage == true}">
        <a href="${pageContext.request.contextPath}/emps?pn=${pageInfo.pageNum+1}">下一页</a>
        <a href="${pageContext.request.contextPath}/emps?pn=${pageInfo.pages}">尾页</a>
    </c:if>
</body>
</html>
