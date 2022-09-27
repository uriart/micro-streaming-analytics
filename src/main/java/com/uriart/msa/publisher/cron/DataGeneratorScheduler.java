package com.uriart.msa.publisher.cron;

import com.uriart.msa.dto.Datapoint;
import com.uriart.msa.dto.Datastream;
import com.uriart.msa.dto.Datastreams;
import com.uriart.msa.publisher.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@Component
public class DataGeneratorScheduler {

    public static final String FIVE_SEC_PATTERN = "*/5 * * * * *";
    public static final String RAM_ID = "ram";
    public static final String CPU_ID = "cpu";
    public static final String DATASTREAM_VERSION = "1.0.0";

    @Autowired
    private PublisherService publisherService;

    @Scheduled(cron = FIVE_SEC_PATTERN)
    public void scheduleTaskDataGenerator() {
        this.publisherService.sendData(this.randomDatastreamGenerator());
    }

    private Datastream randomDatastreamGenerator() {

        ArrayList<Datastreams> datastreamsList = new ArrayList<>();
        datastreamsList.add(initDatastreams(RAM_ID));
        datastreamsList.add(initDatastreams(CPU_ID));

        Datastream datastream = new Datastream();
        datastream.setDatastreams(datastreamsList);
        datastream.setVersion(DATASTREAM_VERSION);

        return datastream;
    }

    private Datastreams initDatastreams(String datastreamId){
        ArrayList<Datapoint> datapointsList = new ArrayList<>();
        Random random = new Random();
        Date date = new Date();

        for(int i=0 ; i<99 ; i++){
            Datapoint datapoint = new Datapoint();
            datapoint.setValue(random.nextInt(100));
            datapoint.setAt(date.getTime());
            datapointsList.add(datapoint);
        }

        Datastreams datastreams = new Datastreams();
        datastreams.setDatapoints(datapointsList);
        datastreams.setId(datastreamId);

        return datastreams;
    }

}
