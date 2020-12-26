package com.alaminkarno.firbirebasedatabaseauthetication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PhoneActivity extends AppCompatActivity {

    EditText phoneET;
    Button loginBTN;
    public static String PHONE = "phone number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);


        autoLogin();

        init();

        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phone = phoneET.getText().toString().trim();

                if(phone.isEmpty()){
                    Toast.makeText(PhoneActivity.this, "Enter Phone number", Toast.LENGTH_SHORT).show();
                }
                else {

                    Intent intent = new Intent(PhoneActivity.this,VerifyActivity.class);
                    intent.putExtra(PHONE,phone);
                    startActivity(intent);
                }
            }
        });
    }

    private void autoLogin() {
        FirebaseAuth auth = FirebaseAuth.getInstance();

        if(auth.getCurrentUser() != null){

            Intent intent = new Intent(PhoneActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void init() {

        phoneET = findViewById(R.id.phoneET);
        loginBTN = findViewById(R.id.loginBTN);
    }
}