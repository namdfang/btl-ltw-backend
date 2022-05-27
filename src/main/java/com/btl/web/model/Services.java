package com.btl.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "service")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Services implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "service_code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "unit_price")
    private double unitPrice;
}
