package com.aaj.Persistence.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;
    private String brand;
    private Date purchaseDate;
    private Double purchasePrice;

    @Getter
    public enum VehicleType {
        CAR, TRUCK, MICRO_MOBILITY
    }
}
