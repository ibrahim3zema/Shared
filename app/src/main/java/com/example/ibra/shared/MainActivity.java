package com.example.ibra.shared;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    EditText text;
    SharedPreferences preferences;
    SharedPreferences.Editor edit;
    HashSet<String> ar;
    ListView listView;
    Set<String> dat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        text = (EditText) findViewById(R.id.editText);
        listView = (ListView) findViewById(R.id.listView);
        dat = new HashSet<>();
        ar = new HashSet<>();
        preferences = getSharedPreferences("data", MODE_PRIVATE);
        edit = preferences.edit();
    }

    public void setData(View view) {
        ar.add(text.getText().toString());
        edit.putStringSet("name", ar);
        edit.commit();
        Toast.makeText(MainActivity.this, "save", Toast.LENGTH_SHORT).show();
        text.setText("");
    }

    public void getData(View view) {
        dat = preferences.getStringSet("name", null);
        String[] arr = dat.toArray(new String[dat.size()]);
        List<String> list= Arrays.asList(arr);
        ArrayAdapter adpter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adpter);
    }


}
