package com.btl.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "building")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Building implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String buildingName;

    @Column(name = "address_in_building")
    private String addressBuilding;

    @Column(name = "ground_area")
    private int groundArea;

    @OneToMany(mappedBy = "building")
    private List<Staff> staffs;
    private List<Company> companies;
}