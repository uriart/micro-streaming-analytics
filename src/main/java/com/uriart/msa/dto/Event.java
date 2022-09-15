package com.uriart.msa.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class Event implements Serializable {

    private long id;
    private ArrayList<Device> device;

}
