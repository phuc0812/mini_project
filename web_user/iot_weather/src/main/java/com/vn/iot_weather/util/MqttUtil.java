package com.vn.iot_weather.util;

import com.vn.iot_weather.dto.WeatherDto;
import com.vn.iot_weather.service.WeatherService;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MqttUtil {
    @Autowired
    private WeatherService weatherService;

    @Autowired
    private MessageUtil messageUtil;

    public void subscriber(){
        String broker = "tcp://broker.hivemq.com:1883";
        String topic = "topic/weather";
        try{
            MqttClient client = new MqttClient(broker, MqttClient.generateClientId());
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable throwable) {
                    System.out.println("Connection to Mqtt broker lost");
                }

                @Override
                public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
                    String message = new String(mqttMessage.getPayload());
                    System.out.println(message);
                    Map<String, String> map = messageUtil.getHumiAndTemp(message);
                    WeatherDto newWeather = new WeatherDto(map.get("temp"), map.get("humi"));
                    weatherService.save(newWeather);
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

                }
            });
            client.connect();
            client.subscribe(topic, 0);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void publisher(){
        try{
            MqttClient client = new MqttClient("tcp://broker.hivemq.com:1883", MqttClient.generateClientId());
            client.connect();
            MqttMessage message = new MqttMessage();
            message.setPayload("hello".getBytes());
            message.setQos(0);
            client.publish("topic/resp", message);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
