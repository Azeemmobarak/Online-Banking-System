<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Bank Staff Login</title>
</head>
<body>
	<h2>Bank Staff Login</h2>

	<!-- Login Form -->
	<form action="bankStaffLogin" method="get">
		<label for="email">Email:</label> <input type="email" name="email"
			required> <br> <br> <label for="password">Password:</label>
		<input type="password" name="password" required> <br> <br>
		<button type="submit">Login</button>
	</form>

	<!-- Registration Link -->
	<p><a href="registerBankStaff">Click here to go back to </a>.
	</p>
</body>
</html>
