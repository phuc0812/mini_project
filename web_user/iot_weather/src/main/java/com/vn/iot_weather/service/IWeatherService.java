package com.vn.iot_weather.service;

import com.vn.iot_weather.dto.WeatherDto;

import java.util.List;

public interface IWeatherService {
    WeatherDto findLastWeather();
    WeatherDto save(WeatherDto dto);
}
