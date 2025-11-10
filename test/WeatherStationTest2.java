/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lab_services_student
 */



import Question2.WeatherDay;
import Question2.WeatherStation;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class WeatherStationTest2 {

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
        WeatherDay wd = new WeatherDay("Durban", "Tuesday", 27);
        station.addWeatherDay(wd);
        List<WeatherDay> days = station.getWeatherDays();
        assertTrue(days.contains(wd));
    }

    @Test
    public void testRemoveWeatherDay() {
        boolean removed = station.removeWeatherDay("Cape Town", "Monday");
        assertTrue(removed);
        assertFalse(station.getWeatherDays().contains(wd1));
    }

    @Test
    public void testAverageTemperature() {
        double avg = station.averageTemperature("Cape Town");
        assertEquals((25 + 28) / 2.0, avg, 0.001);
    }

    @Test
    public void testHottestAndColdestDay() {
        WeatherDay hot = station.hottestDay("Durban");
        WeatherDay cold = station.coldestDay("Cape Town");

        assertEquals(wd3, hot);
        assertEquals(wd1, cold);
    }
}
