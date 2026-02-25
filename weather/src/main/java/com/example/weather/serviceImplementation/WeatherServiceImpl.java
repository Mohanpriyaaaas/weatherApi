package com.example.weather.serviceImplementation;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

import com.example.weather.dto.ResponseDto;
import com.example.weather.entity.Weather;
import com.example.weather.repository.WeatherRepository;
import com.example.weather.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService{
	 private final WeatherRepository repository;

	    public WeatherServiceImpl(WeatherRepository repository) {
	        this.repository = repository;
	    }

	    public List<Weather> getWeatherByDate(LocalDate date) {
	        return repository.findByDate(date);
	    }

	    public List<Weather> getWeatherByMonth(int month) {
	        return repository.findByMonth(month);
	    }
	    public List<ResponseDto> getMonthlyStats(int year) {

	        List<Object[]> results = repository.getMonthlyStats(year);
	        return results.stream()
	                .map(obj -> new ResponseDto(
	                        (Integer) obj[0],
	                        (Double) obj[1],
	                        (Double) obj[2],
	                        (Double) obj[3]
	                ))
	                .toList();
	    }
	}