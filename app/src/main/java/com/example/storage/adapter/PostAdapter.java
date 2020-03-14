package com.example.storage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.storage.R;
import com.example.storage.model.Post;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {
    private List<Post> postList;
    private Context context;

    public PostAdapter(List<Post> postList, Context context) {
        this.postList = postList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        if (postList.get(position).isIs_verify()) {
            holder.title.setText(postList.get(position).getTitle());
            holder.detail.setText(postList.get(position).getDetail());
            holder.date.setText(postList.get(position).getDate());
            Glide.with(context).load(postList.get(position).getImage_url())
                    .placeholder(R.color.colorPrimary)
                    .into(holder.image);
            holder.rl_user.setOnClickListener(view -> {
              /*  HashMap<String, Object> result = new HashMap<>();
                result.put("is_verify", false);
                FirebaseDatabase.getInstance().getReference("post").child("-M2Ng3UNRcffMH7n_kzo").updateChildren(result);*/
          /*  Intent intent = new Intent(context, UserDetailActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.putExtra("img",userDetails.get(position).getImage());
            intent.putExtra("name",userDetails.get(position).getName());
            intent.putExtra("sp_name",userDetails.get(position).getSp_name());
            intent.putExtra("rpt_type",userDetails.get(position).getRpt_type());
            context.startActivity(intent);*/
            });
        }else {

        }


    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title, detail, date;
        private ImageView image;
        private RelativeLayout rl_user;

        MyViewHolder(View view) {
            super(view);
            rl_user = view.findViewById(R.id.rl_user);
            title = view.findViewById(R.id.title);
            detail = view.findViewById(R.id.detail);
            date = view.findViewById(R.id.date);
            image = view.findViewById(R.id.image);

        }
    }
}
