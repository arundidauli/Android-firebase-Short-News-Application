package com.example.storage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.storage.adapter.PostAdapter;
import com.example.storage.adapter.UserListAdapter;
import com.example.storage.model.Post;
import com.example.storage.model.UserDetail;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.prabhat1707.verticalpager.VerticalViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserListActivity extends AppCompatActivity {
    private static String TAG = UserListActivity.class.getSimpleName();
    private List<UserDetail> userDetailList;
    private List<Post> postList;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private FirebaseAuth firebaseAuth;
    private Context context;
    private RecyclerView recyclerView;
    private TextView empty_message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        context = UserListActivity.this;
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = firebaseDatabase.getReference("post");
        findViewById(R.id.fab).setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), AddImage.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });
        empty_message=findViewById(R.id.empty_message);
        recyclerView = findViewById(R.id.rv_user_list);

        userDetailList = new ArrayList<>();
        postList = new ArrayList<>();
        fetch_data();
    }

    private void fetch_data() {

        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    if (ds.exists()){
//                        String name = ds.child("name").getValue(String.class);
//                        String image = ds.child("image").getValue(String.class);
//                        Log.e(TAG, "key  :" + ds.getKey());
//                        Log.e(TAG, "Image Url  :" + image);
                        if (Objects.equals(ds.child("is_verify").getValue(Boolean.class), true)){
                            Post post = ds.getValue(Post.class);
                            postList.add(post);
                        }

                    }



                }
                SnapHelper snapHelper = new PagerSnapHelper();
                snapHelper.attachToRecyclerView(recyclerView);
                PostAdapter postAdapter = new PostAdapter(postList, getApplicationContext());
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(postAdapter);
                if (postList.isEmpty())
                    empty_message.setVisibility(View.VISIBLE);
                else
                    empty_message.setVisibility(View.GONE);



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", databaseError.toException());

            }
        };
        mDatabaseReference.addListenerForSingleValueEvent(eventListener);


    }


    private void setRecyclerView() {
        userDetailList = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.rv_user_list);
        UserListAdapter userListAdapter = new UserListAdapter(userDetailList, getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(userListAdapter);

    }
}
