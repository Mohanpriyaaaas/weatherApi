package com.example.weather.config;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.weather.entity.Weather;
import com.example.weather.repository.WeatherRepository;

@Component
public class Data implements CommandLineRunner {

    private final WeatherRepository repository;

    public Data(WeatherRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        InputStream inputStream =
                getClass().getResourceAsStream("/testset.csv");

        if (inputStream == null) {
            throw new FileNotFoundException("File not found in resources folder");
        }

        BufferedReader br =
                new BufferedReader(new InputStreamReader(inputStream));

        String line;
        br.readLine(); // skip header

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyyMMdd-HH:mm");

        List<Weather> weatherList = new ArrayList<>();

        while ((line = br.readLine()) != null) {

            String[] data = line.split(",");

            // 🔴 Safety check
            if (data.length < 20) {
                System.out.println("Skipping invalid row: " + line);
                continue;
            }

            Weather weather = new Weather();

            try {

                LocalDateTime dateTime =
                        LocalDateTime.parse(data[0], formatter);

                weather.setDatetimeUtc(dateTime);
                weather.setConds(data[1]);
                weather.setDewptm(parseDoubleSafe(data[2]));
                weather.setFog(parseIntegerSafe(data[3]));
                weather.setHail(parseIntegerSafe(data[4]));
                weather.setHeatindexm(parseDoubleSafe(data[5]));
                weather.setHum(parseDoubleSafe(data[6]));
                weather.setPrecipm(parseDoubleSafe(data[7]));
                weather.setPressurem(parseDoubleSafe(data[8]));
                weather.setRain(parseIntegerSafe(data[9]));
                weather.setSnow(parseIntegerSafe(data[10]));
                weather.setTempm(parseDoubleSafe(data[11]));
                weather.setThunder(parseIntegerSafe(data[12]));
                weather.setTornado(parseIntegerSafe(data[13]));
                weather.setVism(parseDoubleSafe(data[14]));
                weather.setWdird(parseDoubleSafe(data[15]));
                weather.setWdire(data[16]);
                weather.setWgustm(parseDoubleSafe(data[17]));
                weather.setWindchillm(parseDoubleSafe(data[18]));
                weather.setWspdm(parseDoubleSafe(data[19]));

                weatherList.add(weather);

            } catch (Exception e) {
                System.out.println("Error parsing row: " + line);
            }
        }

        repository.saveAll(weatherList); // 🚀 Faster than save() in loop

        br.close();
        System.out.println("CSV DATA LOADED SUCCESSFULLY");
    }

    private Double parseDoubleSafe(String value) {
        if (value == null) return null;
        value = value.trim();
        if (value.isEmpty() ||
            value.equalsIgnoreCase("N/A") ||
            value.equalsIgnoreCase("NA") ||
            value.equalsIgnoreCase("null")) {
            return null;
        }
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Integer parseIntegerSafe(String value) {
        if (value == null) return null;
        value = value.trim();
        if (value.isEmpty() ||
            value.equalsIgnoreCase("N/A") ||
            value.equalsIgnoreCase("NA") ||
            value.equalsIgnoreCase("null")) {
            return null;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}