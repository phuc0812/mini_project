package com.vn.iot_weather;

import com.vn.iot_weather.dto.WeatherDto;
import com.vn.iot_weather.service.WeatherService;
import com.vn.iot_weather.util.MqttUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private MqttUtil mqttUtil;

    @RequestMapping("/trang-chu")
    public String homePage(Model model){
        mqttUtil.subscriber();
        WeatherDto weatherDto = weatherService.findLastWeather();
        model.addAttribute("weather", weatherDto);
        return "home";
    }
}
