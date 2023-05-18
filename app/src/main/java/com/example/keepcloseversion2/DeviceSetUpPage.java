package com.example.keepcloseversion2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Set;
import java.util.ArrayList;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
//import android.widget.AdapterView.OnClickListener;
import android.widget.TextView;
import android.content.Intent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import com.example.keepcloseversion2.databinding.DevicesetuppageBinding;

public class DeviceSetUpPage extends Fragment {
    Button back_button;
    Button search;
    DevicesetuppageBinding binding;
    private BluetoothAdapter myBluetooth = null;
    private Set pairedDevices;
    //public static final int PERMISSION_ASK = 1001;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = DevicesetuppageBinding.inflate(inflater, container, false);

        //start Bluetooth Code
        myBluetooth = BluetoothAdapter.getDefaultAdapter();
        if(myBluetooth == null){
            //show that the device has no bluetooth adapter
            Toast.makeText(getContext().getApplicationContext(), "Bluetooth Device Not Available", Toast.LENGTH_LONG.show());
            //finish apk???
            //finish();
        }
        else {
            if(myBluetooth.isEnabled()){

            }
            else{
                //ask user to turn bluetooth on
                Intent turnBluetoothOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(turnBluetoothOn,1);
            }
        }
        search = binding.search;
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pairedDevicesList();
            }
        });


        back_button = binding.back;

        back_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.FirstFragment);
            }
        });

        return binding.getRoot();
    }

    @RequiresPermission(value = "android.permission.BLUETOOTH_CONNECT")
    private void pairedDevicesList()
    {
        pairedDevices = myBluetooth.getBondedDevices();
        ArrayList list = new ArrayList();

        if (pairedDevices.size()>0)
        {
            BluetoothDevice bt;
            for(bt : pairedDevices)
            {
                list.add(bt.getName() + "\n" + bt.getAddress()); //Get the device's name and the address
            }
        }
        else
        {
            Toast.makeText(getContext().getApplicationContext(), "No Paired Bluetooth Devices Found.", Toast.LENGTH_LONG).show();
        }

        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, list);
        devicelist.setAdapter(adapter);
        devicelist.setOnItemClickListener(myListClickListener); //Method called when the device from the list is clicked
    }


    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.devicesetuppage);
//
//        back_button = (Button) findViewById(R.id.back);
//        back_button.setOnClickListener(v -> {
//            Intent intent = new Intent(DeviceSetUpPage.this, MainActivity.class);
//            startActivity(intent);
//        });
//    }
}
