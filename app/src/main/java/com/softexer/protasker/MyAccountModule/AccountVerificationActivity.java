package com.softexer.protasker.MyAccountModule;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.softexer.protasker.R;


public class AccountVerificationActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView title;

    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_verification);

        findId();
        actions();
    }

    private void findId() {

        toolbar =findViewById(R.id.toolbar);
        back = toolbar.findViewById(R.id.backbtn);
        title = toolbar.findViewById(R.id.title);
        title.setText(getString(R.string.account_verification));
    }


    private void actions() {

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
       /* Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
        System.exit(0);*/
        finish();

    }

}