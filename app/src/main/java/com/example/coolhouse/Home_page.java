// Home_page.java

package com.example.coolhouse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Home_page extends Activity {

    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        textview=findViewById(R.id.textview1);
        // Your activity initialization code here
        textview.setOnClickListener(v -> {


            Toast.makeText(Home_page.this, "click", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(Home_page.this,Product_Details.class);

            startActivity(i);
        });
    }
}
