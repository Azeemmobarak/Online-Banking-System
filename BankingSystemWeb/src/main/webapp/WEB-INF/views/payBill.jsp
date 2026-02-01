<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pay Bills</title>
    <style>
        /* Basic Reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* Body Styling with Dashboard Background */
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
            width: 80%;
            max-width: 600px;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
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

        h3 {
            margin-top: 20px;
            color: #2c3e50;
        }

        /* Form Styling */
        form {
            margin-top: 15px;
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        label {
            font-weight: bold;
            color: #2c3e50;
            text-align: left;
        }

        /* Input and Select Styling */
        select, input[type="number"] {
            width: 100%;
            padding: 12px;
            border: 1px solid #ddd;
            border-radius: 8px;
            font-size: 0.9rem;
            color: #333;
            background-color: #f9f9f9;
            transition: border 0.3s, box-shadow 0.3s;
        }

        select:focus, input[type="number"]:focus {
            border: 1px solid #3498db;
            box-shadow: 0 4px 8px rgba(52, 152, 219, 0.2);
            outline: none;
        }

        /* Submit Button */
        button {
            padding: 12px;
            font-size: 1rem;
            font-weight: bold;
            color: #fff;
            background: linear-gradient(135deg, #3498db, #2980b9);
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: background 0.3s, transform 0.2s;
        }

        button:hover {
            background: linear-gradient(135deg, #2980b9, #1c638d);
        }

        button:active {
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

        /* Error and Success Messages */
        .error-message {
            color: red;
            font-weight: bold;
            margin-bottom: 10px;
        }

        .success-message {
            color: green;
            font-weight: bold;
            margin-bottom: 10px;
        }

        /* Checkbox Label Styling */
        .bill-option {
            display: block;
            margin-top: 10px;
            font-size: 0.9rem;
            color: #333;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Pay Bills</h1>

        <c:if test="${not empty errorMessage}">
            <p class="error-message">${errorMessage}</p>
        </c:if>
        <c:if test="${not empty successMessage}">
            <p class="success-message">${successMessage}</p>
        </c:if>

        <form action="customer" method="get">
            <input type="hidden" name="action" value="processBill">

            <label>From Account:</label>
            <select name="accountId" required>
                <c:forEach var="account" items="${accounts}">
                    <option value="${account.id}">${account.accountNumber} - Balance: ${account.balance}</option>
                </c:forEach>
            </select>

            <h3>Select Bills</h3>
            <label class="bill-option">
                <input type="checkbox" name="billType" value="electricity" data-price="300"> Electricity Bill - 300
            </label>
            <label class="bill-option">
                <input type="checkbox" name="billType" value="housing" data-price="700"> Housing Rent - 700
            </label>
            <label class="bill-option">
                <input type="checkbox" name="billType" value="wifi" data-price="50"> WiFi Recharge - 50
            </label>

            <button type="submit">Pay Bill</button>
        </form>

        <a href="customer?action=dashboard" class="back-button">Back to Dashboard</a>
    </div>
</body>
</html>
