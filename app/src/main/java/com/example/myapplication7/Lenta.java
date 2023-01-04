package com.example.myapplication7;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication7.databinding.FragmentLentaBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;


public class Lenta extends Fragment {
LinearLayout container1;
private FragmentLentaBinding binding;
private FloatingActionButton add;
private TextView postText;
private TextView titleText;
    DatabaseReference mDatabase;
private RecyclerView recyclerView;
private List<Post> result;
private PostAdapter userAdapter;
private EditText email;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentLentaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        email=(EditText)root.findViewById(R.id.editTextTextEmailAddress);

        result=new ArrayList<>();
        recyclerView=(RecyclerView)root.findViewById(R.id.recyclerLenta);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        userAdapter=new PostAdapter(result);
        recyclerView.setAdapter(userAdapter);


        mDatabase= FirebaseDatabase.getInstance().getReference().child("post");
        updateList(mDatabase);
        add=(FloatingActionButton)root.findViewById(R.id.floating_action_button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addParty();
            }
        });
        return  root;
    }

    private  void addParty(){
        Intent intent=new Intent(getContext(), CreatePost.class);
        startActivity(intent);



}


    private void updateList(DatabaseReference mDatabase){
        Log.d("Post", "в метод заходит");
        Query query=mDatabase.orderByChild("datePost");
        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                result.add(snapshot.getValue(Post.class));
                userAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                for(DataSnapshot postSnapshot:snapshot.getChildren()){
                    Post post= postSnapshot.getValue(Post.class);
                    String s=post.datePost;
                    email.setText(post.nameParty);
                    Log.d("Post","На "+s);


                }

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

//    private int getItemIndex(Post post){
//        int index=-1;
//        for(int i=0;i<result.size();i++) {
//            if(result.get(i).key.equals(post.key));
//        }
//        }
//    }
}