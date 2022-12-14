package com.example.myapplication7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CreatePost extends AppCompatActivity {
    DatabaseReference mReference;
    FirebaseDatabase mData;
    EditText partyName, partyStory;
    Button btnCreate;
    private ImageView postPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createpost);

        mReference=FirebaseDatabase.getInstance().getReference("post");

        partyName=(EditText) findViewById(R.id.nameParty);
        partyStory=(EditText) findViewById(R.id.storyParty);
        btnCreate=(Button) findViewById(R.id.create);
        postPhoto=(ImageView)findViewById(R.id.postPhoto);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewPost(partyName.getText().toString(),partyStory.getText().toString());
            }
        });


    }

private void createNewPost(String partyName, String partyStory){
    Long tsLong = System.currentTimeMillis()/1000;
    int timeStamp = Integer.parseInt(tsLong.toString());

    String uid = FirebaseAuth.getInstance().getUid();
    Calendar nowDate=Calendar.getInstance();
    Date datePost1=nowDate.getTime();
    //String datePost=new SimpleDateFormat("yyyy-MM-dd"').format(datePost1);
    String datePost=new SimpleDateFormat("HH:mm  dd-MM-yyyy").format(datePost1);
    Post post=new Post(partyName,partyStory,timeStamp,datePost);
        mReference.child(partyName).setValue(post);
//    mReference.child(partyName).child("nameStory").setValue(partyStory);
//    mReference.child(partyName).child("datePost").setValue(datePost);
//    mReference.child(partyName).child("nameParty").setValue(partyName);



}





}