<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Online Banking System - Login</title>
    <style>
        /* Reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* Body and Container Styling */
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(135deg, #1abc9c, #3498db);
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            color: #333;
        }

        .login-container {
            background: #ffffff;
            width: 400px;
            padding: 2rem;
            border-radius: 12px;
            box-shadow: 0 12px 24px rgba(0, 0, 0, 0.15);
            text-align: center;
            animation: fadeIn 0.8s ease;
        }

        @keyframes fadeIn {
            from { opacity: 0; transform: scale(0.9); }
            to { opacity: 1; transform: scale(1); }
        }

        h2 {
            color: #333;
            font-weight: bold;
            font-size: 1.8rem;
            margin-bottom: 1rem;
        }

        /* Input and Select Styling */
        label {
            display: block;
            font-size: 0.9rem;
            color: #333;
            margin-bottom: 0.5rem;
            text-align: left;
        }

        select, input[type="email"], input[type="password"] {
            width: 100%;
            padding: 12px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            background: #f8f9fa;
            font-size: 0.9rem;
            color: #333;
            transition: all 0.3s;
        }

        select:focus, input[type="email"]:focus, input[type="password"]:focus {
            border-color: #3498db;
            box-shadow: 0 4px 10px rgba(52, 152, 219, 0.2);
            outline: none;
        }

        /* Submit Button */
        input[type="submit"] {
            width: 100%;
            padding: 12px;
            font-size: 1rem;
            font-weight: bold;
            color: #fff;
            background: linear-gradient(135deg, #3498db, #2980b9);
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: all 0.3s;
        }

        input[type="submit"]:hover {
            background: linear-gradient(135deg, #2980b9, #1c638d);
        }

        input[type="submit"]:active {
            transform: scale(0.98);
        }

        /* Registration Buttons */
        .registration-buttons {
            display: flex;
            flex-direction: column;
            gap: 15px;
            margin-top: 20px;
        }

        .register-link {
            display: inline-block;
            margin-top: 15px;
            color: #3498db;
            text-decoration: none;
        }

        .register-link:hover {
            color: #2980b9;
        }

        /* Icon Styling */
        .icon {
            font-size: 2.5rem;
            color: #3498db;
            margin-bottom: 1rem;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <div class="icon">🏦</div>
        <h2>Login to Online Banking</h2>
        
        <form action="login" method="get">
            <label for="userType">User Type:</label>
            <select name="userType" required>
                <option value="Customer">Customer</option>
                <option value="BankStaff">Bank Staff</option>
                <option value="Admin">Admin</option>
            </select>
            
            <label for="email">Email:</label>
            <input type="email" name="email" placeholder="Enter your email" required>
            
            <label for="password">Password:</label>
            <input type="password" name="password" placeholder="Enter your password" required>
            
            <input type="submit" value="Login">
        </form>
        
         <a href="registrationSelection.jsp" class="register-link">Don't have an account? Register here</a>
    </div>
</body>
</html>
