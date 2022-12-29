package com.example.shoppingapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.shoppingapp.R;
import com.example.shoppingapp.ui.profile.ProfileFragment;

public class ProfileUpdate extends AppCompatActivity {

    TextView UptName, UptSurname, UptPhone, UptEmail;
    Button UpdateBtn;

    FragmentManager manager;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_update);

        UptName = findViewById(R.id.profile_name);
        UptSurname = findViewById(R.id.profile_surname);
        UptPhone = findViewById(R.id.profile_phonenumber);
        UptEmail = findViewById(R.id.profile_email);
        UpdateBtn = findViewById(R.id.update);


        UpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = UptName.getText().toString();
                String surname = UptSurname.getText().toString();
                String phone = UptPhone.getText().toString();
                String email = UptEmail.getText().toString();


            }
        });

    }
}