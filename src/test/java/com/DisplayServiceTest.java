package com;

import com.service.DisplayService;
import com.service.DisplayServiceImpl1;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class DisplayServiceTest {
    @Test
    void testDisplayServiceImpl1() {
        DisplayService displayService = new DisplayServiceImpl1();
        displayService.display("Hello");
    }

    @Test
    void testDisplayServiceImpl2() {
        DisplayService displayService = new DisplayService() {
            @Override
            public void display(String msg) {
                log.info("Displaying from the class {} the message {}", this.getClass().getName(), msg);
            }
        };
        displayService.display("Hello 2!");
    }

    @Test
    void testDisplayServiceImpl3() {
        DisplayService d = msg -> log.info("Displaying from the class {} the message {}", this.getClass().getName(), msg);
        d.display("Hello 3!");
    }
}
