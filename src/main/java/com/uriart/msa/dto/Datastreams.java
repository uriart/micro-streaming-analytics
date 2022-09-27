package com.uriart.msa.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class Datastreams implements Serializable {
    private String id;
    private ArrayList<Datapoint> datapoints;
}
