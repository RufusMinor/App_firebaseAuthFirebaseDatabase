package com.example.myapplication7;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.example.myapplication7.databinding.FragmentLentaBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class Lenta extends Fragment {
LinearLayout container;
private FragmentLentaBinding binding;
private FloatingActionButton add;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Lenta() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_lenta, container, false);
        binding = FragmentLentaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
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
}