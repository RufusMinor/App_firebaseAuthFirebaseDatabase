package com.example.myapplication7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity4 extends AppCompatActivity {
    DatabaseReference mReference;
    FirebaseDatabase mData;
    EditText partyName, partyStory;
    Button btnCreate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        mReference=FirebaseDatabase.getInstance().getReference("post");

        partyName=(EditText) findViewById(R.id.nameParty);
        partyStory=(EditText) findViewById(R.id.storyParty);
        btnCreate=(Button) findViewById(R.id.create);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewPost(partyName.getText().toString(),partyStory.getText().toString());
            }
        });


    }

private void createNewPost(String partyName, String partyStory){
    String uid = FirebaseAuth.getInstance().getUid();
    Calendar nowDate=Calendar.getInstance();
    Date datePost1=nowDate.getTime();
    String datePost=new SimpleDateFormat("dd-MM-yyyy").format(datePost1);
    String key=new SimpleDateFormat("HH-mm-dd-MM-yyyy").format(datePost1);
    Post post=new Post(partyName,partyStory,datePost,key);
        mReference.child(partyName).setValue(post);
//    mReference.child(partyName).child("nameStory").setValue(partyStory);
//    mReference.child(partyName).child("datePost").setValue(datePost);
//    mReference.child(partyName).child("nameParty").setValue(partyName);



}





}