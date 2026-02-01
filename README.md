📌 Overview

The Online Banking System is a secure, scalable, multi-tier web application developed as a Proof of Concept (POC). It replicates essential banking functionalities such as account management, fund transfers, bill payments, and transaction tracking.

The system is designed with a strong emphasis on security, modularity, and maintainability, leveraging Java EE standards and enterprise design principles. Multiple user roles ensure controlled access and safe execution of banking operations.

🏗️ Application Architecture

The application follows a layered, multi-tier architecture, ensuring clear separation of responsibilities:

🔹 Presentation Layer

JSP & JSTL for dynamic content rendering

HTML & CSS for responsive and user-friendly UI

🔹 Controller Layer

Servlets to handle HTTP requests and responses

Centralized request routing and validation

🔹 Business Logic Layer

Enterprise JavaBeans (EJBs) for core business operations

Transaction management and business rules enforcement

🔹 Persistence Layer

Java Persistence API (JPA) for ORM

Clean abstraction between database and application logic

🔹 Database Layer

Oracle RDBMS for reliable and consistent data storage

👥 User Roles & Role-Based Access Control (RBAC)

The system enforces RBAC to ensure that each user can only access authorized features.

👤 Customer

Secure authentication and session handling

View account balances and details

Perform fund transfers

Pay bills and utilities

View transaction history

🧑‍💼 Bank Staff

Manage and verify customer accounts

Monitor transactions and system activity

Assist customers with banking operations

🛡️ Administrator

Manage users, staff, and system roles

Oversee application operations

Access system logs and audit trails

⚙️ Core Features

Secure authentication and authorization mechanisms

Role-based access control (RBAC)

Session management and timeout handling

Encrypted password storage

Fund transfer processing

Bill payment workflow

Transaction history and reporting

Centralized logging for auditing and troubleshooting

Responsive UI with structured layouts (tables, cards, forms)

🗄️ Database Design

The application uses a relational Oracle database with well-defined entities:

Customer – Stores customer profile and login details

Account – Manages account balances and types

Transaction – Records all debit and credit operations

BillPayment – Tracks bill payment details

BankStaff – Maintains staff and administrative users

JPA handles entity mapping, relationships, and data persistence efficiently.

🔐 Security Implementation

Authentication using secure credentials

Authorization via role-based access

Password encryption for data protection

Session validation to prevent unauthorized access

Logging for traceability and auditing

🛠️ Technologies & Tools
🔧 Backend

Java

Servlets

Enterprise JavaBeans (EJB)

Java Persistence API (JPA)

🎨 Frontend

JSP

JSTL

HTML

CSS

🗄️ Database

Oracle RDBMS

🚀 Server & Deployment

Apache Tomcat / Java EE Application Server
