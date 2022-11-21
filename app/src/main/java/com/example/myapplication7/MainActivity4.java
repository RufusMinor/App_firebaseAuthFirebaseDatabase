package com.example.myapplication7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity4 extends AppCompatActivity {
    DatabaseReference mReference;
    FirebaseDatabase mData;
    EditText partyName, partyStory;
    Button btnCreate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        mReference=FirebaseDatabase.getInstance().getReference();

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

    mReference.child("Post").child(uid).child(partyName).child("nameParty").setValue(partyName);
    mReference.child("Post").child(uid).child(partyName).child("nameStory").setValue(partyStory);

}





}