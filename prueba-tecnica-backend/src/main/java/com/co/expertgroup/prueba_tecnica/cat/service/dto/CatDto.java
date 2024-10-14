package com.co.expertgroup.prueba_tecnica.cat.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CatDto {
    private WeightDto weight;
    private String id;
    private String name;
    private String temperament;
    private String origin;
    @JsonProperty("country_codes")
    private String countryCodes;
    @JsonProperty("country_code")
    private String countryCode;
    private String description;
    @JsonProperty("life_span")
    private String lifeSpan;
    private int indoor;
    private int lap;
    @JsonProperty("alt_names")
    private String altNames;
    private int adaptability;
    @JsonProperty("affection_level")
    private int affectionLevel;
    @JsonProperty("child_friendly")
    private int childFriendly;
    @JsonProperty("dog_friendly")
    private int dogFriendly;
    @JsonProperty("energy_level")
    private int energyLevel;
    private int grooming;
    @JsonProperty("health_issues")
    private int healthIssues;
    private int intelligence;
    @JsonProperty("shedding_level")
    private int sheddingLevel;
    @JsonProperty("social_needs")
    private int socialNeeds;
    @JsonProperty("stranger_friendly")
    private int strangerFriendly;
    private int vocalisation;
    private int experimental;
    private int hairless;
    private int natural;
    private int rare;
    private int rex;
    @JsonProperty("suppressed_tail")
    private int suppressedTail;
    @JsonProperty("short_legs")
    private int shortLegs;
    @JsonProperty("wikipedia_url")
    private String wikipediaUrl;
    @JsonProperty("hypoallergenic")
    private int hypoallergenic;
    @JsonProperty("reference_image_id")
    private String referenceImageId;
}
