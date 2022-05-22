package com.example.droidcafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    RadioGroup radioGroup = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.order_textView);
        textView.setText(message);

        radioGroup = (RadioGroup) findViewById(R.id.delivery_method);
        radioGroup.setOnCheckedChangeListener((radioGroup, i) -> {
            RadioButton radioButton = radioGroup.findViewById(i);
            switch (radioButton.getId()) {
                case R.id.sameday:
                    displayToast(getString(R.string.same_day_messenger_service));
                    break;
                case R.id.nextday:
                    displayToast(getString(R.string.next_day_ground_delivery));
                    break;
                case R.id.pickup:
                    displayToast(getString(R.string.pick_up));
                    break;
                default:
                    break;
            }

        });
        // Create the spinner
        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null)
            spinner.setOnItemSelectedListener(this);

        // Create ArrayAdapter using the string array and default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.labels_array,
                android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to spinner
        if (spinner != null)
            spinner.setAdapter(adapter);
    } // End of OnCreate()


    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}