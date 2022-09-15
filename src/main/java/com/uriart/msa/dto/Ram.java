package com.uriart.msa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Ram implements Serializable {
    private int current;
}
