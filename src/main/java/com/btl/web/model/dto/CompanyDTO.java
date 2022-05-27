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
public class CompanyDTO implements Serializable {
    
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String companyName;

    @JsonProperty("tax_number")
    private String taxNumber;

    @JsonProperty("authorized_capital")
    private double authorizedCapital;

    @JsonProperty("field_of_operation")
    private String fieldOfOperation;

    @JsonProperty("address_in_building")
    private String addressInBuilding;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("ground_in_area")
    private int groundInArea;

}
