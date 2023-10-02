package com.aaj.Persistence;

import com.aaj.Persistence.Model.VehicleLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleLogRepository extends JpaRepository<VehicleLog, Long> {
    List<VehicleLog> findByBrandAndVehicleType(String brand, VehicleLog.VehicleType vehicleType);
}
