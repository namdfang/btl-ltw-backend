package com.btl.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "company")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String companyName;

    @Column(name = "tax_number")
    private String taxNumber;

    @Column(name = "authorized_capital")
    private double authorizedCapital;

    @Column(name = "field_of_operation")
    private String fieldOfOperation;

    @Column(name = "address_in_building")
    private String addressInBuilding;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "ground_in_area")
    private int groundInArea;

    @OneToMany(mappedBy = "company")
    private List<Employee> employees;
    
    @ManyToOne
    @JoinColumn(name = "building_id", referencedColumnName = "id")
    private Building building;
}
