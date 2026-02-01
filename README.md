Overview

The Online Banking System is a secure, multi-tier web application developed as a proof of concept (POC) to simulate real-world banking operations. The system enables customers to manage accounts, perform fund transfers, pay bills, and view transaction history, while providing separate roles for bank staff and administrators to manage and monitor operations securely.

The application is built using Java EE technologies and follows industry best practices for security, scalability, and maintainability.

🏗️ Architecture

The system follows a multi-tier architecture:

Presentation Layer: JSP, JSTL, HTML, CSS

Controller Layer: Servlets

Business Logic Layer: EJBs

Persistence Layer: JPA

Database: Oracle RDBMS

👥 User Roles

The application supports role-based access control (RBAC) with three distinct user roles:

🔹 Customer

View account details

Transfer funds

Pay bills

View transaction history

Secure login & session management

🔹 Bank Staff

Manage customer accounts

Monitor transactions

Assist with operational tasks

🔹 Admin

Manage users and staff

Oversee system operations

Access logs and system data

⚙️ Key Features

Secure authentication and authorization

Role-based access control

Session management

Password encryption

Fund transfers between accounts

Bill payment processing

Transaction history tracking

Logging for auditing and monitoring

Responsive UI using JSP, JSTL, tables, and cards

🗄️ Database Design

The system uses a relational database (Oracle) with the following core entities:

Customer

Account

Transaction

BillPayment

BankStaff

JPA is used for object-relational mapping and persistence.

🛠️ Technologies Used

Backend: Java, Servlets, EJB, JPA

Frontend: JSP, JSTL, HTML, CSS

Database: Oracle

Server: Apache Tomcat / Application Server

Security: Session management, encryption, role-based authorization
