package com.uriart.msa.cron;

import com.uriart.msa.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DataGeneratorScheduler {

    public static final String FIVE_SEC_PATTERN = "*/5 * * * * *";

    @Autowired
    private PublisherService publisher;

    @Scheduled(cron = FIVE_SEC_PATTERN)
    public void scheduleTaskDataGenerator() {
        this.publisher.sendData("data aleatorio");
    }
}
