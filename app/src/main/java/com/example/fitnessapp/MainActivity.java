package com.example.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseMessaging.getInstance().subscribeToTopic("notification");



        Toolbar toolbar=findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);


        button1=findViewById(R.id.startex1);
        button2=findViewById(R.id.startex2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, SecondActivity2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Integer id = item.getItemId();
        if (id == R.id.id_privacy){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.freeprivacypolicy.com/live/3d370cae-9ec2-49d7-90b8-453bd4345ca5"));
            startActivity(intent);
            return true;
        }
        if (id == R.id.id_terms){
            Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.freeprivacypolicy.com/live/0ce32c66-d762-4b5e-be00-688265c0f41e"));
            startActivity(intent);
            return true;
        }
        if (id == R.id.id_rate){
            return true;
        }
        if (id == R.id.id_more){
            return true;
        }
        if (id == R.id.id_share){
            return true;
        }
        return true;
    }

    public void beforeage18(View view) {

        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }

    public void afterage18(View view) {

        Intent intent=new Intent(MainActivity.this,SecondActivity2.class);
        startActivity(intent);
    }

    public void food(View view) {

        Intent intent=new Intent(MainActivity.this,FoodActivity.class);
        startActivity(intent);
    }
}