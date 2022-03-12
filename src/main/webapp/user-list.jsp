<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head><title>Management App</title></head>
 <body>
 <header>
 <nav class=navbar navbar-expand-md navbar-dar" style=background-color: tomato">
 <div>
 <a href="" class="navbar-brand">Manager App</a>
 </div>
 <ul class=navbar-nav>
 <li><a href="<%=request.getContextPath()%>list" class=nav-link">Employees</a></li>"
 </ul>
 </nav>
 </header>
 <br>

 <div class="row">

 <div class="container">
 <h3 class="text-center">List of Employees</h3>
 <br>
 <div class="container text-left">

 <a href="<%=request.getContextPath()%>/new" class="bttn-group">Add New Employee</a>
 </div>
 <br>
 <table class="table border">
 <thead>
    <tr>
        <th>ID</th>
 <th>Name</th>
 <th>Title</th>
 <th>Salary</th>
 <th>Actions</th>
 </tr>
 </thead>
                <tbody>
                for (Todo todo: todos) {
                <c:forEach var="employee" items="${listEmployee}">

                <tr>
                <td><c:out value="${employee.id}" /></td>
                <td><c:out value="${employee.name}" /></td>
                <td><c:out value="${employee.title}" /></td>
                <td><c:out value="${employee.salary}" /></td>
                <td><a href="edit?id=<c:out value='${employee.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;<a href="delete?=<c:out value='${employee.id}' />">Delete</a></td>
                </tr>
                </c:forEach>
                }
                </tbody>
                </table>
                </div>
                </body>
                </html>

