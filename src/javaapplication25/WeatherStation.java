/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication25;

/**
 *
 * @author lab_services_student
 */


// WeatherStation.java
// Manages multiple WeatherDay objects

import java.util.ArrayList;

public class WeatherStation {
    private ArrayList<WeatherDay> weatherDays;

    // Constructor
    public WeatherStation() {
        weatherDays = new ArrayList<>();
    }

    // Add a weather day
    public void addWeatherDay(WeatherDay wd) {
        weatherDays.add(wd);
    }

    // Remove a weather day
    public boolean removeWeatherDay(WeatherDay wd) {
        return weatherDays.remove(wd);
    }

    // Get all weather days
    public ArrayList<WeatherDay> getWeatherDays() {
        return weatherDays;
    }

    // Calculate average temperature for a city
    public double averageTemperature(String city) {
        int total = 0;
        int count = 0;
        for (WeatherDay wd : weatherDays) {
            if (wd.getCity().equalsIgnoreCase(city)) {
                total += wd.getTemperature();
                count++;
            }
        }
        return count == 0 ? 0 : (double) total / count;
    }
}
