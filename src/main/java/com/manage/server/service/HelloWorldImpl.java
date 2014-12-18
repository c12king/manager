package com.manage.server.service;

/**
 *HelloWorld的实现类.
 */
public class HelloWorldImpl implements HelloWorld {
    public String sayHelloWorld(String name) {
       String helloWorld = "hello," + name;
       return helloWorld;
    }
}