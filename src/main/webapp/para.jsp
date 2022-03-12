<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head><title>Management App</title></head>

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


<div class="container col-md-5">
<div class="card">
<dic class="card-body">
    <c:if test="${employee != null}">
        <form action="update" method="post">
    </c:if>
    <c:if test="${employee == null}">
            <form action="insert" method="post">
        </c:if>

        <caption>
        <h2>
        <c:if test="${employee != null}">
                Edit Employee
            </c:if>
            <c:if test="${employee == null}">
                   Add New Employee
                </c:if>
                </h2>
                </caption>

                <c:if test="${employee != null}">
                    <input type="hidden" name="id" value="<c:out value='${employee.id}' />" />
                    </c:if>
                <fieldset class="form-group">
                    <label> Employee Name</label> <input type="text" value="c:out value='${employee.name}' />" class="form-control"
                    name="name" required="required">
                </fieldset>

                <fieldset class="form-group">
                     <label> Employee Title</label> <input type="text" value="c:out value='${employee.title}' />" class="form-control"
                    name="title" required="required">
                </fieldset>

                <fieldset class="form-group">
                    <label> Employee Salary</label> <input type="text" value="c:out value='${employee.salary}' />" class="form-control"
                    name="salary" required="required">
                </fieldset>


                <button type="submit" class="bttn-group">Save</button>
   </form>
  </div>
 </div>
</div>
</body>
</html>
