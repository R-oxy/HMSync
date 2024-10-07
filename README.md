# HMSync - Hotel Management System

## Project Overview

HMSync is a comprehensive **Hotel Management System** designed to streamline hotel operations such as room booking, guest management, staff management, and payments. It provides an integrated solution for managing daily hotel activities, ensuring efficient workflow and data synchronization across various departments.

This project is being developed as part of the ALX Webstack Portfolio Project.

## Project Team

- Aron Mang'ati
- Tshidiso Rasemetse
- Anthony Otieno

## Project Description

HMSync allows hotels to manage their day-to-day operations in an organized and efficient way. The system includes functionalities for:
- Booking and managing room reservations
- Managing guest information and profiles
- Handling staff data and roles
- Payment processing for guest stays
- Real-time synchronization of room availability and staff assignment

The system is divided into two main components:
1. **Backend**: Developed using **Java Spring Boot**.
2. **Frontend/UI**: Developed using **React with TypeScript**.

### Key Features:
- Room management (availability, types, prices)
- Guest management (check-in, check-out, guest details)
- Booking system with status updates
- Payment integration for secure transactions
- Staff management and role assignments
- Reports and real-time data synchronization

## Learning Objectives

- Building a full-stack web application using **Java Spring Boot** for the backend and **React** with **TypeScript** for the frontend.
- Gaining experience with relational databases (PostgreSQL) and **JPA** (Java Persistence API) for handling database interactions.
- Implementing user authentication and authorization.
- Integrating third-party services like **Heroku/AWS** for hosting and **Payment Gateway** integration for processing transactions.
- Deploying a cloud-based application using modern tools and services.

## Technologies Used

### Backend:
- **Java Spring Boot**: For building REST APIs and managing the backend logic.
- **PostgreSQL**: Database for storing hotel, room, staff, guest, booking, and payment information.
- **JPA/Hibernate**: ORM to handle database interactions.
- **Spring Security**: For managing user authentication and authorization.
- **Heroku/AWS**: Hosting platform for backend services.

### Frontend:
- **React**: For building a dynamic and responsive user interface.
- **TypeScript**: Ensuring type safety and code maintainability in the frontend.

### Tools:
- **Maven/Gradle**: Dependency management and build automation.
- **Trello**: For task and project management.
- **GitHub**: Version control and collaboration.

## Database Design

The project uses **PostgreSQL** as the relational database to store hotel data. Below is an overview of the entities involved and their relationships:

### Entities:
- **Hotel**: Stores hotel information like name, address, phone, and check-in/check-out times.
- **Room**: Tracks room details such as type, status, and availability.
- **Guest**: Records guest information like name, contact details, and stay history.
- **Booking**: Manages reservation details, check-in/check-out dates, and total price.
- **Staff**: Stores staff members' roles, salaries, and employment details.
- **Payment**: Logs payment transactions and methods.

Refer to the database diagram in the `docs/` folder for more details.

## Third-Party Services

- **Payment Gateway Integration**: To facilitate secure transactions for room bookings.
- **Hosting Platforms (Heroku/AWS)**: For deploying the backend and frontend components.
- **Email Notifications**: To notify users about booking confirmations or cancellations.

## Identified Challenges

- **Data Synchronization**: Ensuring real-time updates across various hotel operations (booking status, room availability, etc.).
- **Payment Integration**: Seamless and secure payment handling using third-party services.
- **User Authentication**: Managing different access levels for hotel staff and guests.
- **Deployment**: Setting up an efficient CI/CD pipeline for deploying the backend and frontend on cloud services.

## Work Schedule

We are using **Trello** as our project management tool to keep track of tasks, set deadlines, and manage workloads. Here's a high-level schedule of the project:

- **Week 1**: Finalizing the design and database schema, setting up the backend and frontend project structure.
- **Week 2**: Developing core features for room booking, guest management, and user authentication.
- **Week 3**: Integration with third-party services like payment gateways and email notifications.
- **Week 4**: Testing, bug fixing, and deploying the system to Heroku/AWS.

## Mockups

The project includes a detailed set of UI mockups, which can be found in the `docs/mockups/` folder. These mockups guide the development of the user interface, ensuring a user-friendly experience.

## Project Setup

### Backend Setup (Java Spring Boot)

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/HMSync.git
   cd HMSync/backend
   ```

2. Install dependencies:
   ```bash
   mvn clean install
   ```

3. Set up PostgreSQL database:
    - Install PostgreSQL and create a new database named `hotel_management`.
    - Update the database configuration in `application.properties`:
      ```properties
      spring.datasource.url=jdbc:postgresql://localhost:5432/hotel_management
      spring.datasource.username=your_username
      spring.datasource.password=your_password
      ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

### Frontend Setup (React & TypeScript)

1. Navigate to the `frontend` folder:
   ```bash
   cd ../frontend
   ```

2. Install the dependencies:
   ```bash
   npm install
   ```

3. Start the development server:
   ```bash
   npm start
   ```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.