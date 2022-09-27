package com.uriart.msa.consumer.entity;

import com.uriart.msa.consumer.utils.StatisticsUtils;
import com.uriart.msa.dto.Datapoint;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Data
@Document
public class Statistics {
    @Id
    private String id;
    private LocalDateTime timeStamp;
    private double media;
    private int mediana;
    private int moda;
    private double desviacionTipica;
    private List<Integer> cuartiles;
    private int valorMaximo;
    private int valorMinimo;

    /** Create Statistics from list of datapoints **/
    public Statistics(ArrayList<Datapoint> datapoints){
        List<Integer> values = datapoints.stream()
                                            .map(Datapoint::getValue)
                                            .sorted()
                                            .collect(Collectors.toList());

        //Get the timestamp if it exists on the datapoints. otherwise, we generate it
        Long longTimestamp = datapoints.stream()
                                        .map(Datapoint::getAt)
                                        .filter(Objects::nonNull)
                                        .findFirst()
                                        .orElse(new Date().getTime());

        this.timeStamp = LocalDateTime.ofInstant(
                                        Instant.ofEpochMilli(longTimestamp),
                                        TimeZone.getDefault().toZoneId());
        this.media = StatisticsUtils.getMedia(values);
        this.mediana = StatisticsUtils.getMediana(values);
        this.moda = StatisticsUtils.getModa(values);
        this.desviacionTipica = StatisticsUtils.getDesviacionTipica(values);
        this.cuartiles = StatisticsUtils.getCuartiles(values);
        this.valorMaximo = StatisticsUtils.getMax(values);
        this.valorMinimo = StatisticsUtils.getMin(values);
    }
}
