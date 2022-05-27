package com.btl.web.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuildingDTO implements Serializable {
                                
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String buildingName;

    @JsonProperty("address_in_building")
    private String addressBuilding;

    @JsonProperty("ground_in_area")
    private int groundArea;
}