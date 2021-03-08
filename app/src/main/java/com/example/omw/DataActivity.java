package com.example.omw;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class DataActivity extends AppCompatActivity {
    private EditText editTextPhone;
    private Button setButton;
    final int SEND_SMS_REQUEST_CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        setButton = (Button) findViewById(R.id.phoneButton);
        //setButton.setEnabled(false);

        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
//                    if(checkSelfPermission(Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED){
//                        sendSMS();
//                    }else{
//                        requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 1);
//                    }
//                }

                if(checkPremission(Manifest.permission.SEND_SMS)){
                    setPhoneNum();
                }else{
                    ActivityCompat.requestPermissions(DataActivity.this,
                            new String[]{Manifest.permission.SEND_SMS},
                            SEND_SMS_REQUEST_CODE);
                }
            }
        });

    }

    private void setPhoneNum(){
//        String phoneNum = editTextPhone.getText().toString();
//        try {
//            SmsManager smsManager = SmsManager.getDefault();
//            smsManager.sendTextMessage(phoneNum,null,"hi", null,null);
//            Toast.makeText(this, "Message sent", Toast.LENGTH_SHORT).show();
//        } catch (Exception e){
//            e.printStackTrace();
//            Toast.makeText(this, "failed to send", Toast.LENGTH_SHORT).show();
//        }
        SharedPreferences sharedPreferences = getSharedPreferences("phoneNum", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("phoneNum", editTextPhone.getText().toString());
        editor.apply();
        editTextPhone.setHint(sharedPreferences.getString("phoneNum",""));
        String phoneNum = editTextPhone.getText().toString();


    }

    public boolean checkPremission(String premission){
        int check = ContextCompat.checkSelfPermission(this,premission);
        return (check == PackageManager.PERMISSION_GRANTED);
    }



}