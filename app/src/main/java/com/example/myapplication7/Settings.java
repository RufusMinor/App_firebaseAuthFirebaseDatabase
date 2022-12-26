package com.example.myapplication7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.myapplication7.databinding.FragmentSettingsBinding;


public class Settings extends Fragment {
    private FragmentSettingsBinding binding;
    private LinearLayout listProfile

String[]item_menu={"Мой профиль","Приватность","Язык","Настройки","Выход"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding=FragmentSettingsBinding.inflate(inflater,container,false);
        View root=binding.getRoot();

        listProfile= (LinearLayout) root.findViewById(R.id.itemProfile);

        return root;
    }


}
