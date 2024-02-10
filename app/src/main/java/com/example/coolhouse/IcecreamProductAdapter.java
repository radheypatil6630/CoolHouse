package com.example.coolhouse;






import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.coolhouse.R;

import java.util.ArrayList;

public class IcecreamProductAdapter extends RecyclerView.Adapter< IcecreamProductAdapter.MyViewHolder>
{
    //taking array for images and its names
    Context context;
    ArrayList<ProductList> list;

    //constructor calling
    public IcecreamProductAdapter(Context context, ArrayList<ProductList> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // calling recycleview for display array of images

        context = parent.getContext();
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ProductList Product_List=list.get(position);

        // passes the object of productList class in below methods

        // holder.imageUrl.setImageResource(Product_List.getImageUrl());
        if (Product_List. getimageUrl() != null && !Product_List.getimageUrl().isEmpty()) {
            // Use Glide to load images from URLs using generated GlideApp class

            //Log.d("Image URL", "URL: " + Product_List.getimageUrl());

            Log.d("MysAyurveda", "Data: " + Product_List.getimageUrl() + " " + Product_List.getProductName() + " " + Product_List.getprice());

            Glide.with(context)
                    .load(Product_List.getimageUrl())
                    .into(holder.imageUrl);
            holder.ProductName.setText(Product_List.getProductName());
            holder.price.setText(Product_List.getprice());


        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        //callinng id's which is present in activity_recycleview.xml file
        ImageView imageUrl;
        TextView ProductName,ProductDetail,price;


        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            imageUrl=itemView.findViewById(R.id.image);
            ProductName=itemView.findViewById(R.id.product_name);
            price=itemView.findViewById(R.id.product_price);


        }
    }
}






