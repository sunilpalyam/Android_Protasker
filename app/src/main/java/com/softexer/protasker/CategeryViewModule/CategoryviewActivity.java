package com.softexer.protasker.CategeryViewModule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.softexer.protasker.HomeModule.HomeActivity;
import com.softexer.protasker.PostTaskModule.PostTask_Activity;
import com.softexer.protasker.R;


public class CategoryviewActivity extends AppCompatActivity {


    TextView about,gallery, reviews,postYourTask;
    ImageView back;

    RecyclerView recyclerView_imgs_list;

    CategeryviewImagesAdapter categeryviewImagesAdapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoryview);
        about = findViewById(R.id.about_tittle);
        gallery = findViewById(R.id.gallery_tittle);
        reviews = findViewById(R.id.reviews_tittle);
        postYourTask= findViewById(R.id.postyourtask_text);
        back =  findViewById(R.id.profile_categeryback);
        RecyclerViewActions();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoryviewActivity.this, HomeActivity.class));
            }
        });


        FragmentManager fragmentManager = getSupportFragmentManager();

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragmentManager.beginTransaction()
                        .replace(R.id.framelayout_views, AboutFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
            }
        });
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.framelayout_views, GalleryFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
            }
        });

        reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.framelayout_views, ReviewFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
            }
        });
        postYourTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoryviewActivity.this, PostTask_Activity.class));
            }
        });
    }

    private void RecyclerViewActions() {
        recyclerView_imgs_list = findViewById(R.id.categery_recycler);

        recyclerView_imgs_list.setLayoutManager(new GridLayoutManager(this, 1,GridLayoutManager.HORIZONTAL, true));
        categeryviewImagesAdapter = new CategeryviewImagesAdapter(this );
        recyclerView_imgs_list.setAdapter(categeryviewImagesAdapter);

    }

}