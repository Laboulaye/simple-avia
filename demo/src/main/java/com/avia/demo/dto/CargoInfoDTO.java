package com.avia.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargoInfoDTO {

    float cargoWeightKg;
    float baggageWeightKg;
    float totalWeightKg;
}
