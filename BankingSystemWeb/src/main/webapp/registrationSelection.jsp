<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <style>
        /* Styling for consistency */
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #1abc9c, #3498db);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            color: #333;
        }

        .container {
            background: #fff;
            padding: 20px;
            border-radius: 12px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            text-align: center;
            width: 400px;
        }

        h1 {
            color: #3498db;
            margin-bottom: 20px;
        }

        label {
            font-size: 1rem;
            color: #2c3e50;
        }

        select {
            width: 100%;
            padding: 12px;
            margin: 15px 0;
            font-size: 1rem;
            border: 1px solid #ddd;
            border-radius: 8px;
            background-color: #f9f9f9;
            transition: border-color 0.3s, box-shadow 0.3s;
        }

        select:focus {
            border-color: #3498db;
            box-shadow: 0 4px 8px rgba(52, 152, 219, 0.2);
            outline: none;
        }

        button {
            width: 100%;
            padding: 12px;
            font-size: 1rem;
            font-weight: bold;
            color: #fff;
            background: #3498db;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: background 0.3s, transform 0.2s;
        }

        button:hover {
            background: #2980b9;
        }

        button:active {
            transform: scale(0.98);
        }

        .back-link {
            display: block;
            margin-top: 15px;
            color: #3498db;
            text-decoration: none;
            font-weight: bold;
            transition: color 0.3s;
        }

        .back-link:hover {
            color: #2980b9;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Select User Type to Register</h1>
        <form id="registrationForm">
            <label for="userType">User Type:</label>
            <select id="userType" required>
                <option value="">-- Select User Type --</option>
                <option value="register">Customer</option>
                <option value="registerBankStaff">Bank Staff</option>
                <option value="registerAdmin">Admin</option>
            </select>
            <button type="button" onclick="redirectToRegistration()">Proceed</button>
        </form>
        <a href="index.jsp" class="back-link">Back to Login</a>
    </div>

    <script>
        function redirectToRegistration() {
            const userType = document.getElementById("userType").value;
            if (userType) {
                // Redirect to the selected registration page
                window.location.href = userType;
            } else {
                alert("Please select a user type to proceed.");
            }
        }
    </script>
</body>
</html>
