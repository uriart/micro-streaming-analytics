package com.uriart.msa.consumer.utils;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.IntStream;

@Component
public class StatisticsUtils {

    public static int getMax(List<Integer> ramUsageList){
        return Collections.max(ramUsageList);
    }

    public static int getMin(List<Integer> ramUsageList){
        return Collections.min(ramUsageList);
    }

    public static double getMedia(List<Integer> ramUsageList){
        return ramUsageList.stream()
                .mapToDouble(Integer::doubleValue).sum() / ramUsageList.size();
    }

    public static int getMediana(List<Integer> ramUsageList){
        int mediana;
        int middle = ramUsageList.size() / 2;
        if (ramUsageList.size() % 2 == 0) {
            mediana = (ramUsageList.get(middle - 1) + ramUsageList.get(middle)) / 2;
        } else {
            mediana = ramUsageList.get(middle);
        }
        return mediana;
    }

    public static int getModa(List<Integer> ramUsageList){
        int maxFrequency = 0;
        int moda = 0;
        for(int i=0 ; i<ramUsageList.size() ; i++){
            int currentFrequency = Collections.frequency(ramUsageList, ramUsageList.get(i));
            if(currentFrequency > maxFrequency){
                moda = ramUsageList.get(i);
                maxFrequency = currentFrequency;
            }
        }
        return moda;
    }

    public static double getDesviacionTipica(List<Integer> ramUsageList){
        Set<Integer> noDuplicates = new HashSet<>(ramUsageList);
        List<Integer> uniqueData = new ArrayList<>(noDuplicates);
        List<Integer> frequenciaAbsoluta = new ArrayList<>();
        for (Integer index : uniqueData) {
            frequenciaAbsoluta.add(Collections.frequency(ramUsageList, index));
        }
        double sumatorio = IntStream.range(0, uniqueData.size())
                .mapToDouble(i -> Math.pow(uniqueData.get(i),2) * frequenciaAbsoluta.get(i)).sum();
        double varianza = sumatorio / ramUsageList.size() - Math.pow(getMedia(ramUsageList), 2);
        return Math.sqrt(varianza);
    }

    public static List<Integer> getCuartiles(List<Integer> ramUsageList){
        List<Integer> quartiles = new ArrayList<>();
        for(int i=25 ; i<100 ; i += 25){
            double indicePercentil = ((double)i / 100) * ramUsageList.size();
            quartiles.add(ramUsageList.get((int)indicePercentil));
        }
        return quartiles;
    }


}
