package com.gregttn.roximityandroiddemo.app;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.gregttn.roximityandroiddemo.app.model.RangeUpdate;
import com.gregttn.roximityandroiddemo.app.utils.RangeUpdateJSONParser;
import com.roximity.ibeacon.IBeaconManager;
import com.roximity.sdk.integration.RoximityActivity;

public class DemoActivity extends RoximityActivity {
    public static final int RANGE_SCAN_PERIOD = 5000;
    private final String TAG = getClass().getSimpleName();

    private RangeUpdateJSONParser rangeUpdateJSONParser = new RangeUpdateJSONParser();

    private TextView beaconIdTextView;
    private TextView beaconNameTextView;
    private TextView rangeTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        this.beaconIdTextView = (TextView) findViewById(R.id.beaconIdTextView);
        this.beaconNameTextView = (TextView) findViewById(R.id.beaconNameTextView);
        this.rangeTextView = (TextView) findViewById(R.id.rangeTextView);

        IBeaconManager iBeaconManager = IBeaconManager.getInstanceForApplication(this);
        iBeaconManager.setForegroundBetweenScanPeriod(RANGE_SCAN_PERIOD);
    }

    private void updateDisplay(RangeUpdate rangeUpdate) {
        this.beaconIdTextView.setText(rangeUpdate.getBeaconId());
        this.beaconNameTextView.setText(rangeUpdate.getBeaconName());
        this.rangeTextView.setText(rangeUpdate.getRange().getName());
        this.rangeTextView.setBackgroundColor(rangeUpdate.getRange().getDisplayColor());
    }

    @Override
    public void beaconRangeUpdate(String range) {
        RangeUpdate rangeUpdate = rangeUpdateJSONParser.parse(range);
        updateDisplay(rangeUpdate);

        Log.i(TAG, rangeUpdate.toString());
    }

    @Override
    public void messageFired(String message) {
        Log.i(TAG, message);
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
