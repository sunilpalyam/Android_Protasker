package com.softexer.protasker.MyAccountModule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.softexer.protasker.R;

public class Emergency_Contacts_Activity extends AppCompatActivity {
    TextView addcontact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_contacts);
        addcontact = findViewById(R.id.addtoContactButton);
        addcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Emergency_Contacts_Activity.this, Add_Emergency_contacts_Activity.class));
            }
        });
    }
}