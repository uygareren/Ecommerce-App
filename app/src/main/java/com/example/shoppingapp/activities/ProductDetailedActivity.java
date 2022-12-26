package com.example.shoppingapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shoppingapp.R;
import com.example.shoppingapp.model.ProductsModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProductDetailedActivity extends AppCompatActivity {


    TextView quantity;
    int totalQuantity =1;
    int totalPrice = 0;

    ImageView detailedImg;
    TextView price,rating,description;
    Button addBtn;
    ImageView addItem,removeItem;

    ProductsModel productsModel = null;
    FirebaseFirestore firestore;
    FirebaseAuth auth;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detailed);

        firestore = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

        final Object object = getIntent().getSerializableExtra("detail");
        if(object instanceof ProductsModel){
            productsModel = (ProductsModel) object;
        }

        quantity = findViewById(R.id.quantity);
        detailedImg = findViewById(R.id.detailed_img);
        addItem = findViewById(R.id.add_item);
        removeItem = findViewById(R.id.remove_item);
        price = findViewById(R.id.detailed_price);
        rating = findViewById(R.id.detailed_rating);
        addBtn = findViewById(R.id.add_btn);

        if(productsModel!=null){
            Glide.with(getApplicationContext()).load(productsModel.getImg_url()).into(detailedImg);
            rating.setText(productsModel.getRating());
            price.setText("Price :TL"+productsModel.getPrice());

            totalPrice = productsModel.getPrice() * totalQuantity;

        }



        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(totalQuantity<10){
                    totalQuantity++;
                    quantity.setText(String.valueOf(totalQuantity));
                }
            }
        });

        removeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(totalQuantity>0){
                    totalQuantity--;
                    quantity.setText(String.valueOf(totalQuantity));
                }
            }
        });

    }


}