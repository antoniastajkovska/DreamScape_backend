# DreamScape Backend

This is the backend part of the DreamScape project. It provides APIs / services to support the DreamScape Flutter app: handling data storage, authentication, bookings, and interactions with the PostgreSQL database.

---

## 🔍 Description

The backend handles:

- User account management (registration / login / authentication)  
- CRUD operations for bookings: flights, hotels, taxis  
- Pulling and storing booking data in PostgreSQL  
- Generating receipts or summaries for bookings  
- Any business logic needed for booking flows (ticket type, optional hotel or taxi, etc.)

---

## ⚙️ Tech Stack

- **Language / Framework:** (e.g. Node.js + Express / Django / Flask / etc.) – *replace with your stack*  
- **Database:** PostgreSQL  
- **Authentication:** JWT / OAuth / sessions (specify your approach)  
- **API format:** REST (or GraphQL, etc.)  
- **Other dependencies / tools:** (e.g. ORM like Sequelize / TypeORM / SQLAlchemy; middleware; etc.)

---

## 🛠️ Endpoints / API Overview

Here are some example endpoints you may have (modify as needed):

| Feature | Endpoint | Method | Description |
|---|---|---|---|
| User Registration | `/api/auth/register` | POST | Creates a new user account |
| User Login | `/api/auth/login` | POST | Authenticates user & returns token/session |
| Get Booking Options | `/api/flights` / `/api/hotels` / `/api/taxis` | GET | Fetches available flights / hotels / taxi rides |
| Create Booking | `/api/bookings` | POST | Creates a booking (flight + optional hotel + optional taxi) |
| Get Booking by User | `/api/bookings/:userId` | GET | Lists bookings made by a specific user |
| Generate Receipt | `/api/bookings/:bookingId/receipt` | GET | Returns receipt or summary for a booking |

---

## 🧱 Booking Workflow Logic

Here is the expected flow of how booking works, matching what’s implemented in the frontend:

1. User requests flights / hotel / taxi availability.  
2. User selects:
   - Flight (with ticket type(s): senior, adult, child)  
   - Optional hotel (can skip)  
   - Optional taxi (can skip)  
3. On submit, backend validates data (e.g., user is authenticated) and persists booking into the database.  
4. Backend generates a receipt / summary record.  
5. Retrieval of booking and receipt by the frontend for display to user.

---

## 📦 Project Structure

Here’s how the project organizes the backend files:

DreamScape_backend/
├── src/
│ ├── controllers/ # Request handlers for different routes
│ ├── models/ # Database models / ORM definitions
│ ├── routes/ # Route definitions (auth, bookings, etc.)
│ ├── middleware/ # Auth, logging, validation, etc.
│ ├── services/ # Business logic, receipt generation, etc.
│ └── app.js (or main) # Entry point for server
├── config/
│ ├── db.js # Database connection setup
│ ├── auth.js # Token secret, expired time, etc.
│ └── env files # Environment variables (e.g. .env)
├── migrations/ # Database migration scripts
├── tests/ # Unit / integration tests
├── package.json # Dependencies & scripts (if Node.js)
└── README.md


