//This code is to summarize REST API and GET request
package com.javalearning;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;

public class SimpleRestClient {
    public static void main(String[] args) {
        try {
            // Step 1: API endpoint
            String apiUrl = "https://randomuser.me/api/";

            // Step 2: Connect
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Step 3: Read response
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Step 4: Parse JSON using Gson
            Gson gson = new Gson();
            ApiResponse apiResponse = gson.fromJson(response.toString(), ApiResponse.class);

            // Step 5: Print parsed data
            User user = apiResponse.results[0];
            System.out.println("User Info:");
            System.out.println("Name: " + user.name.first + " " + user.name.last);
            System.out.println("Gender: " + user.gender);
            System.out.println("Email: " + user.email);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Helper classes
class Name {
    String title;
    String first;
    String last;
}

class User {
    String gender;
    Name name;
    String email;
}

class ApiResponse {
    User[] results;
}
