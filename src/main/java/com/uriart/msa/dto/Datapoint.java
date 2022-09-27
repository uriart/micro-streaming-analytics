package com.uriart.msa.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Datapoint implements Serializable {
    private Long at;
    private int value;
}
