package com.app.ibazar;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;

public class Validation {

    public static boolean checkEmpty(EditText txt) {

        if (txt.getText().toString().isEmpty()) {

            //txt.setError("Please Fill this Fields..!");
            //Toast.makeText(, "Connection Timed Out", Toast.LENGTH_SHORT).show();

            return true;
        }
        return false;
    }

    public static boolean validatePhone(EditText txt) {
	
		//Phone Number Validation using Regular Expression
        if (txt.getText().toString().matches("^(\\d{10})")) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean numbersOnly(EditText txt) {
        if (txt.getText().toString().matches("[0-9]+")) {
            return true;
        } else {
            return false;
        }
    }

}
