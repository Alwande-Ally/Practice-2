/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lab_services_student
 */

// WeatherStationTest.java
// JUnit 4 tests for WeatherStation

import org.junit.*;
import java.util.ArrayList;
import javaapplication25.WeatherDay;
import javaapplication25.WeatherStation;
import static org.junit.Assert.*;

public class WeatherStationTest {

    private WeatherStation station;
    private WeatherDay wd1, wd2, wd3;

    @Before
    public void setUp() {
        station = new WeatherStation();

        wd1 = new WeatherDay("Cape Town", "Monday", 25);
        wd2 = new WeatherDay("Cape Town", "Tuesday", 28);
        wd3 = new WeatherDay("Durban", "Monday", 30);

        station.addWeatherDay(wd1);
        station.addWeatherDay(wd2);
        station.addWeatherDay(wd3);
    }

    @Test
    public void testAddWeatherDay() {
        WeatherDay wd4 = new WeatherDay("Johannesburg", "Wednesday", 22);
        station.addWeatherDay(wd4);
        assertTrue(station.getWeatherDays().contains(wd4));
    }

    @Test
    public void testRemoveWeatherDay() {
        boolean removed = station.removeWeatherDay(wd1);
        assertTrue(removed);
        assertFalse(station.getWeatherDays().contains(wd1));
    }

    @Test
    public void testAverageTemperature() {
        double avgCT = station.averageTemperature("Cape Town");
        assertEquals(26.5, avgCT, 0.01); // Average of 25 & 28
    }

    @Test
    public void testEmptyAverage() {
        double avg = station.averageTemperature("Pretoria");
        assertEquals(0, avg, 0.01); // No data → 0
    }

    @Test
    public void testGetWeatherDays() {
        ArrayList<WeatherDay> days = station.getWeatherDays();
        assertEquals(3, days.size());
    }
}
