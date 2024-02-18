# Ship Management System

This project is a Ship Management System developed with Java Spring Boot for the backend and Angular for the frontend. It allows users to manage ships and ship models in a relational database.

## Features

- CRUD operations for ships and ship models.
- View details of individual ships and ship models.
- Search functionality for ships and ship models.
- Responsive frontend design for easy access from various devices.
- Docker containerization for Angular frontend.

## Technologies Used

- **Backend:**
  - Java
  - Spring Boot
  - Spring Data JPA

- **Frontend:**
  - Angular
  - TypeScript
  - HTML/CSS

- **Containerization:**
  - Docker

## Setup Instructions

### Backend (Spring Boot)

1. Clone this repository.
2. Navigate to the `backend` directory.
3. Configure your MySQL database details in `application.properties`.
4. Run `mvn spring-boot:run` to start the backend server.

### Frontend (Angular)

1. Navigate to the `frontend` directory.
2. Ensure you have Angular CLI installed. If not, install it globally using `npm install -g @angular/cli`.
3. Run `npm install` to install dependencies.
4. Run `ng serve` to start the Angular development server.

### Docker Container for Angular Frontend

1. Ensure Docker is installed on your machine.
2. Build the Docker image by running `docker build -t ship-management-frontend .` from the `frontend` directory.
3. Run the Docker container with `docker run -p 80:80 ship-management-frontend`.

## Database Schema

The relational database contains two entities:

1. **Ship**
   - id: Long (Primary Key)
   - name: String
   - description: String
   - modelId: Long (Foreign Key referencing Model id)

2. **Model**
   - id: Long (Primary Key)
   - name: String
   - description: String

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please feel free to open an issue or create a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
