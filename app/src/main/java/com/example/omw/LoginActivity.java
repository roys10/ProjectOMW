package com.example.omw;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.omw.FirstEntryActivity.TEXT;

public class LoginActivity extends AppCompatActivity {
    private Button button;
    private EditText editText;
    public static final String SHARED_PREFS = "sharedPrefs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button = (Button) findViewById(R.id.button);
        editText= (EditText) findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPassword();
            }
        });
    }

    public void checkPassword(){
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        SharedPreferences.Editor editor = sharedPreferences.edit();

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);

        String password= sharedPreferences.getString(TEXT,"");
        String input=editText.getText().toString();

        if(input.equals(password)){

            Intent intent = new Intent(this, DataActivity.class);
            startActivity(intent);

        }else {
            Toast.makeText(this, "Wrong password! Please try again", Toast.LENGTH_SHORT).show();
        }
        finishActivity(1);
    }
}