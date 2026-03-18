1️⃣ Create Database

Open MySQL and run:

CREATE DATABASE loantracker;

📡 API Endpoints
🔹 1. Register
POST http://localhost:8080/auth/register
Body:
{
  "name": "Saurabh",
  "shopName": "Saurabh Store",
  "mobile": "9876543210",
  "password": "123456",
  "location": "Pune"
}
🔹 2. Login
POST http://localhost:8080/auth/login
Body:
{
  "mobile": "9876543210",
  "password": "123456"
}
