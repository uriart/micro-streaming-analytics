package com.uriart.msa.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class Datastream implements Serializable {
    private String version;
    private ArrayList<Datastreams> datastreams;
}
