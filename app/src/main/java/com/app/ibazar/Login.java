package com.app.ibazar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Login extends AppCompatActivity {

        @Override protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login);
        }

		//Signup Page Navigation
        public void signup(View view){
            Intent intent = new Intent(this,Registration.class);
            startActivity(intent);
        }
}
