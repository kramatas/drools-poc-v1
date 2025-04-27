# Customer Discount Service

This project is a Spring Boot application that provides a RESTful API for managing customers and applying discount rules using Drools.

## Features

- **Customer Management**: REST API to manage customer data.
- **Discount Rules**: Business rules for discounts implemented using Drools.
- **Neo4j Integration**: Customer data is stored in a Neo4j database.
- **Spring Boot**: Built with Spring Boot for rapid development and deployment.

## Technologies Used

- **Java**: Programming language.
- **Spring Boot**: Framework for building the application.
- **Drools**: Business rules engine for applying discount logic.
- **Neo4j**: Graph database for storing customer data.
- **Maven**: Build and dependency management tool.

## Project Structure

- `src/main/java/com/kramatas/rules/controller`: Contains REST controllers.
- `src/main/java/com/kramatas/rules/service`: Contains service logic.
- `src/main/java/com/kramatas/rules/repository`: Contains repository interfaces for database operations.
- `src/main/java/com/kramatas/rules/config`: Contains configuration files (e.g., Drools setup).
- `src/main/resources/rules`: Contains Drools `.drl` files for business rules.

## Discount Rules

The discount rules are defined in the `src/main/resources/rules/discount-rules.drl` file using Drools. The following rules are applied:

1. **Senior Discount**: Customers aged over 60 receive a 20% discount.
2. **Loyal Customer Discount**: Customers with more than 5 years with the company receive a 15% discount.
3. **Default Discount**: Customers who do not qualify for other discounts receive a 5% discount.

The rules are applied in order of priority using the `salience` attribute.

## Prerequisites
- Java 17 or higher
- docker

## Endpoints

### Customer Discount API

- **GET** `/api/customers/{id}/discount`: Applies discount rules to a customer by ID and returns the updated customer details.

## To Run the Project
1. Clone the repository:
   ```bash
   git clone https://github.com/kramatas/drools-poc-v1.git
   cd drools-poc
   ```
2. run docker-compose build --no-cache
3. run docker-compose up
4. curl http://localhost:8080/api/customers/1/discount to test the API

### Example Response

```json
{
  "id": 1,
  "name": "John Doe",
  "age": 65,
  "yearsWithCompany": 10,
  "discount": 20
}

```
5.##Phone Filtering API
refer to [CURLME.md](CURLME.md) for test scenarios and examples.
