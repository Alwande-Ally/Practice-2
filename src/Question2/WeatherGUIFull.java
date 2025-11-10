/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question2;

/**
 *
 * @author lab_services_student
 */



import javax.swing.*;
import java.awt.*;

// LO3: Full GUI with Add, Remove, Summary, Hottest/Coldest, Clear
public class WeatherGUIFull extends JFrame {

    private WeatherStation station;
    private JComboBox<String> cityComboBox;
    private JTextField dayTextField, tempTextField;
    private JTextArea reportTextArea;
    private JButton addButton, removeButton, summaryButton, clearButton;

    public WeatherGUIFull() {
        station = new WeatherStation();

        setTitle("Weather Station");
        setSize(550, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel for inputs and buttons
        JPanel topPanel = new JPanel(new GridLayout(5, 2, 5, 5));

        topPanel.add(new JLabel("City:"));
        cityComboBox = new JComboBox<>(new String[]{"Cape Town", "Durban", "Johannesburg"});
        topPanel.add(cityComboBox);

        topPanel.add(new JLabel("Day:"));
        dayTextField = new JTextField();
        topPanel.add(dayTextField);

        topPanel.add(new JLabel("Temperature (°C):"));
        tempTextField = new JTextField();
        topPanel.add(tempTextField);

        addButton = new JButton("Add Day");
        removeButton = new JButton("Remove Day");
        summaryButton = new JButton("Summary Report");
        clearButton = new JButton("Clear");

        topPanel.add(addButton);
        topPanel.add(removeButton);
        topPanel.add(summaryButton);
        topPanel.add(clearButton);

        // Report area
        reportTextArea = new JTextArea();
        reportTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reportTextArea);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Event handling
        addButton.addActionListener(e -> addWeatherDay());
        removeButton.addActionListener(e -> removeWeatherDay());
        summaryButton.addActionListener(e -> showSummaryReport());
        clearButton.addActionListener(e -> clearFields());
    }

    // Add a weather day
    private void addWeatherDay() {
        try {
            String city = (String) cityComboBox.getSelectedItem();
            String day = dayTextField.getText().trim();
            double temp = Double.parseDouble(tempTextField.getText().trim());

            if (day.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter a valid day.");
                return;
            }

            station.addWeatherDay(new WeatherDay(city, day, temp));
            JOptionPane.showMessageDialog(this, "Weather Day Added Successfully!");
            clearFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid number for temperature.");
        }
    }

    // Remove a weather day
    private void removeWeatherDay() {
        String city = (String) cityComboBox.getSelectedItem();
        String day = dayTextField.getText().trim();

        if (station.removeWeatherDay(city, day)) {
            JOptionPane.showMessageDialog(this, "Weather Day Removed Successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "No matching day found to remove.");
        }
        clearFields();
    }

    // Show summary report
    private void showSummaryReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Weather Report:\n");

        for (WeatherDay wd : station.getWeatherDays()) {
            sb.append(wd).append("\n");
        }

        sb.append("\nAverage Temperatures:\n");
        String[] cities = {"Cape Town", "Durban", "Johannesburg"};
        for (String city : cities) {
            double avg = station.averageTemperature(city);
            if (avg > 0) {
                sb.append(city).append(": ").append(String.format("%.1f", avg)).append("°C\n");
            }
        }

        sb.append("\nHottest and Coldest Days:\n");
        for (String city : cities) {
            WeatherDay hot = station.hottestDay(city);
            WeatherDay cold = station.coldestDay(city);
            if (hot != null && cold != null) {
                sb.append("Hottest Day for ").append(city).append(": ")
                        .append(hot.getDay()).append(" - ").append(hot.getTemperature()).append("°C\n");
                sb.append("Coldest Day for ").append(city).append(": ")
                        .append(cold.getDay()).append(" - ").append(cold.getTemperature()).append("°C\n");
            }
        }

        reportTextArea.setText(sb.toString());
    }

    // Clear fields
    private void clearFields() {
        dayTextField.setText("");
        tempTextField.setText("");
        reportTextArea.setText("");
        cityComboBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WeatherGUIFull().setVisible(true));
    }
}
