package com.vn.iot_weather.service;

import com.vn.iot_weather.converter.WeatherConverter;
import com.vn.iot_weather.dto.WeatherDto;
import com.vn.iot_weather.entity.WeatherEntity;
import com.vn.iot_weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService implements IWeatherService{

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private WeatherConverter weatherConverter;

    @Override
    public WeatherDto findLastWeather() {
        List<WeatherEntity> entities = weatherRepository.findAll();
        WeatherEntity lastEntity = entities.get(entities.size() - 1);
        return weatherConverter.toDto(lastEntity);
    }

    @Override
    public WeatherDto save(WeatherDto dto) {
        WeatherEntity entity = weatherConverter.toEntity(dto);
        return weatherConverter.toDto(weatherRepository.save(entity));
    }
}
