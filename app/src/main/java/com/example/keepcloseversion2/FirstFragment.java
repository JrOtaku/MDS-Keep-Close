package com.example.keepcloseversion2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.keepcloseversion2.databinding.DevicesetuppageBinding;
import com.example.keepcloseversion2.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    Button Set_Up_Device_Button;
    Button Settings_Page_Button;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        //NavController navController = Navigation.findNavController(view);
        {

            binding = FragmentFirstBinding.inflate(inflater, container, false);

            Set_Up_Device_Button = binding.setUpButton;
            Set_Up_Device_Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Navigation.findNavController(view).navigate(R.id.devicesetuppage);
                    System.out.println("here");
                }
            });



            Settings_Page_Button = binding.notificationSettingsButton;
            Settings_Page_Button.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.settings_page));


            return binding.getRoot();
        }

    }



}