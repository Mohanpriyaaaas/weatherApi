package com.example.weather.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.weather.entity.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Long>{
	 @Query("""
		        SELECT w FROM Weather w
		        WHERE DATE(w.datetimeUtc) = :date
		    """)
		    List<Weather> findByDate(@Param("date") LocalDate date);
	 
	          
		    @Query("""
		        SELECT w FROM Weather w
		        WHERE MONTH(w.datetimeUtc) = :month
		    """)
		    List<Weather> findByMonth(@Param("month") int month);

		    @Query("""
		        SELECT MONTH(w.datetimeUtc),
		               MAX(w.tempm),
		               MIN(w.tempm),
		               AVG(w.tempm)
		        FROM Weather w
		        WHERE YEAR(w.datetimeUtc) = :year
		        GROUP BY MONTH(w.datetimeUtc)
		    """)
		    List<Object[]> getMonthlyStats(@Param("year") int year);
		}