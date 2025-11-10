/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question2;

/**
 *
 * @author lab_services_student
 */

// LO1: Represents a single weather entry
public class WeatherDay {

    private String city;
    private String day;
    private double temperature;

    // Constructor
    public WeatherDay(String city, String day, double temperature) {
        this.city = city;
        this.day = day;
        this.temperature = temperature;
    }

    // Getters & Setters
    public String getCity() {
        return city;
    }

    public String getDay() {
        return day;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return city + " - " + day + ": " + temperature + "°C";
    }
}
