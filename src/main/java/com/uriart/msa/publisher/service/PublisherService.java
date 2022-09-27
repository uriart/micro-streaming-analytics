package com.uriart.msa.publisher.service;

import com.uriart.msa.dto.Datastream;
import com.uriart.msa.publisher.Publisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PublisherService {

    @Autowired
    private Publisher publisher;

    public void sendData(Datastream event) {
        log.info("Sending data to RabbitMQ: " + event);
        this.publisher.sendDataToRabbitMQ(event);
    }
}
