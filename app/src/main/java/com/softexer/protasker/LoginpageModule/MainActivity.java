package com.softexer.protasker.LoginpageModule;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.softexer.protasker.HomeModule.HomeActivity;
import com.softexer.protasker.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText mobilenumber;
    TextView verificationcode, skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actions();
    }

    private void actions() {
        mobilenumber = findViewById(R.id.mobilenumberenter);
        skip =  findViewById(R.id.skip);
        verificationcode = findViewById(R.id.verificationcode);


        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
            }
        });

        verificationcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobile = mobilenumber.getText().toString().trim();
                if (isValidMobile(mobile)) {
                    Toast.makeText(MainActivity.this, "Valid Mobile Number", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Invalid Mobile Number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidMobile(String mobile) {
        if (TextUtils.isEmpty(mobile)) {
            return false;
        }

        // Define a regex pattern for mobile numbers
        String regex = "^[+]?[0-9]{10,13}$"; // Example pattern for international numbers
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mobile);
        return matcher.matches();
    }
}
