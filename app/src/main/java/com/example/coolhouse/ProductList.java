package com.example.coolhouse;

public class ProductList {

    //create variable
    private String imageUrl;
    private String price;
    private String ProductName;


    //constructor
    public ProductList() {
        // Required default constructor for Firebase
    }


    //getter and setter pr
    public String getimageUrl() {
        return imageUrl;
    }

    public void setimageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getprice() {
        return price;
    }

    public void setprice(String price) {
        this.price = price;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }



//    public productList get(int position) {
//    }
}
