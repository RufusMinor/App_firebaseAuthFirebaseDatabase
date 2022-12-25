package com.example.myapplication7;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<Post> list;

    public UserAdapter(List<Post> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Post userPost= list.get(position);
        holder.titleText.setText(userPost.nameParty);
        Log.d("Post", "На держи с адаптера "+userPost.nameParty);
        holder.storyText.setText(userPost.nameStory);
        holder.dateText.setText(userPost.datePost);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{

        TextView titleText,storyText, dateText;

        public UserViewHolder(View itemView){
            super(itemView);
            titleText=(TextView)itemView.findViewById(R.id.textTitle);
            storyText=(TextView) itemView.findViewById(R.id.textPost);
            dateText=(TextView) itemView.findViewById(R.id.date);

        }
    }
}
