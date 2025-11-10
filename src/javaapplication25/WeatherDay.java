/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication25;



/**
 * WeatherDay class represents the weather data for a specific city on a specific day.
 * LO1 – Classes & Objects
 */

// WeatherDay.java
// Represents a single day's weather data

public class WeatherDay {
    private String city;
    private String day;
    private int temperature;

    // Constructor
    public WeatherDay(String city, String day, int temperature) {
        this.city = city;
        this.day = day;
        this.temperature = temperature;
    }

    // Getters and Setters
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getDay() { return day; }
    public void setDay(String day) { this.day = day; }

    public int getTemperature() { return temperature; }
    public void setTemperature(int temperature) { this.temperature = temperature; }

    // toString for display
    @Override
    public String toString() {
        return city + " - " + day + ": " + temperature + "°C";
    }
}
