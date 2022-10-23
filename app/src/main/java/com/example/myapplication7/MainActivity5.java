package com.example.myapplication7;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication7.databinding.ActivityMain5Binding;

public class MainActivity5 extends AppCompatActivity {
    ActivityMain5Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain5Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new Lenta());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {

                case R.id.Lenta:
                    replaceFragment(new Lenta());
                    break;
                case R.id.Favoriets:
                    replaceFragment(new Star());
                    break;
                case R.id.my_company:
                    replaceFragment(new Group());
                    break;
                case R.id.setting:
                    replaceFragment(new Settings());
                    break;
            }
            return true;

        });
    }

    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();


    }


}