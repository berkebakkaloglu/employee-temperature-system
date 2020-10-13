<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>

<title>List Employees</title>

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Employee Management</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<input type="button" value="Add Employee" 
					onclick="window.location.href='addEmployee'; return false;"
					class="add-button"
			/>

			<table>
				<tr>
					<th>Employee ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>

				<c:forEach var="employee" items="${employees}">

					<c:url var="updateLink" value="/employee/updateEmployee">
						<c:param name="employeeId" value="${employee.employeeId}" />
					</c:url>
					
					<c:url var="deleteLink" value="/employee/deleteEmployee">
						<c:param name="employeeId" value="${employee.employeeId}"/>
					</c:url>

					<tr>
						<td>${employee.employeeId}</td>
						<td>${employee.name}</td>
						<td>${employee.surname}</td>
						<td>${employee.mailAddress}</td>
						<td>
							<a href="${updateLink}">Update</a> | <a href="${deleteLink}" onclick="return confirm('Are you sure about that?')">Delete</a>
						</td>
					</tr>

				</c:forEach>

			</table>

		</div>

	</div>

</body>

</html>