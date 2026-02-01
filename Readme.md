# Sorted Array Merge API (Spring Boot)

A high-performance REST service built with Spring Boot 4.0.2
that merges two pre-sorted integer arrays using a multi-threaded approach.
Results are persisted in an H2 In-Memory database.

---

## Tech Stack
* **Runtime:** Azul Zulu JDK 17
* **Build Tool:** Gradle 8.14.1
* **Database:** H2 (In-Memory)
* **Security:** Spring Security + JWT
* **Documentation:** OpenAPI 3 (Swagger UI)

---

## Setup & Installation

1. **Verify Environment**
   Ensure your Java version matches:
   ```bash
   java -version # Should show Azul Zulu 17
   ./gradlew -v  # Should show Gradle 8.14.1
2. **Run Point72 Application Class** 

    Ensure nothing else is running on 8080 port for this to run , or you can add port in application properties

3. **Open Swagger UI** : http://localhost:8080/swagger-ui/index.html
4. **Authenticate and Test** :

      Login:

           Open Swagger UI and find the AuthController.
           Call POST /auth/login with these credentials:
           JSON

           {
             "username": "admin",
             "password": "password"
           }

           Copy the JWT string returned in the response.

      Authorize:

           Click the green Authorize button at the top of the Swagger page.

           Enter the coped token.

           Click Authorize and then Close.

      Execute Merge:

           You can now use the POST /api/merge endpoint.
                                 Or
           GET /api/merge/length/{len} endpoint to get merged list.