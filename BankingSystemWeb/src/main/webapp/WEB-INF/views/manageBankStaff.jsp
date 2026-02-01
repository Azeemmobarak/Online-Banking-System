<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Bank Staff Accounts</title>
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

        /* Container */
        .container {
            width: 90%;
            max-width: 800px;
            padding: 20px;
            background-color: #fff;
            border-radius: 12px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
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
            font-size: 2rem;
        }

        /* Table Styling */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
            background-color: #f9f9f9;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #3498db;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        /* Action Buttons */
        .action-button, .back-button, .create-button {
            display: inline-block;
            margin-top: 10px;
            padding: 10px 20px;
            color: #fff;
            border-radius: 8px;
            text-decoration: none;
            font-weight: bold;
            transition: background-color 0.3s;
            cursor: pointer;
        }

        .action-button {
            background-color: #3498db;
        }

        .action-button:hover {
            background-color: #2980b9;
        }

        /* Create New Bank Staff Button */
        .create-button {
            background-color: #27ae60;
            margin-bottom: 20px;
        }

        .create-button:hover {
            background-color: #219150;
        }

        /* Back Button */
        .back-button {
            background-color: #27ae60;
        }

        .back-button:hover {
            background-color: #219150;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Manage Bank Staff Accounts</h1>
        
        <a href="admin?action=createBankStaff" class="create-button">Create New Bank Staff Account</a>

        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="staff" items="${bankStaffList}">
                <tr>
                    <td>${staff.id}</td>
                    <td>${staff.name}</td>
                    <td>${staff.email}</td>
                    <td>
                        <a href="admin?action=editBankStaff&id=${staff.id}" class="action-button">Edit</a>
                        <a href="admin?action=deleteBankStaff&id=${staff.id}" class="action-button" 
                           onclick="return confirm('Are you sure you want to delete this bank staff member?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <a href="admin?action=adminDashboard" class="back-button">Back to Dashboard</a>
    </div>
</body>
</html>
