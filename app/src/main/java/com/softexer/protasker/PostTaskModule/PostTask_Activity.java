package com.softexer.protasker.PostTaskModule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.softexer.protasker.R;

public class PostTask_Activity extends AppCompatActivity {
    ImageView backgroundImage,backbutton;
    TextView posttask,tasktitle,reviews,total,hourly,increment,value,decrement,postTask,workersIncrement,workersValue,workersDecrement,
    letterstenplus,letterstwntyplus;

    EditText taskTitleValue,amount,taskdiscription,location,attachments;
    private int currentValue = 1; // Initial value as per your layout
    private Drawable activeDrawable, inactiveDrawable;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_task);
        actions();
    }

    private void actions() {
        backgroundImage = findViewById(R.id.backgroundImage);
        backbutton = findViewById(R.id.backButton);
        posttask = findViewById(R.id.postTaskTitle);
        reviews = findViewById(R.id.reviews);
        total = findViewById(R.id.total);
        hourly = findViewById(R.id.hourlyrate);
        increment = findViewById(R.id.increment);
        value = findViewById(R.id.value);
        decrement = findViewById(R.id.decrement);
        postTask = findViewById(R.id.posttaskbutton);
        tasktitle = findViewById(R.id.taskTitle);
        taskTitleValue = findViewById(R.id.taskTitleValue);
        amount = findViewById(R.id.amount);
        taskdiscription  = findViewById(R.id.taskdiscription);
        location = findViewById(R.id.location);
        attachments = findViewById(R.id.attachments);
        workersIncrement = findViewById(R.id.workersIncrement);
        workersDecrement = findViewById(R.id.workersDecrement);
        workersValue = findViewById(R.id.workersValue);
        letterstenplus = findViewById(R.id.letters_tenplus);
        letterstwntyplus = findViewById(R.id.letters_Twenty_plus);


        // Set initial value
        value.setText(String.valueOf(currentValue));

        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentValue > 1) {
                    currentValue--;
                    value.setText(String.valueOf(currentValue));
                }
            }
        });

        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentValue++;
                value.setText(String.valueOf(currentValue));
            }
        });
        postTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PostTask_Activity.this, TaskPosted_Activity.class));
            }
        });
        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActiveButton(total);
                setInactiveButton(hourly);
            }
        });

        hourly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActiveButton(hourly);
                setInactiveButton(total);
            }
        });
        activeDrawable = ContextCompat.getDrawable(this, R.drawable.active_button);
        inactiveDrawable = ContextCompat.getDrawable(this, R.drawable.inactive_button);


        // Set initial value
        workersValue.setText(String.valueOf(currentValue));

        workersDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentValue > 1) {
                    currentValue--;
                    workersValue.setText(String.valueOf(currentValue));
                }
            }
        });

        workersIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentValue++;
                workersValue.setText(String.valueOf(currentValue));
            }
        });
        tasktitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        taskTitleValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int length = s.length();
                letterstenplus.setText(String.valueOf(length));

                if (length < 10) {
                    letterstenplus.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                } else {
                    letterstenplus.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }



    private void setActiveButton(TextView total) {
        total.setBackground(activeDrawable);
    }
    private void setInactiveButton(TextView hourly) {
        hourly.setBackground(inactiveDrawable);
    }
}