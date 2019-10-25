package com.github.saroj.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.simple.Simple;

public class ProtoToJsonMain {
    public static void main(String[] args) {
        System.out.println("Hello World!!!");
        Simple.SimpleMessage.Builder builder = Simple.SimpleMessage.newBuilder();
        builder.setId(42).setIsSimple(Boolean.TRUE).setName("Some Name");
        builder.addSimpleList(1).addSimpleList(2).addSimpleList(3);
        Simple.SimpleMessage simpleMessage = builder.build();

        try {
            String stringMessage = JsonFormat.printer().print(simpleMessage);
            System.out.println(stringMessage);


            Simple.SimpleMessage.Builder builder2 = Simple.SimpleMessage.newBuilder();
            JsonFormat.parser().merge(stringMessage, builder2);
            System.out.println(builder2.build().toString());

        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}
