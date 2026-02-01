<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <style>
        /* Reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            background: linear-gradient(135deg, #1abc9c, #3498db);
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        /* Dashboard Container */
        .dashboard-container {
            background: #fff;
            width: 100%;
            max-width: 600px;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        /* Header Section */
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            border-bottom: 1px solid #ddd;
            padding-bottom: 15px;
            margin-bottom: 20px;
        }

        h1 {
            font-size: 1.5rem;
            color: #333;
        }

        /* Logout Button */
        .logout-button {
            background-color: #ff4e50;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 20px;
            font-size: 0.9rem;
            font-weight: bold;
            cursor: pointer;
            transition: all 0.3s;
        }

        .logout-button:hover {
            background-color: #d33f3f;
        }

        /* Action Buttons Section */
        .actions-container {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 15px;
        }

        .action-card {
            background: #f9f9f9;
            padding: 20px;
            border-radius: 12px;
            text-align: center;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
            transition: transform 0.2s;
        }

        .action-card:hover {
            transform: translateY(-5px);
        }

        .action-button {
            background: linear-gradient(135deg, #6a11cb, #2575fc);
            color: #fff;
            border: none;
            padding: 10px 20px;
            font-size: 1rem;
            border-radius: 8px;
            cursor: pointer;
            margin-top: 10px;
            transition: background 0.3s;
        }

        .action-button:hover {
            background: linear-gradient(135deg, #5a0ea1, #1e6bc1);
        }

        /* Card Icon */
        .action-icon {
            font-size: 2rem;
            color: #6a11cb;
            margin-bottom: 5px;
        }

    </style>
</head>
<body>
    <div class="dashboard-container">
        <div class="header">
            <h1>Welcome, ${customer.name}</h1>
            <form action="logout" method="get" style="margin: 0;">
                <button type="submit" class="logout-button">Logout</button>
            </form>
        </div>

        <h2 style="color: #333; margin-bottom: 20px;">Actions</h2>
        <div class="actions-container">
            <div class="action-card">
                <div class="action-icon">📋</div>
                <p>Account Details</p>
                <form action="customer" method="get">
                    <button type="submit" name="action" value="viewAccounts" class="action-button">View Accounts</button>
                </form>
            </div>
            <div class="action-card">
                <div class="action-icon">💸</div>
                <p>Transfer Funds</p>
                <form action="customer" method="get">
                    <button type="submit" name="action" value="transfer" class="action-button">Transfer</button>
                </form>
            </div>
            <div class="action-card">
                <div class="action-icon">💡</div>
                <p>Pay Bills</p>
                <form action="customer" method="get">
                    <button type="submit" name="action" value="payBill" class="action-button">Pay Now</button>
                </form>
            </div>
            <div class="action-card">
                <div class="action-icon">📜</div>
                <p>Transaction History</p>
                <form action="customer" method="get">
                    <button type="submit" name="action" value="viewTransactions" class="action-button">Transactions History</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
