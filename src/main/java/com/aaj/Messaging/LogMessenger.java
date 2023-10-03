package com.aaj.Messaging;

import com.aaj.Persistence.Model.VehicleLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class LogMessenger {

    private final List<VehicleLog> carCache = new LinkedList<>();
    private final List<VehicleLog> truckCache = new LinkedList<>();
    private final List<VehicleLog> microCache = new LinkedList<>();
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendCarMessage(VehicleLog message) {
        jmsTemplate.send("carQueue", session -> session.createObjectMessage(message));
    }

    public void sendTruckMessage(VehicleLog message) {
        jmsTemplate.send("truckQueue", session -> session.createObjectMessage(message));
    }

    public void sendMicroMessage(VehicleLog message) {
        jmsTemplate.send("microQueue", session -> session.createObjectMessage(message));
    }

    @JmsListener(destination = "carQueue")
    public void receiveCarMessage(VehicleLog log) {
        carCache.add(log);
    }

    @JmsListener(destination = "truckQueue")
    public void receiveTruckMessage(VehicleLog log) {
        truckCache.add(log);
    }

    @JmsListener(destination = "microQueue")
    public void receiveMicroMessage(VehicleLog log) {
        microCache.add(log);
    }

    public List<VehicleLog> drainCarCache() {
        List<VehicleLog> copy = new LinkedList<>(carCache);
        carCache.clear();
        return copy;
    }

    public List<VehicleLog> drainTruckCache() {
        List<VehicleLog> copy = new LinkedList<>(truckCache);
        truckCache.clear();
        return copy;
    }

    public List<VehicleLog> drainMicroCache() {
        List<VehicleLog> copy = new LinkedList<>(microCache);
        microCache.clear();
        return copy;
    }
}