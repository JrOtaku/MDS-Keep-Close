package com.example.keepcloseversion2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    Button Set_Up_Device_Button;
    Button Settings_Page_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchFrag(new DeviceSetUpPage());
        //switchFrag(new FirstFragment());
        //Set_Up_Device_Button = (Button) findViewById(R.id.set_up_button);
        //Settings_Page_Button = (Button) findViewById(R.id.notification_settings_button);

        //Set_Up_Device_Button.setOnClickListener(v -> {
        //    switchFrag(new DeviceSetUpPage());
            //Intent intent = new Intent(MainActivity.this, DeviceSetUpPage::class.java);
            //startActivity(intent);
        //});
        //Settings_Page_Button.setOnClickListener(v -> {
        //    switchFrag(new SettingsPage());
        //});
    }

    public boolean switchFrag (Fragment frag){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.fragment_container, frag);
        while(getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate();
        }
        fragmentTransaction.commit();
        return true;
    }

   }