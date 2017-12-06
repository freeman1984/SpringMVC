<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<body>
	<h1>${headerMessage}</h1>
	<h3>STUDENT ADMISSION FORM FOR ENGINEERING COURSES</h3>
	<form:errors path="student1.*" />

	<form action="/FirstSpringMVCProject/submitAdmissionForm.html"
		method="post">
		<table>
			<tr>
				<td><spring:message code="label.studentName" /></td>
				<td><input type="text" name="studentName" /></td>
			</tr>
			<tr>
				<td>Student's Hobby :</td>
				<td><input type="text" name="studentHobby" /></td>
			</tr>


			<tr>
				<td>Student's Mobile :</td>
				<td><input type="text" name="studentMobile" /></td>
			</tr>

			<tr>
				<td>Student's DOB :</td>
				<td><input type="text" name="studentDOB" /></td>
			</tr>

			<tr>
				<td>Student's skill set :</td>
				<td><select name="studentSkills" multiple>
						<option value="Java Core">Java Core</option>
						<option value="spring Core">spring Core</option>
						<option value="spring MVC">spring mvc</option>
				</select></td>
			</tr>

		</table>
		<table>
			<tr>
				<td>Student Address :</td>
			</tr>

			<tr>
				<td>country: <input type="text" name="studentAddress.country"></td>
				<td>city: <input type="text" name="studentAddress.city"></td>
				<td>street: <input type="text" name="studentAddress.street"></td>
				<td>pincode: <input type="text" name="studentAddress.pincode"></td>
			</tr>
		</table>


		<input type="submit" value="Submit this form by clicking here" />
	</form>

</body>
</html>

