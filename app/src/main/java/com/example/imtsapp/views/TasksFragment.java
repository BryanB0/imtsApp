package com.example.imtsapp.views;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import com.example.imtsapp.MainActivity;
import com.example.imtsapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TasksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TasksFragment extends Fragment {

    public TasksFragment() {
        // Required empty public constructor
    }

    public static TasksFragment newInstance() {
        TasksFragment fragment = new TasksFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(
                R.layout.fragment_tasks, container, false
        );
    }

    private ListView listView;
    private ArrayAdapter<String> tasksAdapter;
    private FloatingActionButton floatingActionButton;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Init variables
        listView = view.findViewById(R.id.tasks_list_view);
        floatingActionButton = view.findViewById(R.id.add_task_button);
        // Alter
        ((MainActivity) requireActivity()).addTask("Cours Android");
        floatingActionButton.setOnClickListener(view1 -> openDialogAddTask());
        tasksAdapter = new ArrayAdapter<>(
                requireActivity(),
                R.layout.task_item,
                R.id.task_title_text_view,
                ((MainActivity) requireActivity()).getTasks()
        );
        listView.setAdapter(tasksAdapter);
    }

    private void openDialogAddTask() {
        EditText editText = new EditText(getContext());
        AlertDialog dialog = new AlertDialog
                .Builder(requireActivity())
                .setTitle("Ajouter une tâche")
                .setMessage("Que souhaitez-vous faire ?")
                .setView(editText)
                .setPositiveButton("Ajouter",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tasksAdapter.add(editText.getText().toString());
                    }
                })
                .setNegativeButton("Annuler", null)
                .create();
        dialog.show();
    }
}