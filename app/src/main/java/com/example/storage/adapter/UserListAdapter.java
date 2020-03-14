package com.example.storage.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.example.storage.UserDetailActivity;
import com.example.storage.UserListActivity;
import com.example.storage.model.UserDetail;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder> {
    private List<UserDetail> userDetails;
    private Context context;

    public UserListAdapter(List<UserDetail> userDetails, Context context) {
        this.userDetails = userDetails;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(userDetails.get(position).getName());
        holder.sp_name.setText(userDetails.get(position).getSp_name());
        holder.rpt_type.setText(userDetails.get(position).getRpt_type());
        Glide.with(context).load(userDetails.get(position).getImage())
                .placeholder(R.color.colorPrimary)
                .into(holder.image);

        holder.rl_user.setOnClickListener(view -> {
          /*  Intent intent = new Intent(context, UserDetailActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.putExtra("img",userDetails.get(position).getImage());
            intent.putExtra("name",userDetails.get(position).getName());
            intent.putExtra("sp_name",userDetails.get(position).getSp_name());
            intent.putExtra("rpt_type",userDetails.get(position).getRpt_type());
            context.startActivity(intent);*/
        });


    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name, sp_name,rpt_type;
        private ImageView image;
        private RelativeLayout rl_user;

        MyViewHolder(View view) {
            super(view);
            rl_user =  view.findViewById(R.id.rl_user);
            name =  view.findViewById(R.id.name);
            sp_name = view.findViewById(R.id.sp_name);
            rpt_type = view.findViewById(R.id.rpt_type);
            image = view.findViewById(R.id.image);

        }
    }
    @Override
    public int getItemCount() {
        return userDetails.size();
    }
}
