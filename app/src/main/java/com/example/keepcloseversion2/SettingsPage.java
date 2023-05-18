package com.example.keepcloseversion2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.keepcloseversion2.databinding.SettingsPageBinding;

import java.util.Set;

public class SettingsPage extends Fragment {
    Button back_button;
    SettingsPageBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = SettingsPageBinding.inflate(inflater, container, false);
        back_button = binding.back;
        //back_button.setOnClickListener();
        return binding.getRoot();

    }

    //@Override
    //protected void onCreate(Bundle savedInstanceState) {
    //    super.onCreate(savedInstanceState);
    //    setContentView(R.layout.settings_page);
    //    back_button = (Button) findViewById(R.id.back);
    //    back_button.setOnClickListener(v -> {
    //        Intent intent = new Intent(SettingsPage.this, MainActivity.class);
    //        startActivity(intent);
    //    });
//    }
}
