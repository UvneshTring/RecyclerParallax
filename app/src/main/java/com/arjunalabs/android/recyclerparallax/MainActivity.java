package com.arjunalabs.android.recyclerparallax;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    ParallaxRecyclerView recyclerView;
    ArrayList<ParallaxModel> parallaxModelArrayList;
    static AdRequest adRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ad data
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        MobileAds.setRequestConfiguration(
                new RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList("ABCDEF012345"))
                        .build());
        adRequest = new AdRequest.Builder().build();

        // create dummy data
        parallaxModelArrayList = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            ParallaxModel parallaxModel = new ParallaxModel();
            parallaxModel.setTitle("Row" + i);
            parallaxModelArrayList.add(parallaxModel);
        }

        // prepare the recyclerview
        recyclerView = (ParallaxRecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        // do the adapter
        ParallaxAdapter parallaxAdapter = new ParallaxAdapter(parallaxModelArrayList, recyclerView.getHeight());
        // bind the adapter with the recyclerview
        recyclerView.setAdapter(parallaxAdapter);

        recyclerView.setupParallax(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
