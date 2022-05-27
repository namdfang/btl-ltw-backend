package com.btl.web.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StaffDTO implements Serializable {

    @JsonProperty("staff_code")
    private String code;

    @JsonProperty("name")
    private String name;

    @JsonProperty("date_of_birth")
    private Date dob;

    @JsonProperty("address")
    private String address;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("wage")
    private String wage;

    @JsonProperty("position")
    private String position;
}
