package com.example.msemail.service;

import com.example.msemail.client.AccountClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountClient accountClient;
    private final RedisService redisService;
    public String getBalance(String id) {
        var valueInRedis = redisService.getValue(id);
        if(valueInRedis != null){
            System.out.println("DATA FROM REDIS");
            return (String) valueInRedis;
        }
        var response = accountClient.getBalance();
        redisService.setValue(id,response,890000);
        System.out.println("DATA FROM API");
        return response;
    }
}
