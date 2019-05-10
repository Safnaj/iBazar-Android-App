package com.app.ibazar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.ibazar.model.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * @author Safnaj
 * @project iBazar
 **/

public class Registration extends AppCompatActivity {

    //DatabaseReference databaseReference;
    private Task<Void> firebase;
    private DatabaseReference db;

    final static String DB_URL = "https://ibazar-17155.firebaseio.com/";

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
//        databaseReference.getDatabase().getReferenceFromUrl("https://ibazar-17155.firebaseio.com/");

    }

    EditText name;
    EditText username;
    EditText email;
    EditText phone;
    EditText password;
    EditText password2;
    Button signup;


    public void signup(View view){

        name = (EditText)findViewById(R.id.name);
        username = (EditText)findViewById(R.id.username);
        email = (EditText)findViewById(R.id.email);
        phone = (EditText)findViewById(R.id.phone);
        password = (EditText)findViewById(R.id.password);
        password2 = (EditText)findViewById(R.id.password2);
        signup = (Button)findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startSignUp();

            }
        });
    }
    public void startSignUp(){

        if(Validation.checkEmpty(name) && Validation.checkEmpty(username) && Validation.checkEmpty(email) &&
                Validation.checkEmpty(phone) && Validation.checkEmpty(password) && Validation.checkEmpty(password2)) {

            Toast.makeText(Registration.this, "Please Fill All the Fields..!", Toast.LENGTH_SHORT).show();
        }
        if(Validation.validatePhone(phone) && Validation.numbersOnly(phone)){
            Toast.makeText(Registration.this, "Incorrect Phone Number..!", Toast.LENGTH_SHORT).show();
        }
        if((!password.getText().toString().equals(password2.getText().toString()))){
            Toast.makeText(Registration.this, "Passwords Not Matched..!", Toast.LENGTH_SHORT).show();
        }

        else{

            //DatabaseReference db = FirebaseDatabase.getInstance().getReferenceFromUrl("https://ibazar-17155.firebaseio.com/");
//            DatabaseReference users = db.child("Name");
//            users.setValue("Safnaj");

            User user = new User();
            user.setName(name.getText().toString());
            user.setUsername(username.getText().toString());
            user.setEmail(email.getText().toString());
            user.setPhone(phone.getText().toString());
            user.setPassword(password.getText().toString());
            user.setPassword2(password2.getText().toString());

            //databaseReference.child("Users").setValue(user);

            db =  FirebaseDatabase.getInstance().getReferenceFromUrl("https://ibazar-17155.firebaseio.com/");
            firebase = db.child("Users").setValue(user);

			//Toast Message
            Toast.makeText(Registration.this, "Registered Successfully..!", Toast.LENGTH_SHORT).show();

        }

    }

}
