# Task-2 : Evaluate multiple mathematical expressions at once using a Web API

# Problem Statement
Write a program that accepts multiple mathematical expressions in bulk and evaluates each of them using any public Web API available. The program should display the result of each expression on the console. Let’s assume that the API only supports 50 requests per second per client whereas your application is expected to evaluate at least 500 expressions per second. Also, the user may initiate more concurrent requests than your application can handle. Suggest an approach to handle this along with the reasoning and implementation of the same.

# Rules
No expressions should be evaluated in the code. All evaluations should be using the Web API.
You can assume different expressions/operators that are compatible with the API you choose. 
Example: Some API might use ^ operator for power some might use pow()
# Example
Input (every line is an expression, evaluate when “end” is provided as an expression)
```bash
2 * 4 * 4
5 / (7 - 5)
sqrt(5^2 - 4^2)
sqrt(-3^2 - 4^2)
end
```
# Output
```bash
2 * 4 * 4 => 32
5 / (7 - 5) => 2.5
sqrt(5^2 - 4^2) => 3
sqrt(-3^2 - 4^2) = 5i
```
# How to Build and  run: 
* make sure install maven and springboot in your system
* create springboot stater project and add nesseary dependencies
* create controller package and create ExpressionController.class in this
* Make sure below conditions/rules are applied for this project
```bash
* Accepts Multiple Mathematical Expressions
* No Expressions Evaluated in Code
* Uses Web API for Evaluation
* Input/Output provided: No.. it is response from the web API
```
* Am using port is 8081
* command to build and start the application
```bash
mvn spring-boot:run
```
* Open a web browser or use a tool like Postman to make an HTTP POST request to your endpoint:
```bash
http://localhost:8081/evaluate
```
# Code:
```bash
package com.example.mathexpressionevaluator.controllers;

import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.net.*;

@RestController
public class ExpressionController {

    @PostMapping("/evaluate")
    public String evaluateExpression(@RequestBody String expression) {
        try {

            String apiUrl = "https://api.example.com/evaluate?expression=" + expression;

            // Create URL object
            URL url = new URL(apiUrl);

            // Create connection object
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("GET");

            // Get response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            // Close the connection
            connection.disconnect();

            // Return the result obtained from the Web API
            return content.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: Unable to evaluate expression";
        }
    }
}


```
