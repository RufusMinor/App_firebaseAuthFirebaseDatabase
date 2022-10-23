package com.example.myapplication7;

import static com.example.myapplication7.MainActivity3.APP_PREFERENCE;
import static com.example.myapplication7.MainActivity3.APP_PREFERENCE_name;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity4 extends AppCompatActivity {
    DatabaseReference mReference;
    FirebaseDatabase mData;
    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        mReference=FirebaseDatabase.getInstance().getReference();

        text=(TextView) findViewById(R.id.nameParty);
        SharedPreferences sharedPreferences = getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE);
        String login1=sharedPreferences.getString(APP_PREFERENCE_name,"");
        text.setText(login1);
        mReference.child(login1).child("nameParty").setValue("Uh");



    }

public void onDataChange(DataSnapshot dataSnapshot){
        String value=dataSnapshot.child("rint").child("name").getValue(String.class);
        text.setText(value);
    }
}