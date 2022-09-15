package com.uriart.msa.service;

import com.uriart.msa.dto.Event;
import com.uriart.msa.publisher.Publisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PublisherService {

    @Autowired
    private Publisher publisher;

    public void sendData(Event event) {
        log.info("Sending data to RabbitMQ: " + event);
        this.publisher.sendDataToRabbitMQ(event);
    }
}
