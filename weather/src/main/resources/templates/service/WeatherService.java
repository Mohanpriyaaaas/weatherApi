package com.example.weather.service;

import java.time.LocalDate;
import java.util.List;

import com.example.weather.dto.ResponseDto;
import com.example.weather.entity.Weather;


public interface WeatherService {

    public List<Weather> getWeatherByDate(LocalDate date);

     public List<Weather> getWeatherByMonth(int month);
    public List<ResponseDto> getMonthlyStats(int year);
}
