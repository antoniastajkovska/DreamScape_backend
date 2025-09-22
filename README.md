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

- **Language / Framework:** ( Java / Spring Boot)  
- **Database:** PostgreSQL  
- **Authentication:** JWT / OAuth / sessions  
- **API format:** REST   
  

---

## 🛠️ Endpoints / API Overview

Here are some endpoints the project has:

| Feature             | Endpoint                          | Method | Description                                         |
|---------------------|-----------------------------------|--------|-----------------------------------------------------|
| User Registration   | `/api/auth/register`              | POST   | Creates a new user account                          |
| User Login          | `/api/auth/login`                 | POST   | Authenticates user & returns token/session          |
| Get Booking Options | `/api/flights` `/api/hotels` `/api/taxis` | GET    | Fetches available flights / hotels / taxi rides     |
| Create Booking      | `/api/bookings`                   | POST   | Creates a booking (flight + optional hotel + taxi)  |
| Get Booking by User | `/api/bookings/:userId`           | GET    | Lists bookings made by a specific user              |
| Generate Receipt    | `/api/bookings/:bookingId/receipt`| GET    | Returns receipt or summary for a booking            |

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

<img width="364" height="521" alt="image" src="https://github.com/user-attachments/assets/c88f4eca-3804-4112-9472-cd171972b6e5" />



