package com.example.siddhesh.collegeportal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by SIDDHESH on 29-12-2016.
 */

public class Login extends AppCompatActivity {
    EditText username,password;
    String uname,pass;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        pd = new ProgressDialog(this);
        pd.setTitle("Please Wait");
        pd.setMessage("Authenticating...");
        pd.setCancelable(false);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
    }
    public void submit(View view){
        uname = username.getText().toString();
        pass = password.getText().toString();
        if(!uname.equals("") || !pass.equals("")){
            pd.show();
            validateUser();
        } else {
            Toast.makeText(this,"Check Username or Password.",Toast.LENGTH_LONG).show();
        }
    }

    private void validateUser() {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("http://siddev.net76.net/portal").build();
        Validation validation = adapter.create(Validation.class);
        validation.validate(uname,pass,

                new Callback<Response>() {
                    @Override
                    public void success(Response result, Response response) {
                        //On success we will read the server's output using bufferedreader
                        //Creating a bufferedreader object
                        BufferedReader reader = null;

                        //An string to store output from the server
                        String output = "";

                        try {
                            //Initializing buffered reader
                            reader = new BufferedReader(new InputStreamReader(result.getBody().in()));

                            //Reading the output in the string
                            output = reader.readLine();
                            Toast.makeText(Login.this, ""+output, Toast.LENGTH_LONG).show();
                            if(output.contains("Successful")){
                                pd.dismiss();
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                finish();
                            }
                            pd.dismiss();

                        } catch (IOException e) {
                            e.printStackTrace();
                            pd.dismiss();
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {

                        pd.dismiss();
                    }
                });
    }

}
