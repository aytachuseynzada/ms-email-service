package com.example.msemail.client;

import com.example.msemail.client.dto.SmsRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="telecom-client", url="http://localhost:9092/sms")
public interface TelecomClient {
    @PostMapping
    @Async
    void sendSms(@RequestBody SmsRequestDto dto);
}
