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
public class EmployeeDTO implements Serializable {

    @JsonProperty("employee_code")
    private String employeeCode;

    @JsonProperty("name")
    private String employeeName;

    @JsonProperty("date_of_birth")
    private Date employeeDob;

    @JsonProperty("phone_number")
    private String employeePhoneNumber;

    @JsonProperty("company_id")
    private int companyId;

}
