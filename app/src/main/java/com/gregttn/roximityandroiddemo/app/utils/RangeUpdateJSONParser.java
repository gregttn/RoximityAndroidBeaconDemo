package com.gregttn.roximityandroiddemo.app.utils;

import android.text.TextUtils;
import android.util.Log;

import com.gregttn.roximityandroiddemo.app.model.ProximityRange;
import com.gregttn.roximityandroiddemo.app.model.RangeUpdate;

import org.json.JSONException;
import org.json.JSONObject;

public class RangeUpdateJSONParser {
    public static final RangeUpdate EMPTY_RANGE = new RangeUpdate("", "", ProximityRange.UNKNOWN);
    public static final String PROXIMITY_KEY = "proximity";
    public static final String BEACON_ID_KEY = "id";
    public static final String BEACON_NAME_ID = "name";

    private final String TAG = getClass().getSimpleName();

    public RangeUpdate parse(String rangeJSON) {
        if (TextUtils.isEmpty(rangeJSON)) {
            return EMPTY_RANGE;
        }

        try {
            JSONObject rangeUpdate = new JSONObject(rangeJSON);
            int rangeId = rangeUpdate.getInt(PROXIMITY_KEY);
            String beaconId = rangeUpdate.getString(BEACON_ID_KEY);
            String beaconName = rangeUpdate.getString(BEACON_NAME_ID);

            return new RangeUpdate(beaconName, beaconId, ProximityRange.rangeForId(rangeId));
        } catch (JSONException e) {
            Log.d(TAG, "Could not parse rangeJSON: " + rangeJSON,e);

            return EMPTY_RANGE;
        }
    }
}
