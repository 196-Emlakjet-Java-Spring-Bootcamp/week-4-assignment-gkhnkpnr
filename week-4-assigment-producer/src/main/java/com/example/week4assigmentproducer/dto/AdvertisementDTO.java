package com.example.week4assigmentproducer.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AdvertisementDTO implements Serializable {
    private String title;
    private String description;
}
