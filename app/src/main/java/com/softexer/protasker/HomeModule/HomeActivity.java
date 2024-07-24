package com.softexer.protasker.HomeModule;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softexer.protasker.CategeryViewModule.CategoryviewActivity;
import com.softexer.protasker.LocationModule.EnterlocationActivity;
import com.softexer.protasker.LocationModule.LoctionInputActivity;
import com.softexer.protasker.ProfileModule.ProfileActivity;
import com.softexer.protasker.R;

public class HomeActivity extends AppCompatActivity implements HomeCategeriesAdapter.onClickInterface {


    RecyclerView categery_recyclerView, popular_recylerview;
    HomeCategeriesAdapter homeCategeriesAdapter;
    HomePopularAdapter homePopularAdapter;
    ImageView profile,locationHome;
    EditText locationsearch;

    TextView seeall1, seeall2, seeall3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        actions();
        recyclerViewActions();
    }

    private void actions() {
        seeall2 = findViewById(R.id.see_all2);
        seeall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, CategeriesActivity.class));
            }
        });
        profile = findViewById(R.id.image4);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
            }
        });
        locationHome =findViewById(R.id.location_home);
        locationHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, LoctionInputActivity.class));

            }
        });
        locationsearch =findViewById(R.id.location_present);
        locationsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, EnterlocationActivity.class));

            }
        });
    }

    private void recyclerViewActions() {
        categery_recyclerView = findViewById(R.id.categeries_recylerview);
        popular_recylerview = findViewById(R.id.populars_recylerview);
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        categery_recyclerView.setLayoutManager(new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, true));
        homeCategeriesAdapter = new HomeCategeriesAdapter(this,this::onClickedCategorylist);
        categery_recyclerView.setAdapter(homeCategeriesAdapter);


        popular_recylerview.setLayoutManager(new GridLayoutManager(this, 1,GridLayoutManager.HORIZONTAL, true));
        homePopularAdapter = new HomePopularAdapter(this );
        popular_recylerview.setAdapter(homePopularAdapter);




    }

    @Override
    public void onClickedCategorylist(int position, View v) {
        startActivity(new Intent(HomeActivity.this, CategoryviewActivity.class));
    }
}