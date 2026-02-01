<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer List</title>
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
            width: 90%;
            max-width: 800px;
            background-color: #fff;
            padding: 20px;
            border-radius: 12px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            text-align: center;
            position: relative;
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

        /* Button Styling */
        .action-button {
            display: inline-block;
            margin: 5px;
            padding: 8px 16px;
            color: #fff;
            background-color: #3498db;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            text-decoration: none;
            font-weight: bold;
            transition: background-color 0.3s, transform 0.2s;
        }

        .action-button:hover {
            background-color: #2980b9;
        }

        .action-button:active {
            transform: scale(0.98);
        }

        /* Logout Button */
        .logout-button {
            position: absolute;
            top: 15px;
            right: 15px;
            background: #e74c3c;
            color: #fff;
            padding: 8px 12px;
            font-weight: bold;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: background 0.3s, transform 0.2s;
        }

        .logout-button:hover {
            background: #c0392b;
        }

        .logout-button:active {
            transform: scale(0.98);
        }
    </style>
</head>
<body>
    <div class="container">
        <button class="logout-button" onclick="location.href='logout'">Logout</button>
        <h1>Customer List</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="customer" items="${customers}">
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.name}</td>
                    <td>${customer.email}</td>
                    <td>
                        <a href="bankStaff?action=viewAccounts&customerId=${customer.id}" class="action-button">View Accounts</a>
                        <a href="bankStaff?action=viewTransactions&customerId=${customer.id}" class="action-button">View Transactions</a>
                        <a href="bankStaff?action=viewPendingRequests&customerId=${customer.id}" class="action-button">Pending Transactions</a>
                        <a href="bankStaff?action=generateReport&customerId=${customer.id}" class="action-button">Generate Report</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
