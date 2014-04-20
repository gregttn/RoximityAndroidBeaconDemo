package com.gregttn.roximityandroiddemo.app.model;

import com.roximity.ibeacon.models.IBeacon;

public enum ProximityRange {
    IMMEDIATE(IBeacon.PROXIMITY_IMMEDIATE, "Immediate"),
    NEAR(IBeacon.PROXIMITY_NEAR, "Near"),
    FAR(IBeacon.PROXIMITY_FAR, "Far"),
    UNKNOWN(IBeacon.PROXIMITY_UNKNOWN, "Unknown");

    private int roximityId;
    private String name;

    private ProximityRange(int roximityId, String name) {
        this.name = name;
        this.roximityId = roximityId;
    }

    public static ProximityRange rangeForId(int id) {
        for (ProximityRange range : values()) {
            if(range.roximityId == id) {
                return range;
            }
        }

        throw new IllegalArgumentException("No range exists for id: " + id);
    }

    @Override
    public String toString() {
        return "ProximityRange {" +
                "roximityId=" + roximityId +
                ", name='" + name + '\'' +
                '}';
    }
}
