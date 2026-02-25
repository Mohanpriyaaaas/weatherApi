package com.example.weather.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.weather.dto.ResponseDto;
import com.example.weather.entity.Weather;
import com.example.weather.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {

	private final WeatherService service;

    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping("/date/{date}")
    public List<Weather> getByDate(@PathVariable String date) {
        return service.getWeatherByDate(LocalDate.parse(date));
    }
    
    @GetMapping("/month/{month}")
    public List<Weather> getByMonth(@PathVariable int month) {
        return service.getWeatherByMonth(month);
    }  @GetMapping("/year/{year}/stats")
    public List<ResponseDto> getStats(@PathVariable int year) {
        return service.getMonthlyStats(year);
    }
    
}