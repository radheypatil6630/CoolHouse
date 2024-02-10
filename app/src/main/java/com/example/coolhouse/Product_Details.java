package com.example.coolhouse;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.coolhouse.ProductList;
import com.example.coolhouse.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Logger;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import java.util.ArrayList;
import java.util.List;

public class Product_Details extends AppCompatActivity {

    private RecyclerView recyclerView;
    DatabaseReference database;
    IcecreamProductAdapter  IcecreamProductAdapter;
    ArrayList<ProductList> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        // database for accessing images and its url
        recyclerView=findViewById(R.id.recyclerView);
        database= FirebaseDatabase.getInstance().getReference("icecream");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        list=new ArrayList<>();
        IcecreamProductAdapter=new IcecreamProductAdapter(Product_Details.this,list);
        recyclerView.setAdapter(IcecreamProductAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list.clear();

                for (DataSnapshot categorySnapshot : snapshot.getChildren()) {
                    for (DataSnapshot dataSnapshot : categorySnapshot.getChildren()) {
                        //Images and its name are displayed


                        ProductList ProductList = dataSnapshot.getValue(ProductList.class);
                        list.add(ProductList);


                    }
                }
                if (IcecreamProductAdapter != null) {
                    IcecreamProductAdapter.notifyDataSetChanged();
                }
                //  IcecreamProductAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //handle error
                Toast.makeText(Product_Details.this, "Database Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });




    }
}






