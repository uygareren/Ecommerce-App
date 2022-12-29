package com.example.shoppingapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.shoppingapp.R;
import com.example.shoppingapp.model.MyBagModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlacedOrderActivity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placed_order);

        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        List<MyBagModel> list = (ArrayList<MyBagModel>) getIntent().getSerializableExtra("itemlist");

        if(list != null && list.size() > 0){
            for(MyBagModel model : list){

                final HashMap<String,Object> BagMap = new HashMap<>();

                BagMap.put("productİmage",model.getImg_url());
                BagMap.put("productName",model.getProductName());
                BagMap.put("productPrice",model.getProductPrice());
                BagMap.put("totalQuantity",model.getTotalQuantity());
                BagMap.put("totalPrice",model.getTotalPrice());

                        firestore.collection("MyOrder").add(BagMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentReference> task) {
                                Toast.makeText(PlacedOrderActivity.this,"Your order hass been placed",Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });

            }
        }
    }
}