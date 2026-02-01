<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pending Requests</title>
</head>
<body>
    <h1>Pending Transactions</h1>
    <table border="1">
        <tr>
            <th>Date</th>
            <th>Amount</th>
            <th>Type</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="transaction" items="${pendingTransactions}">
            <tr>
                <td>${transaction.transactionDate}</td>
                <td>${transaction.amount}</td>
                <td>${transaction.transactionType}</td>
                <td>
                    <a href="bankStaff?action=approveTransaction&transactionId=${transaction.id}">Approve</a> |
                    <a href="bankStaff?action=rejectTransaction&transactionId=${transaction.id}">Reject</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="bankStaff?action=dashboard">Back to Dashboard</a>
</body>
</html>
