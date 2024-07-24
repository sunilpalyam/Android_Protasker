package com.softexer.protasker.PostTaskModule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.softexer.protasker.PostTaskDetails_Activity;
import com.softexer.protasker.R;
import com.softexer.protasker.MyAccountModule.ReferAndEarnActivity;

public class TaskPosted_Activity extends AppCompatActivity {
    TextView viewtaskdetails,backtoHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_posted);
        viewtaskdetails =findViewById(R.id.viewtaskDetails);
        viewtaskdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TaskPosted_Activity.this, PostTaskDetails_Activity.class));
            }
        });
        backtoHome = findViewById(R.id.backtohome);
        backtoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TaskPosted_Activity.this, ReferAndEarnActivity.class));
            }
        });
    }
}