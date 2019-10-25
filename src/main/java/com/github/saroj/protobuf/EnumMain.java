package com.github.saroj.protobuf;

import example.enumerations.EnumExample;
import example.enumerations.EnumExample.EnumMessage;

public class EnumMain {
    public static void main(String[] args) {
        System.out.println("Enum Example");
        EnumMessage.Builder builder = EnumMessage.newBuilder();
        builder.setId(345);
        builder.setDayOfTheWeek(EnumExample.DayOfTheWeek.MONDAY);
        EnumMessage enumMessage = builder.build();
        System.out.println(enumMessage);
    }
}
