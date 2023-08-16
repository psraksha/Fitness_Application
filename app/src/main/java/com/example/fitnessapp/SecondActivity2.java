package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class SecondActivity2 extends AppCompatActivity {


    int[] newArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        Toolbar toolbar=findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        newArray=new int[]{
                R.id.mountain_climber,R.id.basic_crunches,R.id.bench_dips,R.id.bicycle_crunches,R.id.leg_raises,R.id.alt_heal_touch,R.id.leg_up_crunches,R.id.sit_up, R.id.alt_vups,R.id.plank_rotation,R.id.plank_with_ll,R.id.russian_twist,R.id.bridge_pose,R.id.vertical_lc,R.id.wind_mill,
        };
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
            return true;
        }
        if (id == R.id.id_terms){
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

    public void ImageButtonClicked(View view) {

        for (int i=0;i<newArray.length;i++){
            if (view.getId() == newArray[i]){
                int value=i+1;
                Log.i("First",String.valueOf(value));
                Intent intent=new Intent(SecondActivity2.this,ThirdActivity2.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);
            }
        }
    }
}