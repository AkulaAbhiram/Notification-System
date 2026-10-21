# Notification System

A notification service built as Spring Boot microservices. One API call to the notification service sends a message to a person by **email** (Gmail SMTP) and **SMS** (Twilio), records it in MySQL, and lets you look up its delivery status later.

## Services

| Service | Folder | Port | What it does |
|---|---|---|---|
| Notification API | `project1` | 8081 | Public API: sends a notification through the email and SMS services, stores it, manages sender details |
| Email service | `emailserviceprovider` | 8082 | Sends email through Gmail SMTP and logs each email |
| SMS service | `messager` | 8083 | Sends SMS through Twilio and logs each message |
| Service discovery | `service_discovery` | 8761 | Eureka server the services register with, so they call each other by name (`http://emailserviceprovider/...`) |

## API

| Method | Path | Body / result |
|---|---|---|
| `POST` | `/notification` | A notification (receiver email, receiver phone, message). Sends it by email and SMS and returns the stored record with its status. |
| `GET` | `/notification/{txnId}` | The delivery status of a notification |
| `PUT` | `/senderInfo/{senderId}` | Updates a sender's name, email, phone or password |

## Running it locally

Needs Java 17, Maven (the `mvnw` wrapper in each folder works), and MySQL.

1. Create the databases: `emp`, `emp2` and `emp3`.
2. Set the credentials as environment variables. Nothing secret is stored in the code:

   | Variable | Used by | Value |
   |---|---|---|
   | `DB_USERNAME`, `DB_PASSWORD` | all three services | your MySQL login (`DB_USERNAME` defaults to `root`) |
   | `MAIL_USERNAME`, `MAIL_PASSWORD` | email service | a Gmail address and a Gmail **app password** |
   | `TWILIO_ACCOUNT_SID`, `TWILIO_AUTH_TOKEN`, `TWILIO_PHONE_NUMBER` | SMS service | from the Twilio console |

3. Start the services in this order, each with `./mvnw spring-boot:run` from its folder: `service_discovery`, then `emailserviceprovider` and `messager`, then `project1`.
4. Send a notification:

   ```bash
   curl -X POST http://localhost:8081/notification -H "Content-Type: application/json" -d "{\"receiverEmailId\":\"someone@example.com\",\"receiverPhone\":\"+91XXXXXXXXXX\",\"context\":\"Hello from the notification system\"}"
   ```

## Stack

Java 17 · Spring Boot 3.3 · Spring Cloud (Eureka) · Spring Data JPA · MySQL · Gmail SMTP · Twilio
