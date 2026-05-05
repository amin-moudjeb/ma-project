package com.example.aaa;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link settingsfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class settingsfragment extends Fragment {

    public settingsfragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settingsfragment, container, false);


    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String email = getActivity().getIntent().getStringExtra("email");
        TextView textView = view.findViewById(R.id.textView18);
        textView.setText(email);
        Button logoutbtn = view.findViewById(R.id.logoutbtn);
        logoutbtn.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), loginActivity.class);
            startActivity(intent);
        });
    }
}