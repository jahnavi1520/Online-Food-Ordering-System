# Online Food Ordering System - Product Requirements Document

## 1. Introduction

This document outlines the requirements for the Minimum Viable Project (MVP) of an Online Food Ordering System. The primary goal is to develop a functional, console-based application that allows a user to browse restaurants, add food items to a cart, place an order, and view their order history. The focus is on delivering a clean, simple, and working application that meets the core user flow, making it an ideal project for demonstrating fundamental software development skills.

## 2. Core Goal

> A user can **browse food → add to cart → place order → view order history**.

## 3. User Roles (Actors)

The system will have two primary roles:

1.  **Customer**: The end-user who places food orders.
2.  **Restaurant Admin**: An administrator who manages incoming orders.

## 4. Core Features (MVP Scope)

The following features are mandatory for the MVP.

### 4.1. User Management (Basic)
*   **User Registration**: New users can create an account.
*   **User Login**: Registered users can log in.
*   **Logout**: Users can log out of their accounts.
*   **Single Role**: All registered users will have the "Customer" role.
*   **Admin Access**: A hardcoded admin login will be available for administrative tasks.
*   **Out of Scope**: Password encryption, "Forgot Password" functionality.

### 4.2. Restaurant Listing
*   **View Restaurants**: Users can see a list of all available restaurants.
*   **Restaurant Details**: Each restaurant will display its Name, Location, and Open/Closed status.
*   **Simplifications**: No support for multiple branches. A small set of 2-3 sample restaurants is sufficient.

### 4.3. Menu Viewing
*   **View Menu**: Users can view the menu of a selected restaurant.
*   **Menu Item Details**: Each food item will display its Name, Price, Type (Veg/Non-Veg), and Availability.
*   **Simplifications**: No menu categories or food images are required.

### 4.4. Cart Management
*   **Add to Cart**: Users can add food items to their shopping cart.
*   **Update Quantity**: Users can increase or decrease the quantity of an item in the cart.
*   **Remove from Cart**: Users can remove an item from the cart.
*   **View Cart**: Users can view the contents of their cart and the total amount.
*   **Simplifications**: The cart is session-based and will not be saved after the user logs out.

### 4.5. Order Placement
*   **Place Order**: Users can place an order from the items in their cart.
*   **Order ID**: A unique Order ID is generated for each new order.
*   **Order Status**: Orders will have a status, initially "Placed".
*   **Simplifications**: No order cancellation or detailed tracking stages.

### 4.6. Payment (Dummy)
*   **Payment Method**: Users can choose a payment method: "Cash on Delivery" or a dummy "Online" option.
*   **Confirmation**: A payment success message will be displayed.
*   **Simplifications**: No integration with real payment gateways.

### 4.7. Order History
*   **View History**: Users can view a list of their previous orders.
*   **Order Details**: The history will show Order ID, Date, Total Amount, and Status.
*   **Simplifications**: No invoice generation or download.

### 4.8. Admin Functions (Minimal)
*   **View All Orders**: The admin can view a list of all orders from all customers.
*   **Update Order Status**: The admin can mark an order's status as "Delivered".
*   **View Order Count**: The admin can see the total number of orders placed.
*   **Simplifications**: No analytics, charts, or earnings reports.

## 5. Out of Scope for MVP

To ensure a clean and focused implementation, the following features are explicitly excluded:

*   Reviews and ratings
*   Coupons and promotional codes
*   Managing multiple user addresses
*   Email or push notifications
*   Delivery partner assignment and tracking
*   Advanced search and filtering
*   Advanced reporting and analytics

## 6. Simple User Flow

```
User Login
   ↓
View Restaurants
   ↓
Select Restaurant
   ↓
View Menu
   ↓
Add Items to Cart
   ↓
Place Order
   ↓
View Order History
```

## 7. Proposed Technical Stack

*   **Language**: Java
*   **Build Tool**: Maven or Gradle
*   **User Interface**: Console-based (Command-Line Interface)
*   **Data Storage**: In-memory data structures (e.g., `ArrayList`, `HashMap`) for simplicity. No database is required for the MVP.