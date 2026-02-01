<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Generate Report</title>
    <style>
        /* Basic Reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* Body Styling with Background */
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
            max-width: 600px;
            background-color: #fff;
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
            font-size: 2rem;
        }

        /* Report Text Styling */
        pre {
            background-color: #f9f9f9;
            padding: 15px;
            border-radius: 8px;
            text-align: left;
            font-family: 'Courier New', monospace;
            color: #333;
            overflow-x: auto;
            max-width: 100%;
            white-space: pre-wrap;
            word-wrap: break-word;
            margin-top: 15px;
        }

        /* Back Button Styling */
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
        <h1>Customer Report</h1>
        <pre>${report}</pre>
        <a href="bankStaff?action=dashboard" class="back-button">Back to Dashboard</a>
    </div>
</body>
</html>
