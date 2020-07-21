package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DemoListener {

    private final DemoService demoService;

    @RabbitListener(id = "demoListener", queuesToDeclare = @Queue(value = "myQueue"))
    public void listen(String message) {
        demoService.doPerform(message);
    }
}
