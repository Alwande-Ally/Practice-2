/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication25;

/**
 *
 * @author lab_services_student
 */

// WeatherGUI.java
// Provides a GUI to interact with WeatherStation

import javax.swing.*;
import java.awt.*;

public class WeatherGUI extends JFrame {
    private WeatherStation station;
    private JComboBox<String> cityComboBox;
    private JTextField dayTextField, tempTextField;
    private JTextArea reportTextArea;
    private JButton addButton, clearButton;

    // Constructor
    public WeatherGUI() {
        station = new WeatherStation();

        setTitle("Weather Station");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top Panel
        JPanel topPanel = new JPanel(new GridLayout(4, 2, 5, 5));

        topPanel.add(new JLabel("City:"));
        cityComboBox = new JComboBox<>(new String[]{"Cape Town", "Durban", "Johannesburg"});
        topPanel.add(cityComboBox);

        topPanel.add(new JLabel("Day:"));
        dayTextField = new JTextField();
        topPanel.add(dayTextField);

        topPanel.add(new JLabel("Temperature (°C):"));
        tempTextField = new JTextField();
        topPanel.add(tempTextField);

        addButton = new JButton("Add Weather");
        clearButton = new JButton("Clear");
        topPanel.add(addButton);
        topPanel.add(clearButton);

        // Report Area
        reportTextArea = new JTextArea();
        reportTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reportTextArea);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Event Handling
        addButton.addActionListener(e -> addWeather());
        clearButton.addActionListener(e -> clearFields());
    }

    // Add weather and display report
    private void addWeather() {
        try {
            String city = (String) cityComboBox.getSelectedItem();
            String day = dayTextField.getText();
            int temp = Integer.parseInt(tempTextField.getText());

            WeatherDay wd = new WeatherDay(city, day, temp);
            station.addWeatherDay(wd);
            displayReport();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid number for temperature.");
        }
    }

    // Display all weather data
    private void displayReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Weather Report:\n");
        for (WeatherDay wd : station.getWeatherDays()) {
            sb.append(wd).append("\n");
        }
        reportTextArea.setText(sb.toString());
    }

    // Clear input fields
    private void clearFields() {
        dayTextField.setText("");
        tempTextField.setText("");
        reportTextArea.setText("");
        cityComboBox.setSelectedIndex(0);
    }

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WeatherGUI().setVisible(true));
    }
}



