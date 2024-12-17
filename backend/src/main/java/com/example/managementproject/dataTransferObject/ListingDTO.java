package com.example.managementproject.dataTransferObject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListingDTO {
    private String name;
    private String city;
    private String location;
    private Long categoryId;
    private String description;
    private String contactInfo;
    private String services;
}
