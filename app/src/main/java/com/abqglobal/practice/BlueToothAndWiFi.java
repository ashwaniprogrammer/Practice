package com.abqglobal.practice;

import android.bluetooth.BluetoothAdapter;
import android.net.wifi.WifiManager;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.lang.invoke.ConstantCallSite;

public class BlueToothAndWiFi extends AppCompatActivity {

ConstraintLayout constraintLayout;
BluetoothAdapter bluetoothAdapter;
WifiManager wifiManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue_tooth_and_wi_fi);

        constraintLayout=findViewById(R.id.constraint);


        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();


        wifiManager=(WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);


        if(bluetoothAdapter.isEnabled())
        {
            Snackbar.make(constraintLayout,"BlueTooth is on",15000).setAction("Turn Off", new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    bluetoothAdapter.disable();
                    Toast.makeText(BlueToothAndWiFi.this, "BlueTooth Off", Toast.LENGTH_SHORT).show();

                }
            }).show();
        }

        else
        {
            Snackbar.make(constraintLayout,"BlueTooth Off",15000).setAction("Turn On", new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    bluetoothAdapter.enable();
                    Toast.makeText(BlueToothAndWiFi.this, "BlueTooth On", Toast.LENGTH_SHORT).show();
                }
            }).show();
        }

         if(wifiManager.isWifiEnabled())
         {
             Snackbar.make(constraintLayout,"WiFi On",15000).setAction("Turn Off", new View.OnClickListener() {
                 @Override
                 public void onClick(View v)
                 {
                    wifiManager.setWifiEnabled(false);
                     Toast.makeText(BlueToothAndWiFi.this, "WiFi Off", Toast.LENGTH_SHORT).show();
                 }
             }).show();
         }
         else
         {
             Snackbar.make(constraintLayout,"WiFi Off",15000).setAction("Turn On", new View.OnClickListener() {
                 @Override
                 public void onClick(View v)
                 {
                    wifiManager.setWifiEnabled(true);
                     Toast.makeText(BlueToothAndWiFi.this, "WiFi On", Toast.LENGTH_SHORT).show();
                 }
             }).show();
         }

    }
}
