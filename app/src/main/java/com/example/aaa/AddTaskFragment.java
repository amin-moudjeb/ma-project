package com.example.aaa;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddTaskFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddTaskFragment extends Fragment {

    public AddTaskFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_task, container, false);
        
        EditText titleInput = view.findViewById(R.id.editTextText);
        View fabSave = view.findViewById(R.id.fabSaveTask);
        
        fabSave.setOnClickListener(v -> {
            String title = titleInput.getText().toString();
                new Thread(() -> {
                    TaskDatabase.getInstance(getContext()).taskDao().insert(new Task(title));
                        getActivity().runOnUiThread(() -> {
                            androidx.navigation.Navigation.findNavController(v).navigateUp();
                        });
                }).start();
            
        });
        
        return view;
    }
}