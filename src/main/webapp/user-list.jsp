

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


                    <c:forEach var="employee" items="${}">

                    <tr>
                    <td><c:out value="${employee.emp_id}"/></td>
                    <td>${employee.name}</td>
                    <td>${employee.title}</td>
                    <td>${employee.salary}</td>
                    <td><a href="edit?id=<c:out value='${employee.emp_id}' />">Edit</a> &nbsp;&nbsp;&nbsp;<a href="delete?=<c:out value='${employee.id}' />">Delete</a></td>
                    </tr>

                    </c:forEach>

                    </tbody>
                    </table>
                    </div>
                    </div>



