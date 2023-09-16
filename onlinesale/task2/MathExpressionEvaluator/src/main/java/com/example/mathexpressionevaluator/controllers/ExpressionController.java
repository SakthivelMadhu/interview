package onlinesale.task2.MathExpressionEvaluator.src.main.java.com.example.mathexpressionevaluator.controllers;

import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.net.*;
import java.util.*;

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


