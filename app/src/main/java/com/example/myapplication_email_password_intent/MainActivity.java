package com.example.myapplication_email_password_intent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btn_login;
    EditText emailid;
    EditText password;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        builder = new AlertDialog.Builder(this);
        //fetching button ids
        btn_login= (Button) findViewById(R.id.btn_login);
        emailid=(EditText) findViewById(R.id.editText_emailid);
        password=(EditText) findViewById(R.id.editText_password);

        // implementing login click event and navigate to another activity via intent
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(emailid.getText().toString().equals("admin@gmail.com") && password.getText().toString().equals("123"))
                {
                    try {
                        Intent i = new Intent(getApplicationContext(), MainPage.class);
                        startActivity(i);
                    }
                    finally {
                        finish();
                    }

                }else
                {
                    builder.setMessage("Invalid Email or Password");
                    //Creating dialog box
                    AlertDialog alert = builder.create();
                    //Setting the title manually
                    alert.setTitle("Invalid");
                    alert.show();
                }


            }
        });
    }
}