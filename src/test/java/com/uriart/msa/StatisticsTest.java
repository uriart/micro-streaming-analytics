package com.uriart.msa;

import com.uriart.msa.consumer.entity.Statistics;
import com.uriart.msa.dto.Datapoint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class StatisticsTest {

    @Test
    public void testStatisticsCalculation() {
        Statistics statistics = new Statistics(initDatapointList());
        Assertions.assertNotNull(statistics);
        Assertions.assertNotNull(statistics.getTimeStamp());
        Assertions.assertEquals(statistics.getMedia(), 4.0);
        Assertions.assertEquals(statistics.getMediana(), 4.0);
        Assertions.assertEquals(statistics.getModa(), 0.0);
        Assertions.assertEquals(statistics.getCuartiles(), Arrays.asList(2, 4, 6));
        Assertions.assertEquals(statistics.getDesviacionTipica(), 2.8284271247461903);
        Assertions.assertEquals(statistics.getValorMaximo(), 8.0);
        Assertions.assertEquals(statistics.getValorMinimo(), 0.0);
    }

    private ArrayList<Datapoint> initDatapointList(){
        ArrayList<Datapoint> datapointsList = new ArrayList<>();
        for(int i=0 ; i<5 ; i++){
            Datapoint datapoint = new Datapoint();
            datapoint.setValue(i*2);
            datapointsList.add(datapoint);
        }
        return datapointsList;


    }
}
