package com.uriart.msa.consumer.entity;

import com.uriart.msa.dto.Device;
import com.uriart.msa.dto.Event;
import com.uriart.msa.dto.Ram;
import com.uriart.msa.consumer.utils.StatisticsUtils;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
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

    /** Create Statistics from Event **/
    public Statistics(Event event){
        List<Integer> ramUsageList = event.getDevice()
                                            .stream()
                                            .map(Device::getRam)
                                            .map(Ram::getCurrent)
                                            .sorted()
                                            .collect(Collectors.toList());

        this.timeStamp = LocalDateTime.now();
        this.media = StatisticsUtils.getMedia(ramUsageList);
        this.mediana = StatisticsUtils.getMediana(ramUsageList);
        this.moda = StatisticsUtils.getModa(ramUsageList);
        this.desviacionTipica = StatisticsUtils.getDesviacionTipica(ramUsageList);
        this.cuartiles = StatisticsUtils.getCuartiles(ramUsageList);
        this.valorMaximo = StatisticsUtils.getMax(ramUsageList);
        this.valorMinimo = StatisticsUtils.getMin(ramUsageList);
    }
}
