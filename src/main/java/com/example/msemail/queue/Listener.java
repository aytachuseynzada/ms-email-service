package com.example.msemail.queue;

import com.example.msemail.client.TelecomClient;
import com.example.msemail.client.dto.SmsRequestDto;
import com.example.msemail.queue.dto.PosOrderRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;
@Component
@RequiredArgsConstructor
@Slf4j
public class Listener {
    private final ObjectMapper objectMapper;
    private final TelecomClient telecomClient;
    private final String SMS_TEXT= "Sizin pos terminal sifarisiniz ugurla yekunlasdi!";

    @RabbitListener(queues = "sms.queue")
    public void acceptSmsMessages(String message){
        log.info("ActionLog.acceptSmsMessages.start");
        var dto= objectMapper.readValue(message, PosOrderRequestDto.class);
        telecomClient.sendSms(new SmsRequestDto(dto.getCustomerPhoneNumber(), SMS_TEXT));
        log.info("ActionLog.acceptSmsMessages.end");
    }
}
