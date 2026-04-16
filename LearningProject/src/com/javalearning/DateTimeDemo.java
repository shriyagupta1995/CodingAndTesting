package com.javalearning;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeDemo {
    public static void main(String[] args) {
        // Current date
        LocalDate date = LocalDate.now();
        System.out.println("Current Date: " + date);

        // Current time
        LocalTime time = LocalTime.now();
        System.out.println("Current Time: " + time);

        // Current date and time
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Current DateTime: " + dateTime);

        // Formatting date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);
        System.out.println("Formatted DateTime: " + formattedDateTime);

        // Adding days
        LocalDate futureDate = date.plusDays(10);
        System.out.println("Date after 10 days: " + futureDate);

        // Subtracting hours
        LocalTime pastTime = time.minusHours(2);
        System.out.println("Time 2 hours ago: " + pastTime);
    }
}
