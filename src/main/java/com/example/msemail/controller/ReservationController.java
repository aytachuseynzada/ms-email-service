package com.example.msemail.controller;

import com.example.msemail.client.AccountClient;
import com.example.msemail.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final AccountService accountService;
    @GetMapping("/{id}")
    public String getBalance(String id){
        return accountService.getBalance(id);
    }

}
