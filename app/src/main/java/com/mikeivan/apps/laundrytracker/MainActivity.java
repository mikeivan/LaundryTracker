package com.mikeivan.apps.laundrytracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Machine> items = new ArrayList<Machine>();
    boolean isInit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ArrayList<String> items = new ArrayList<String>();



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "FAB clicked", Toast.LENGTH_SHORT).show();
                //items.add(new Machine("Washer", "A123", 43));
                //MachineAdapter adapter = new MachineAdapter(MainActivity.this, items);

                //ListView listView = (ListView) findViewById(R.id.list);

                //listView.setAdapter(adapter);
                //recreate();

                Intent i = new Intent(MainActivity.this, AddMachine.class);
                //i.putExtra("GymPosition", currentGym.getId());
                startActivity(i);
                //finish();
                }
            });


        if(isInit == false) {
            items.add(new Machine("Dryer", "A234", 45));
            items.add(new Machine("Washer", "D567", 32));
            items.add(new Machine("Washer", "DW379", 27));

            isInit = true;

            MachineAdapter adapter = new MachineAdapter(this, items);

            ListView listView = (ListView) findViewById(R.id.list);

            listView.setAdapter(adapter);

        }

        String iType = getIntent().getStringExtra("Type");
        String iName = getIntent().getStringExtra("Name");
        int iTime = getIntent().getIntExtra("Time", -1);

        if( iType != null && (iType.equals("Washer") || iType.equals("Dryer")) ) {
            Toast.makeText(MainActivity.this, "Intent recieved: " + iType + " " + iName + " " + iTime, Toast.LENGTH_LONG).show();
            items.add(new Machine(iType, iName, iTime));
            MachineAdapter adapter = new MachineAdapter(MainActivity.this, items);

            ListView listView = (ListView) findViewById(R.id.list);

            listView.setAdapter(adapter);

        }

    }
}
