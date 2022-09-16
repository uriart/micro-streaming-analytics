package com.uriart.msa.consumer.service;

import com.uriart.msa.consumer.dao.StatisticsRespository;
import com.uriart.msa.consumer.entity.Statistics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StatisticsService {

    @Autowired
    private StatisticsRespository statisticsRespository;

    public void storeData(Statistics statistics){
        log.info("Generated statistic data: " + statistics);
        statisticsRespository.insert(statistics);
    }
}
