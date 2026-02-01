<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Bank Staff</title>
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
            background: linear-gradient(135deg, #1abc9c, #3498db);
            color: #333;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        /* Container Styling */
        .container {
            width: 90%;
            max-width: 400px;
            background: #fff;
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
            font-size: 2rem;
            color: #3498db;
            margin-bottom: 20px;
        }

        label {
            display: block;
            font-size: 1rem;
            color: #2c3e50;
            margin: 10px 0 5px;
            text-align: left;
        }

        input[type="text"], input[type="email"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 8px;
            background-color: #f9f9f9;
            font-size: 1rem;
            transition: border 0.3s, box-shadow 0.3s;
        }

        input[type="text"]:focus, input[type="email"]:focus {
            border: 1px solid #3498db;
            box-shadow: 0 4px 8px rgba(52, 152, 219, 0.2);
            outline: none;
        }

        /* Update Button */
        button[type="submit"] {
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

        button[type="submit"]:hover {
            background: #2980b9;
        }

        button[type="submit"]:active {
            transform: scale(0.98);
        }

        /* Back Button */
        .back-button {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            color: #fff;
            background-color: #27ae60;
            border-radius: 8px;
            text-decoration: none;
            font-weight: bold;
            transition: background-color 0.3s;
        }

        .back-button:hover {
            background-color: #219150;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Edit Bank Staff Account</h1>
        <form action="admin" method="post">
            <input type="hidden" name="action" value="updateBankStaff">
            <input type="hidden" name="id" value="${staff.id}">

            <label>Name:</label>
            <input type="text" name="name" value="${staff.name}" required>

            <label>Email:</label>
            <input type="email" name="email" value="${staff.email}" required>

            <button type="submit">Update</button>
        </form>

        <a href="admin?action=manageBankStaff" class="back-button">Back to Manage Bank Staff</a>
    </div>
</body>
</html>
