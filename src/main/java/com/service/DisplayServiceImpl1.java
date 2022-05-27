package com.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DisplayServiceImpl1 implements DisplayService {
    @Override
    public void display(String msg) {
        log.info("Displaying from the class {} the message {}", this.getClass().getName(), msg);
    }
}
