package com.example.myapplication7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity3 extends AppCompatActivity {

    public TextInputEditText nameUser,pass,email,age,login;
    public Button btnReg, btn, btnSing;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    public SharedPreferences mSettings;
    public static final String APP_PREFERENCE="settings";
    public static final String APP_PREFERENCE_name="login";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mSettings=getSharedPreferences(APP_PREFERENCE,MODE_PRIVATE);


        login=(TextInputEditText)findViewById(R.id.loginEdit);
        String log=login.getText().toString();

        mAuth=FirebaseAuth.getInstance();
        mDatabase=FirebaseDatabase.getInstance().getReference(login.getText().toString());
        age=(TextInputEditText)findViewById(R.id.age);
        nameUser=(TextInputEditText) findViewById(R.id.nameEdit);
        email=(TextInputEditText) findViewById(R.id.emailEdit);
        pass=(TextInputEditText) findViewById(R.id.passEdit);

        btnReg=(Button) findViewById(R.id.regButton);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAccount(email.getText().toString(),pass.getText().toString());
                addUser(nameUser.getText().toString(),age.getText().toString(),email.getText().toString());

//Сохраняем в SharedPreference логин пользователя введенный при регистрации
                    String sharedLogin=login.getText().toString();
                    SharedPreferences.Editor editor=mSettings.edit();
                    editor.putString(APP_PREFERENCE_name,sharedLogin);
                    editor.apply();





            }
        });


//        btn=(Button)findViewById(R.id.button);
//        Intent intent=new Intent(MainActivity3.this,MainActivity4.class);
//        startActivity(intent);


    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser=mAuth.getCurrentUser();
    }


    private void createAccount(String email, String password){
                    mAuth.createUserWithEmailAndPassword(email,password)
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                   if (task.isSuccessful()) {
                                       Log.d("Tag","Создано нахуй!");
                                       Toast.makeText(MainActivity3.this, "Успешно!",
                                               Toast.LENGTH_SHORT).show();
                                    FirebaseUser user=mAuth.getCurrentUser();
                                    //updateUi(user);
                                        Intent intent=new Intent(MainActivity3.this,MainActivity5.class);
                                        startActivity(intent);
                                     }
                                }
                            });
    }

    private void addUser(String name,String age, String email) {
        mDatabase.child(login.getText().toString()).child("name").setValue(name);
        mDatabase.child(login.getText().toString()).child("age").setValue(age);
        mDatabase.child(login.getText().toString()).child("email").setValue(email);
        mDatabase.child(login.getText().toString()).child("nameParty").setValue(null);
    }





}