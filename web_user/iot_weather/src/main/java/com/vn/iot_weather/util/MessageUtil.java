package com.vn.iot_weather.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MessageUtil {
    public Map<String, String> getHumiAndTemp(String message){
        Map<String, String> map = new HashMap<>();
        String newMess = message.trim();
        String[] arr= newMess.split(" ");
        map.put("temp", arr[1]);
        map.put("humi", arr[3]);
        return map;
    }
}
