package com.gregttn.roximityandroiddemo.app.model;

import android.graphics.Color;

import com.roximity.ibeacon.models.IBeacon;

public enum ProximityRange {
    IMMEDIATE(IBeacon.PROXIMITY_IMMEDIATE, "Immediate", Color.GREEN),
    NEAR(IBeacon.PROXIMITY_NEAR, "Near", Color.YELLOW),
    FAR(IBeacon.PROXIMITY_FAR, "Far", Color.RED),
    UNKNOWN(IBeacon.PROXIMITY_UNKNOWN, "Unknown", Color.GRAY);

    private int roximityId;
    private String name;
    private int displayColor;

    private ProximityRange(int roximityId, String name, int displayColor) {
        this.name = name;
        this.roximityId = roximityId;
        this.displayColor = displayColor;
    }

    public static ProximityRange rangeForId(int id) {
        for (ProximityRange range : values()) {
            if(range.roximityId == id) {
                return range;
            }
        }

        throw new IllegalArgumentException("No range exists for id: " + id);
    }

    public String getName() {
        return name;
    }


    public int getDisplayColor() {
        return displayColor;
    }

    @Override
    public String toString() {
        return "ProximityRange {" +
                "roximityId=" + roximityId +
                ", name='" + name + '\'' +
                '}';
    }
}
