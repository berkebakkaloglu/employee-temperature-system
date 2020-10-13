<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>

<title>List Temperature Data</title>

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Temperature Data Management</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<input type="button" value="Add Temperature Data"
				onclick="window.location.href='addTemperatureData'; return false;"
				class="add-button" />

			<form name="sendTemperatureMail" action="mail/send" method="POST">

				<label>Maximum Temperature: </label> 
				<input type="text" name="maxTemperature" /> 
				
				<label>Date: </label> 
				<input type="text" name="date" /> 
				
				<input type="submit" value="Send Mails" class="save" />

			</form>

			<table>
				<tr>
					<th>Employee ID</th>
					<th>Date</th>
					<th>Temperature (°C)</th>
				</tr>

				<c:forEach var="temperatureData" items="${allTemperatureData}">

					<c:url var="updateLink"
						value="/temperatureData/updateTemperatureData">
						<c:param name="employeeId" value="${temperatureData.employeeId}" />
						<c:param name="date" value="${temperatureData.date}" />
					</c:url>

					<c:url var="deleteLink"
						value="/temperatureData/deleteTemperatureData">
						<c:param name="employeeId" value="${temperatureData.employeeId}" />
						<c:param name="date" value="${temperatureData.date}" />
					</c:url>

					<tr>
						<td>${temperatureData.employeeId}</td>
						<td>${temperatureData.date}</td>
						<td>${temperatureData.temperatureInCelsius}</td>
						<td><a href="${updateLink}">Update</a> | <a
							href="${deleteLink}"
							onclick="return confirm('Are you sure about that?')">Delete</a></td>
					</tr>

				</c:forEach>

			</table>

		</div>

	</div>

</body>

</html>