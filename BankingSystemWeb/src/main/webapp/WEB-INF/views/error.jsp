<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
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
            background: linear-gradient(135deg, #e74c3c, #c0392b);
            color: #333;
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
            color: #e74c3c;
            margin-bottom: 20px;
            font-size: 1.8rem;
        }

        p {
            font-size: 1rem;
            color: #333;
            margin: 15px 0;
        }

        .error-message {
            color: #c0392b;
            font-weight: bold;
            font-size: 1.1rem;
            margin-bottom: 15px;
            background: #fdecea;
            padding: 10px;
            border-radius: 8px;
        }

        /* Back Button */
        .back-button {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            color: #fff;
            background-color: #3498db;
            border-radius: 8px;
            text-decoration: none;
            font-weight: bold;
            transition: background-color 0.3s;
        }

        .back-button:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Error</h1>
        <c:if test="${not empty errorMessage}">
            <p class="error-message">${errorMessage}</p>
        </c:if>
        <p>Something went wrong. Please try again later or contact support if the issue persists.</p>
        <a href="index.jsp" class="back-button">Back to Home</a>
    </div>
</body>
</html>
