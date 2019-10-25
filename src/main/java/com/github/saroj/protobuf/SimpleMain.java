package com.github.saroj.protobuf;

import example.simple.Simple;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SimpleMain {
    public static void main(String[] args) {
        System.out.println("Hello World!!!");
        Simple.SimpleMessage.Builder builder = Simple.SimpleMessage.newBuilder();
        builder.setId(42).setIsSimple(Boolean.TRUE).setName("Some Name");
        builder.addSimpleList(1).addSimpleList(2).addSimpleList(3);

        Simple.SimpleMessage simpleMessage = builder.build();

        System.out.println(simpleMessage);
        System.out.println("===========");


        try {
            FileOutputStream fileOutputStream = new FileOutputStream("simple_message.bin");
            simpleMessage.writeTo(fileOutputStream);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //byte[] bytesArray = simpleMessage.toByteArray();

        try {
            System.out.println("Reading from file");
            FileInputStream fileInputStream = new FileInputStream("simple_message.bin");
            Simple.SimpleMessage simpleMessageFromFile = Simple.SimpleMessage.parseFrom(fileInputStream);
            System.out.println(simpleMessageFromFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
