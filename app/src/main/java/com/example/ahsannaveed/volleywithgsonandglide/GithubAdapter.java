package com.example.ahsannaveed.volleywithgsonandglide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.net.URL;

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.GithubViewHolder> {
    private Context context;
    private  User[] data;

    public GithubAdapter(Context context, User[] data) {
        this.context=context;
        this.data=data;
    }

    @NonNull
    @Override
    public GithubViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.user_item_layout,viewGroup ,false );
        return new GithubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GithubViewHolder githubViewHolder, int i) {
        User user = data[i];
        githubViewHolder.textView.setText(user.getLogin());
        Glide.with(githubViewHolder.imageView.getContext()).load(user.getAvatarUrl()).into(githubViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    //1 Create view holder
    public class GithubViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView ;
        TextView textView;
        public GithubViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.user_text);
        }
    }
}
