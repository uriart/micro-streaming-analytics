package com.uriart.msa.consumer.dao;

import com.uriart.msa.consumer.entity.Statistics;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StatisticsRespository extends MongoRepository<Statistics, String> {
}
