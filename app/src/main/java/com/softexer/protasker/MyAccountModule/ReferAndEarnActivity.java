package com.softexer.protasker.MyAccountModule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.softexer.protasker.R;

public class ReferAndEarnActivity extends AppCompatActivity {
    TextView invitefrind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refer_and_earn);
        ImageView animatedImageView = findViewById(R.id.referandearnImage);
        Glide.with(this)
                .asGif()
                .load(R.drawable.rewardgif)
                .into(animatedImageView);




        invitefrind = findViewById(R.id.invite_Friends);
        invitefrind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ReferAndEarnActivity.this, Emergency_Contacts_Activity.class));
            }
        });
    }
}