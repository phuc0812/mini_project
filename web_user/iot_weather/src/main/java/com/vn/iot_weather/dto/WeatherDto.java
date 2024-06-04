package com.vn.iot_weather.dto;

import java.util.Date;

public class WeatherDto {
    private Long id;
    private Date createdDate;
    private Date modifiedDate;
    private String temperature;
    private String humidity;

    public WeatherDto() {
    }

    public WeatherDto(Long id, Date createdDate, Date modifiedDate, String temperature, String humidity) {
        this.id = id;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public WeatherDto(String temperature, String humidity){
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}
