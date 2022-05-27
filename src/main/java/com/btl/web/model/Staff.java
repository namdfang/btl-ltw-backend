package com.btl.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "staff")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Staff implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "staff_code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_birth")
    private Date dob;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "wage")
    private String wage;

    @Column(name = "position")
    private String position;

    @ManyToOne
    @JoinColumn(name = "building_id", referencedColumnName = "id")
    private Building building;


}
