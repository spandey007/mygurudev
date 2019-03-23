<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Customer Registration form</title>
<style type="text/css">
.error {
	color: red
}
</style>
</head>


<body>

	<i>Fill Out the form. Asterisk (*) means Mandatory:</i>
	<br>
	<form:form action="processForm" modelAttribute="customer">
First Name: <form:input path="firstName" />
		<br>
Last Name:(*) <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error"></form:errors>
		<br>
Free Passes: <form:input path="freePasses" />
		<form:errors path="freePasses" cssClass="error"></form:errors>
		<br>
Course Code: <form:input path="courseCode" />
		<form:errors path="courseCode" cssClass="error"></form:errors>
		<br>
Postal Code: <form:input path="postalCode" />
		<form:errors path="postalCode" cssClass="error"></form:errors>
		<br>
		<input type="submit" value="submit" />
	</form:form>

</body>

</html>