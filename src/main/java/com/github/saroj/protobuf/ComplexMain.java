package com.github.saroj.protobuf;

import example.complex.Complex.ComplexMessage;
import example.complex.Complex.DummyMessage;

import java.util.Arrays;

public class ComplexMain {
    public static void main(String[] args) {

        ComplexMessage.Builder builder = ComplexMessage.newBuilder();
        builder.setOneDummy(getDummyMeesage(1, "First Dummy"));

        builder.addMultipleDummy(getDummyMeesage(2, "Second Dummy"));
        builder.addMultipleDummy(getDummyMeesage(3, "Third Dummy"));
        builder.addMultipleDummy(getDummyMeesage(4, "Fourth Dummy"));

        builder.addAllMultipleDummy(Arrays.asList(getDummyMeesage(5, "Fifth Dummy"),
                getDummyMeesage(6, "Sixth Dummy"),
                getDummyMeesage(7, "Seventh Dummy")));

        ComplexMessage complexMessage = builder.build();

        System.out.println(complexMessage);
    }

    private static DummyMessage getDummyMeesage(int id, String name) {
        DummyMessage.Builder builder = DummyMessage.newBuilder();
        builder.setId(id).setName(name);
        return builder.build();
    }
}
