package com.vn.iot_weather.converter;

import com.vn.iot_weather.dto.WeatherDto;
import com.vn.iot_weather.entity.WeatherEntity;
import org.springframework.stereotype.Component;

@Component
public class WeatherConverter {
    public WeatherEntity toEntity(WeatherDto dto){
        WeatherEntity entity = new WeatherEntity();
        entity.setId(dto.getId());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setModifiedDate(dto.getModifiedDate());
        entity.setHumidity(dto.getHumidity());
        entity.setTemperature(dto.getTemperature());
        return entity;
    }

    public WeatherDto toDto(WeatherEntity entity){
        WeatherDto dto = new WeatherDto();
        dto.setId(entity.getId());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setModifiedDate(entity.getModifiedDate());
        dto.setHumidity(entity.getHumidity());
        dto.setTemperature(entity.getTemperature());
        return dto;
    }
}
