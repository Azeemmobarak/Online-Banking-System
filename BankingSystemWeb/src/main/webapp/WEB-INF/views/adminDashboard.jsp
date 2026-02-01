<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
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
            background: linear-gradient(135deg, #1abc9c, #3498db); /* Consistent with index.jsp */
            color: #333;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        /* Dashboard Container */
        .dashboard-container {
            background: #fff;
            width: 90%;
            max-width: 500px;
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
        }

        h2 {
            color: #2c3e50;
            font-size: 1.3rem;
            margin-bottom: 15px;
        }

        /* Action Buttons Styling */
        .action-buttons {
            display: flex;
            flex-direction: column;
            gap: 15px;
            margin-top: 20px;
        }

        .action-button {
            display: inline-block;
            padding: 12px;
            width: 100%;
            text-align: center;
            font-size: 1rem;
            font-weight: bold;
            color: #fff;
            background: #3498db;
            border: none;
            border-radius: 8px;
            text-decoration: none;
            transition: background 0.3s, transform 0.2s;
            cursor: pointer;
        }

        .action-button:hover {
            background: #2980b9;
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
    <div class="dashboard-container">
        <button class="logout-button" onclick="location.href='logout'">Logout</button>
        <h1>Welcome, Admin</h1>
        <h2>Admin Actions</h2>
        
        <!-- Action Buttons -->
        <div class="action-buttons">
            <a href="admin?action=manageBankStaff" class="action-button">Manage Bank Staff Accounts</a>
            <a href="admin?action=viewSystemLogs" class="action-button">View System Logs</a>
            <a href="admin?action=performMaintenance" class="action-button">System Maintenance</a>
        </div>
    </div>
</body>
</html>
