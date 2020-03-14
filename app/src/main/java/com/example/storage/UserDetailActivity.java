package com.example.storage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class UserDetailActivity extends AppCompatActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        intent=getIntent();

        ImageView image_profile=findViewById(R.id.image);
        TextView name=findViewById(R.id.name);
        TextView sp_name=findViewById(R.id.sp_name);
        TextView rpt_type=findViewById(R.id.rpt_type);
        if(getIntent() != null && getIntent().getExtras() != null){
            Glide.with(this).load(intent.getStringExtra("img")).into(image_profile);
            name.setText(intent.getStringExtra("name"));
            sp_name.setText(intent.getStringExtra("sp_name"));
            rpt_type.setText(intent.getStringExtra("rpt_type"));
        }



        findViewById(R.id.save).setOnClickListener(view -> {
            intent = new Intent(getApplicationContext(), UserListActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });
    }
}
