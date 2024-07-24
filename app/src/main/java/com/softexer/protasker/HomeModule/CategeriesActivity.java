package com.softexer.protasker.HomeModule;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softexer.protasker.R;


public class CategeriesActivity extends AppCompatActivity {


    ImageView back;
    RecyclerView recyclerView;
    CategeriesListAdapter categeriesListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categeries);
        RecyclerViewActions();
        actions();
    }

    private void actions() {
        back = findViewById(R.id.profile_categeryback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategeriesActivity.this, HomeActivity.class));
            }
        });

    }

    private void RecyclerViewActions() {
        recyclerView = findViewById(R.id.categeries_recylerviewlist);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        categeriesListAdapter = new CategeriesListAdapter(this);
        recyclerView.setAdapter(categeriesListAdapter);
        categeriesListAdapter.notifyDataSetChanged();

    }
}