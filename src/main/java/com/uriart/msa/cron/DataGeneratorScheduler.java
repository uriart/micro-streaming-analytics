package com.uriart.msa.cron;

import com.uriart.msa.dto.Device;
import com.uriart.msa.dto.Event;
import com.uriart.msa.dto.Ram;
import com.uriart.msa.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
public class DataGeneratorScheduler {

    public static final String FIVE_SEC_PATTERN = "*/5 * * * * *";

    @Autowired
    private PublisherService publisherService;

    @Scheduled(cron = FIVE_SEC_PATTERN)
    public void scheduleTaskDataGenerator() {
        this.publisherService.sendData(this.randomEventGenerator());
    }

    private Event randomEventGenerator() {
        Event event = new Event();
        ArrayList<Device> deviceList = new ArrayList<>();
        Random random = new Random();
        for(int i=0 ; i<99 ; i++){
            Device device = new Device();
            device.setRam(new Ram(random.nextInt(100)));
            deviceList.add(device);
        }
        event.setDevice(deviceList);
        return event;
    }

}
