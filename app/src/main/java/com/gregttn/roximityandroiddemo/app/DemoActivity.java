package com.gregttn.roximityandroiddemo.app;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.roximity.ibeacon.IBeaconManager;
import com.roximity.sdk.Roximity;
import com.roximity.sdk.beacons.BeaconManager;
import com.roximity.sdk.integration.RoximityActivity;

public class DemoActivity extends RoximityActivity {

    public static final int RANGE_SCAN_PERIOD = 5000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        IBeaconManager iBeaconManager = IBeaconManager.getInstanceForApplication(this);
        iBeaconManager.setForegroundBetweenScanPeriod(RANGE_SCAN_PERIOD);
    }

    @Override
    public void beaconRangeUpdate(String range) {
        Log.i(getClass().getSimpleName(), range);
    }

    @Override
    public void messageFired(String message) {
        Log.i(getClass().getSimpleName(), message);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
