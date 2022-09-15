package com.uriart.msa.consumer;

import com.uriart.msa.Statistics;
import com.uriart.msa.dto.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    @RabbitListener(queues = {"${uriart.queue.name}"})
    public void recive(@Payload Event event) {
        log.info("Recived message: " + event);
        log.info("Generated statistic data: " + new Statistics(event));
    }
}
