package com.example.omw;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FirstEntryActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT= "text";
    private String text;
    public static final String EXTRA_TEXT = "com.example.omw.EXTRA_TEXT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_entry);
        editText = (EditText) findViewById(R.id.editPassword);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setPassword();
            }
        });

//        loadPassword();
    }

    public void setPassword(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TEXT, editText.getText().toString());
        editor.apply();
        Toast.makeText(this,"PASSWORD SET", Toast.LENGTH_SHORT).show();

        finish();
    }

//    public void loadPassword(){
//        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
//        text = sharedPreferences.getString(TEXT,"");
//    }
}