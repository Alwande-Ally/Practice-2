/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question2;

/**
 *
 * @author lab_services_student
 */



import java.util.ArrayList;
import java.util.List;

// LO2: Stores and manages multiple WeatherDay objects
public class WeatherStation {

    private List<WeatherDay> weatherDays;

    public WeatherStation() {
        weatherDays = new ArrayList<>();
    }

    // Add a new weather day
    public void addWeatherDay(WeatherDay wd) {
        weatherDays.add(wd);
    }

    // Remove a weather day by city and day
    public boolean removeWeatherDay(String city, String day) {
        return weatherDays.removeIf(wd -> wd.getCity().equals(city) && wd.getDay().equals(day));
    }

    // Get all weather days
    public List<WeatherDay> getWeatherDays() {
        return weatherDays;
    }

    // Average temperature for a city
    public double averageTemperature(String city) {
        double sum = 0;
        int count = 0;
        for (WeatherDay wd : weatherDays) {
            if (wd.getCity().equals(city)) {
                sum += wd.getTemperature();
                count++;
            }
        }
        return count > 0 ? sum / count : 0;
    }

    // Hottest day for a city
    public WeatherDay hottestDay(String city) {
        WeatherDay hottest = null;
        for (WeatherDay wd : weatherDays) {
            if (wd.getCity().equals(city)) {
                if (hottest == null || wd.getTemperature() > hottest.getTemperature()) {
                    hottest = wd;
                }
            }
        }
        return hottest;
    }

    // Coldest day for a city
    public WeatherDay coldestDay(String city) {
        WeatherDay coldest = null;
        for (WeatherDay wd : weatherDays) {
            if (wd.getCity().equals(city)) {
                if (coldest == null || wd.getTemperature() < coldest.getTemperature()) {
                    coldest = wd;
                }
            }
        }
        return coldest;
    }
}
