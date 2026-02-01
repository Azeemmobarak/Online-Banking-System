<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create New Bank Staff Account</title>
    <style>
        /* Basic Reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* Body Styling */
        body {
            font-family: 'Arial', sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            background: linear-gradient(135deg, #1abc9c, #3498db);
            color: #333;
        }

        /* Container Styling */
        .container {
            background: #fff;
            width: 90%;
            max-width: 400px;
            padding: 20px;
            border-radius: 12px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            text-align: center;
            animation: fadeIn 1s ease;
        }

        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(-20px); }
            to { opacity: 1; transform: translateY(0); }
        }

        h1 {
            color: #3498db;
            margin-bottom: 20px;
        }

        label {
            display: block;
            font-size: 0.9rem;
            color: #2c3e50;
            margin-top: 15px;
            text-align: left;
        }

        input[type="text"], input[type="email"], input[type="password"] {
            width: 100%;
            padding: 12px;
            margin-top: 5px;
            border: 1px solid #ddd;
            border-radius: 8px;
            font-size: 0.9rem;
            background-color: #f9f9f9;
            transition: border 0.3s, box-shadow 0.3s;
        }

        input[type="text"]:focus, input[type="email"]:focus, input[type="password"]:focus {
            border: 1px solid #3498db;
            box-shadow: 0 4px 8px rgba(52, 152, 219, 0.2);
            outline: none;
        }

        /* Submit Button */
        button[type="submit"] {
            width: 100%;
            padding: 12px;
            font-size: 1rem;
            font-weight: bold;
            color: #fff;
            background: #3498db;
            border: none;
            border-radius: 8px;
            margin-top: 20px;
            cursor: pointer;
            transition: background 0.3s, transform 0.2s;
        }

        button[type="submit"]:hover {
            background: #2980b9;
        }

        button[type="submit"]:active {
            transform: scale(0.98);
        }

        /* Back to Manage Bank Staff Button */
        .back-link {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 15px;
            color: #fff;
            background-color: #e74c3c;
            border-radius: 8px;
            text-decoration: none;
            font-weight: bold;
            transition: background-color 0.3s;
        }

        .back-link:hover {
            background-color: #c0392b;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Create New Bank Staff Account</h1>
        
        <form action="admin" method="get">
            <input type="hidden" name="action" value="processCreateBankStaff">

            <label for="name">Name:</label>
            <input type="text" name="name" required>

            <label for="email">Email:</label>
            <input type="email" name="email" required>

            <label for="password">Password:</label>
            <input type="password" name="password" required>

            <button type="submit">Create Account</button>
        </form>

        <a href="admin?action=manageBankStaff" class="back-link">Back to Manage Bank Staff</a>
    </div>
</body>
</html>
