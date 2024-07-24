package com.softexer.protasker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class PostTaskDetails_Activity extends AppCompatActivity {
    ImageView groupItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_task_details);
        groupItems = findViewById(R.id.groupItems);
        groupItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(view);
            }
        });


    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.edit:
                        Toast.makeText(PostTaskDetails_Activity.this, "Edit clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.copy:
                        Toast.makeText(PostTaskDetails_Activity.this, "Copy clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.share:
                        Toast.makeText(PostTaskDetails_Activity.this, "Share clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.reminder:
                        showReminderDialog();
                        Toast.makeText(PostTaskDetails_Activity.this, "Reminder clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.cancel_task:
                        Toast.makeText(PostTaskDetails_Activity.this, "Cancel Task clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });
        popupMenu.show();
    }

    private void showReminderDialog() {
        View dialogView = getLayoutInflater().inflate(R.layout.remainder_customlayout, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        AlertDialog dialog = builder.create();

        Button cancelButton = dialogView.findViewById(R.id.button6);
        Button saveButton = dialogView.findViewById(R.id.button7);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText reminderTitle = dialogView.findViewById(R.id.reaminderTitleValue);
                String reminderText = reminderTitle.getText().toString();
                Toast.makeText(PostTaskDetails_Activity.this, "Reminder set: " + reminderText, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();
    }
    }

