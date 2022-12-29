package com.example.shoppingapp.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.shoppingapp.R;
import com.example.shoppingapp.activities.ProfileUpdate;
import com.example.shoppingapp.databinding.FragmentProfileBinding;

import org.w3c.dom.Text;

public class ProfileFragment extends Fragment {

    TextView name, surname, phone, email;
    Button ProfileUpdateBtn, ProfileSettingsBtn, LogoutBtn;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        name = v.findViewById(R.id.name);
        surname = v.findViewById(R.id.surname);
        phone = v.findViewById(R.id.phone);
        email = v.findViewById(R.id.email);
        ProfileUpdateBtn = v.findViewById(R.id.profileUpdateBtn);
        ProfileSettingsBtn = v.findViewById(R.id.userSettingsBtn);
        LogoutBtn = v.findViewById(R.id.logoutBtn);


        ProfileUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProfileUpdate.class);
                startActivity(intent);
            }
        });




    return v;
    }


}