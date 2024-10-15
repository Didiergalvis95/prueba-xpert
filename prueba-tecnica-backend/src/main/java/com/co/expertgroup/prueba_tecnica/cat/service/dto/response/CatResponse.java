package com.co.expertgroup.prueba_tecnica.cat.service.dto.response;

import com.co.expertgroup.prueba_tecnica.cat.service.dto.WeightDto;
import lombok.Data;

@Data
public class CatResponse {
    private WeightResponse weight;
    private String id;
    private String name;
    private String temperament;
    private String origin;
    private String countryCodes;
    private String countryCode;
    private String description;
    private String lifeSpan;
    private int indoor;
    private int lap;
    private String altNames;
    private int adaptability;
    private int affectionLevel;
    private int childFriendly;
    private int dogFriendly;
    private int energyLevel;
    private int grooming;
    private int healthIssues;
    private int intelligence;
    private int sheddingLevel;
    private int socialNeeds;
    private int strangerFriendly;
    private int vocalisation;
    private int experimental;
    private int hairless;
    private int natural;
    private int rare;
    private int rex;
    private int suppressedTail;
    private int shortLegs;
    private String wikipediaUrl;
    private int hypoallergenic;
    private String referenceImageId;
}
