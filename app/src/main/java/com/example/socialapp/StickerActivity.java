//reference
//https://www.youtube.com/watch?v=ENK4ONrRm8s&list=PLam6bY5NszYOhXkY7jOS4EQAKcQwkXrp4
package com.example.socialapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StickerActivity extends AppCompatActivity {
    String firebaseUrl = "https://console.firebase.google.com/project/socialapp-c601d/database/socialapp-c601d-default-rtdb/data/~2F";
    Button changePictureBtn;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticker);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");


        changePictureBtn = findViewById(R.id.changePictureBtn);
        imageView = findViewById(R.id.imageView);
        //in the layout xml file, this imageView is loaded with ic_profile
        //app:srcCompat="@drawable/ic_profile"

        String uri = "@drawable/ic_run";

        changePictureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    int imageResource = getResources().getIdentifier(uri, null, getPackageName());
                    Drawable res = AppCompatResources.getDrawable(StickerActivity.this, imageResource);
                    imageView.setImageDrawable(res);
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(), "Failed to show sticker", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}