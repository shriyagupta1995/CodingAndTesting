//This code demonstrates POST request in REST API
package com.javalearning;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SimplePostClient {
    public static void main(String[] args) {
        try {
            // Step 1: Define the API endpoint (JSONPlaceholder accepts test POSTs)
            String apiUrl = "https://httpbin.org/post";

            // Step 2: Create a URL object
            URL url = new URL(apiUrl);

            // Step 3: Open a connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Step 4: Set request method to POST
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            // Step 5: Create JSON data to send
            String jsonInputString = "{ \"title\": \"Hello REST\", \"body\": \"This is a test POST request\", \"userId\": 1 }";

            // Step 6: Write JSON data to request body
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Step 7: Read the response
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder response = new StringBuilder();
            String responseLine;

            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }

            // Step 8: Print the response
            System.out.println("Response from API:");
            System.out.println(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
