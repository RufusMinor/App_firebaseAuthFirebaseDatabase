package com.example.myapplication7;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication7.databinding.FragmentLentaBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Lenta extends Fragment {
LinearLayout container1;
private FragmentLentaBinding binding;
private FloatingActionButton add;
private TextView postText;
    private TextView titleText;
    DatabaseReference mDatabase;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_lenta, container, false);
        binding = FragmentLentaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        container1=(LinearLayout)root.findViewById(R.id.container);
        showPost(root);
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
        Intent intent=new Intent(getContext(),MainActivity4.class);
        startActivity(intent);



}
private void showPost(View view){
        mDatabase= FirebaseDatabase.getInstance().getReference().child("user");
        String uid = FirebaseAuth.getInstance().getUid();
        //Query query=mDatabase.orderByChild("post/");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
    public void onDataChange(@NonNull DataSnapshot snapshot){
                Log.d("DB","Метод работает ");
    for(DataSnapshot ds:snapshot.getChildren()){
        DataSnapshot postSnapshot=ds.child("post");
        for(DataSnapshot postSnapsh:postSnapshot.getChildren()){
            Log.d("DB","На "+postSnapsh.child("nameParty").getValue(String.class));
            String title=postSnapsh.child("nameParty").getValue(String.class);
            String text=postSnapsh.child("nameStory").getValue(String.class);
            addPost(title,text);
        }
//        String key= ds.getKey();
//        Query query=mDatabase.child(key).child("post");
//        String title=ds.child("nameParty").getValue(String.class);
//        String textPost=ds.child("nameStory").getValue(String.class);
//        Log.d("DB","На "+title+textPost);
//        addPost(title,textPost);
    }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error){
                Log.d("Date","ошибка");
            }
        });
}

    private void addPost(String title, String textPost){
        View view=getLayoutInflater().inflate(R.layout.card,null);
        titleText=(TextView)view.findViewById(R.id.textTitle);
        postText=(TextView)view.findViewById(R.id.textPost);
        titleText.setText(title);
        postText.setText(textPost);
        container1.addView(view);



    }
}