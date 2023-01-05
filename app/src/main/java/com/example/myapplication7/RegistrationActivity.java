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

public class RegistrationActivity extends AppCompatActivity {

    public TextInputEditText nameUser,pass,email,lastName,login,phoneNumber;
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


        lastName=(TextInputEditText)findViewById(R.id.lastName);

        mAuth=FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference("user");
        phoneNumber=(TextInputEditText)findViewById(R.id.phoneNumber);
        nameUser=(TextInputEditText) findViewById(R.id.nameEdit);
        email=(TextInputEditText) findViewById(R.id.emailEdit);
        pass=(TextInputEditText) findViewById(R.id.passEdit);

        btnReg=(Button) findViewById(R.id.regButton);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAccount(email.getText().toString(),pass.getText().toString(),nameUser.getText().toString(),lastName.getText().toString(),phoneNumber.getText().toString());
//Сохраняем в SharedPreference логин пользователя введенный при регистрации
//                    String sharedLogin=login.getText().toString();
//                    SharedPreferences.Editor editor=mSettings.edit();
//                    editor.putString(APP_PREFERENCE_name,sharedLogin);
//                    editor.apply();





            }
        });




    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser=mAuth.getCurrentUser();
    }


    private void createAccount(String email, String password,String lastName,String phoneNumber,String name){
                    mAuth.createUserWithEmailAndPassword(email,password)
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                   if (task.isSuccessful()) {

                                       Log.d("Tag","Создано нахуй!");
                                       Toast.makeText(RegistrationActivity.this, "Успешно!",
                                               Toast.LENGTH_SHORT).show();
                                    FirebaseUser user=mAuth.getCurrentUser();
                                    //updateUi(user);
                                       String uid = FirebaseAuth.getInstance().getUid();
                                       User userReg=new User(name,email,lastName,phoneNumber);
                                       mDatabase.child(uid).setValue(userReg);
                                        Intent intent=new Intent(RegistrationActivity.this,MainActivity5.class);
                                        startActivity(intent);
                                     }
                                }
                            });
    }






}