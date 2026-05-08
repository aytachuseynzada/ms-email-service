package com.example.msemail.client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SmsRequestDto {
    private String phoneNumber;
    private String text;
}
