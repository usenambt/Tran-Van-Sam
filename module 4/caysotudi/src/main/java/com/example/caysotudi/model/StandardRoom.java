package com.example.caysotudi.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class StandardRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int standardRoomId;
    private String standardRoomName;
    @OneToMany(mappedBy="standardRoom")
    List<Service> serviceList;

    public StandardRoom() {
    }

    public StandardRoom(int standardRoomId, String standardRoomName, List<Service> serviceList) {
        this.standardRoomId = standardRoomId;
        this.standardRoomName = standardRoomName;
        this.serviceList = serviceList;
    }

    public int getStandardRoomId() {
        return standardRoomId;
    }

    public void setStandardRoomId(int standardRoomId) {
        this.standardRoomId = standardRoomId;
    }

    public String getStandardRoomName() {
        return standardRoomName;
    }

    public void setStandardRoomName(String standardRoomName) {
        this.standardRoomName = standardRoomName;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }
}
