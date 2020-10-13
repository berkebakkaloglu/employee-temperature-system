<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
<title>Save Employee</title>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Employee Management</h2>
		</div>
	</div>

	<div id="container">

		<h3>Save Employee</h3>

		<form:form action="saveEmployee" modelAttribute="employee"
			method="POST">

			<table>
				<tbody>

					<tr>

						<td><label>Employee ID: </label></td>
						<td><form:input path="employeeId" /></td>

					</tr>
					
					<tr>

						<td><label>First Name: </label></td>
						<td><form:input path="name" /></td>

					</tr>

					<tr>

						<td><label>Last Name: </label></td>
						<td><form:input path="surname" /></td>

					</tr>

					<tr>

						<td><label>Email: </label></td>
						<td><form:input path="mailAddress" /></td>

					</tr>

					<tr>

						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>

					</tr>

				</tbody>
			</table>

		</form:form>

		<div style="clear: both"></div>

		<p>
			<a href="${pageContext.request.contextPath}/employee/list">Back
				to List</a>
		</p>

	</div>

</body>

</html>