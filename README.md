# Smart Grocery List & Pantry Manager

## Overview
Smart Grocery List & Pantry Manager is an advanced REST API designed to simplify grocery shopping and pantry inventory management.

## Features

- **Create and Manage Grocery Lists**: Users can create, edit, and delete grocery lists.

- **Track Pantry Stock**: Monitor stock levels, add, update, and remove pantry items.

- **Receive Low-Stock Alerts**: Notifications for items running low in the pantry.

- **Optimize Shopping Recommendations**: Purchase suggestions based on frequently bought items.

- **Track Expiry Dates**: Helps users avoid waste by tracking item expiration dates.

## Technologies Used

- **Java with Spring Boot** for REST API development.
- **Maven** for dependency management.
- **JUnit & Mockito** for unit testing.
- **Git** for version control.

## Setup Instructions

### Prerequisites

Ensure you have the following installed:

- Java 17 or higher
- Maven 3.6+
- Git

### Installation

1. Clone the repository:  
   ```sh
   git clone https://github.com/your-repo/smart-grocery-list.git

2. Navigate into the project directory:  
   ```sh
   cd smart-grocery-list
 
 3. Build the project using Maven:
   ```sh
   mvn clean install


 Run the application:
 mvn spring-boot:run

## API Endpoints
Grocery List APIs:
-Create a grocery list:
POST /grocery-lists
-Get a grocery list:
GET /grocery-lists/{listId}

Pantry Management APIs
-Add pantry item:
POST /pantry-items
-Get pantry items:
GET /pantry-items/{userId}

 Alerts & Recommendations
-Get pantry alerts:
GET /pantry-alerts/{userId}
-Get shopping recommendations:
GET /recommendations/{userId}

## Contribution Guidelines
-Use feature branches (e.g., feature/user-management).
-Submit pull requests for code review.
-Write unit tests for new functionality.
-Keep code well-documented.

## Testing
Run unit tests with:
mvn test

# License
This project is licensed under the MIT License.



