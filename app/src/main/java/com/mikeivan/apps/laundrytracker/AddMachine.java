package com.mikeivan.apps.laundrytracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class AddMachine extends AppCompatActivity {

    String machine_type = "Washer";
    private EditText mEditName;
    private EditText mEditTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_machine);

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

                Intent i = new Intent(AddMachine.this, MainActivity.class);
                i.putExtra("Type", machine_type);
                i.putExtra("Name", mEditName.getText().toString().trim());
                i.putExtra("Time", Integer.parseInt(mEditTime.getText().toString().trim()));
                startActivity(i);
                finish();
            }
        });


        mEditName = (EditText) findViewById(R.id.edit_name);
        mEditTime = (EditText) findViewById(R.id.edit_time);

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_washer:
                if (checked)
                    machine_type = "Washer";
                    break;
            case R.id.radio_dryer:
                if (checked)
                    machine_type = "Dryer";
                    break;
        }
    }
}
