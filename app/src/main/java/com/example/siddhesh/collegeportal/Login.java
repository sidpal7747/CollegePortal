package com.example.siddhesh.collegeportal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by SIDDHESH on 29-12-2016.
 */

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }
    public void submit(View view){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
