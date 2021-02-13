package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences = getSharedPreferences("prefrences", MODE_PRIVATE);
        boolean firstStart= preferences.getBoolean("firstStart", true);
        if(firstStart) {
            openFirst_Password();
        }
    }

    public void openFirst_Password(){
        SharedPreferences preferences= getSharedPreferences("prefrences", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.apply();
        editor.putBoolean("firstStart", false);
        Intent intent = new Intent(this, FristTime_SetPassword.class);
        startActivity(intent);
    }


}