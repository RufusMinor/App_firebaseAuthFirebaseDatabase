package com.example.myapplication7.Profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication7.R;
import com.example.myapplication7.databinding.FragmentSettingsBinding;


public class Profile extends Fragment {
    private FragmentSettingsBinding binding;
    private ListView listProfile;

    String[] item_menu = {"Мой профиль", "Приватность", "Язык", "Настройки", "Выход"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        listProfile = (ListView) root.findViewById(R.id.lvMain);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.custom_list_item, item_menu);

        listProfile.setAdapter(adapter);

        listProfile.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 0) {
                    replaceFragment(new MyProfile());
                }
                else if (i == 1) {
                    replaceFragment(new PrivateSettings());
                }
                else if (i == 2) {
                    replaceFragment(new Language());
                }
                else if (i == 3) {
                    replaceFragment(new Settings());
                }
                else if (i == 4) {
                    replaceFragment(new Exit());
                }

            }
        });


        return root;

    }

    private void replaceFragment(Fragment fragment) {

        FragmentTransaction transaction = getFragmentManager().beginTransaction(); // Или getSupportFragmentManager(), если используете support.v4
        transaction.replace(R.id.frameLayout, fragment); // Заменяете вторым фрагментом. Т.е. вместо метода `add()`, используете метод `replace()`
        transaction.addToBackStack(null); // Добавляете в backstack, чтобы можно было вернутся обратно

        transaction.commit();


    }
}
