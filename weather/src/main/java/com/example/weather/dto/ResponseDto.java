package com.example.weather.dto;

public class ResponseDto {

    private Integer month;
    private Double maxTemperature;
    private Double minTemperature;
    private Double averageTemperature;

    public ResponseDto() {}

    public ResponseDto(Integer month,
                       Double maxTemperature,
                       Double minTemperature,
                       Double averageTemperature) {
        this.month = month;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.averageTemperature = averageTemperature;
    }

    public Integer getMonth() { return month; }
    public Double getMaxTemperature() { return maxTemperature; }
    public Double getMinTemperature() { return minTemperature; }
    public Double getAverageTemperature() { return averageTemperature; }

    public void setMonth(Integer month) { this.month = month; }
    public void setMaxTemperature(Double maxTemperature) { this.maxTemperature = maxTemperature; }
    public void setMinTemperature(Double minTemperature) { this.minTemperature = minTemperature; }
    public void setAverageTemperature(Double averageTemperature) { this.averageTemperature = averageTemperature; }
}