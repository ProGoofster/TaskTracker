package com.example.tasktracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.tasktracker.model.Task;

import java.util.LinkedList;

public class TopFragment extends Fragment {

    LinkedList<Task> tasks;

    EditText taskET;
    EditText ownerET;

    public TopFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_fragment, container, false);
        tasks = new LinkedList<>();
        taskET = view.findViewById(R.id.enterEdit);
        ownerET = view.findViewById(R.id.ownerEdit);


        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(v -> {
            String t = taskET.toString();
            String o = ownerET.toString();

            ContentValues values = new ContentValues();
            values.put(MyTaskContentProvider.COL_TASK, t);
            values.put(MyTaskContentProvider.COL_OWN, o);
            getActivity().getContentResolver().insert(MyTaskContentProvider.CONTENT_URI, values);

            Cursor c = getActivity().getContentResolver().query(MyTaskContentProvider.CONTENT_URI,
                    null, null, null, null);


            if (c == null) return;

            c.moveToFirst();
            if(c.getCount() > 0) {
                while (!c.isAfterLast()) {
                    String ta = c.getString(1);
                    String oa = c.getString(2);
                    String message = ta + " -- " + oa;
                    c.moveToNext();
                }
            }
        });

        return view;
    }
}
