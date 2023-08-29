package com.avia.demo.model;

import com.avia.demo.enums.CargoType;
import com.avia.demo.enums.WeightUnit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    @JsonIgnore
    private Flight flight;
    private int weight;
    @Enumerated
    @Column(name = "weight_unit",columnDefinition = "smallint")
    private WeightUnit weightUnit;
    private int pieces;
    @Enumerated
    @Column(name = "cargo_type", columnDefinition = "smallint")
    private CargoType cargoType;

}
