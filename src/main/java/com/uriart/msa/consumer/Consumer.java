package com.uriart.msa.consumer;

import com.uriart.msa.consumer.entity.Statistics;
import com.uriart.msa.consumer.service.StatisticsService;
import com.uriart.msa.dto.Datastream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    @Autowired
    private StatisticsService statisticsService;

    @RabbitListener(queues = {"${uriart.queue.name}"})
    public void recive(@Payload Datastream datastream) {
        log.info("Recived message: " + datastream);
        datastream.getDatastreams().forEach(data -> {
            statisticsService.storeData(new Statistics(data.getDatapoints()));
        });
    }
}
