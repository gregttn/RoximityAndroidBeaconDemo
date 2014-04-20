package com.gregttn.roximityandroiddemo.app.model;

public class RangeUpdate {
    private final String beaconName;
    private final String beaconId;
    private final ProximityRange range;

    public RangeUpdate(String beaconName, String beaconId, ProximityRange range) {
        this.beaconName = beaconName;
        this.beaconId = beaconId;
        this.range = range;
    }

    public String getBeaconName() {
        return beaconName;
    }

    public String getBeaconId() {
        return beaconId;
    }

    public ProximityRange getRange() {
        return range;
    }

    @Override
    public String toString() {
        return "RangeUpdate {" +
                "beaconName='" + beaconName + '\'' +
                ", beaconId='" + beaconId + '\'' +
                ", range=" + range +
                '}';
    }
}
