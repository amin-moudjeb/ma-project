package com.example.aaa;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TasksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TasksFragment extends Fragment {

    public TasksFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);

        FloatingActionButton fab = view.findViewById(R.id.floatingActionButton);
        RecyclerView taskList = view.findViewById(R.id.noteList);
        taskList.setLayoutManager(new LinearLayoutManager(getContext()));

        loadTasks(taskList);

        fab.setOnClickListener(v -> {
            androidx.navigation.Navigation.findNavController(v)
                .navigate(R.id.action_tasksFragment_to_addTaskFragment);
        });

        return view;
    }

    private void loadTasks(RecyclerView taskList) {
        new Thread(() -> {
                List<Task> tasks = TaskDatabase.getInstance(getContext()).taskDao().getAllTasks();
                    getActivity().runOnUiThread(() -> {
                        TaskAdapter adapter = new TaskAdapter(tasks);
                        taskList.setAdapter(adapter);
                    });
                
                
        }).start();
    }
}