package com.example.msemail.queue.dto;

import com.example.msemail.queue.enums.PosType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PosOrderRequestDto {
    private Integer posCount;
    private PosType posType;
    private String customerName;
    private String customerPhoneNumber;

    @Override
    public String toString() {
        return "PosOrderRequestDto{" +
                "posCount=" + posCount +
                ", posType=" + posType +
                ", customerName='" + customerName + '\'' +
                ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                '}';
    }
}
