<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
<title>Save Temperature Data</title>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Temperature Data Management</h2>
		</div>
	</div>

	<div id="container">

		<h3>Save Temperature Data</h3>

		<form:form action="saveTemperatureData"
			modelAttribute="temperatureData" method="POST">

			<table>
				<tbody>

					<tr>

						<td><label>Employee ID: </label></td>
						<td><form:input path="employeeId" /></td>

					</tr>
					
					<tr>

						<td><label>Date: </label></td>
						<td><form:input path="date" /></td>

					</tr>

					<tr>

						<td><label>Temperature (°C): </label></td>
						<td><form:input path="temperatureInCelsius" /></td>

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
			<a href="${pageContext.request.contextPath}/temperatureData/list">Back
				to List</a>
		</p>

	</div>

</body>

</html>