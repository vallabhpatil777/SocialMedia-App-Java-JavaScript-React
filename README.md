# Social Media Application

A social media web application built with web development technologies including React, Redux, and Java Spring Boot. This application enables users to share, interact, and connect seamlessly.

## Features

- **Post Management**: Users can create posts, like posts, and comment on them.
- **Media Upload**: Upload images and videos, stored securely on Cloudinary.
- **Chat Functionality**: Real-time chat for seamless user communication (Frontend part In progress).
- **Follow/Unfollow**: Ability to follow and unfollow other users.
- **Authentication**: Secure JWT-based authentication.
- **Database**: MySQL.

## Tech Stack

- **Frontend**:
  - React
  - Redux (State Management)
- **Backend**:
  - Java Spring Boot
  - REST API
- **Database**:
  - MySQL
- **Cloud Storage**:
  - Cloudinary (For image and video uploads)

## Prerequisites

To run the project locally, ensure you have the following installed:

- Node.js and npm
- Java Development Kit (JDK)
- MySQL

## Installation and Setup

### Backend Setup

1. Clone the repository:
   ```bash
   git clone <repository_url>
   cd <backend_directory>
   ```

2. Configure MySQL database:
   - Update `application.properties` file with your MySQL credentials.

3. Build and run the Spring Boot application:
   ```bash
   ./mvnw spring-boot:run
   ```

### Frontend Setup

1. Navigate to the frontend directory:
   ```bash
   cd <frontend_directory>
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Start the development server:
   ```bash
   npm start
   ```

4. Open the application in your browser:
   ```
   http://localhost:3000
   ```
